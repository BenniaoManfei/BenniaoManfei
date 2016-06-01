package service.wx.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.bean.wx.MaterialNews;
import model.bean.wx.WxAccessToken;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import service.wx.WxService;
import ResultInfo.ResultInfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import common.constant.WxConstants;
import common.util.http.MediaUploadRequestExecutor;
import common.util.http.RequestExecutor;
import common.util.http.SimpleGetRequestExecutor;
import common.util.http.SimplePostRequestExecutor;

public class WxServiceImpl implements WxService {

	/**
	 * 全局的是否正在刷新access token的锁
	 */
	protected final Object globalAccessTokenRefreshLock = new Object();

	public boolean checkSignature(String timestamp, String nonce,
			String signature) {
		List<String> list = new ArrayList<String>();
		list.add(WxConstants.TOKEN);
		list.add(timestamp);
		list.add(nonce);

		// 1） 将token、timestamp、nonce三个参数进行字典序排序
		// Arrays.sort(arr);
		Collections.sort(list);

		// 2） 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer buffer = new StringBuffer();
		for (String string : list) {
			buffer.append(string);
		}
		String sha1Str = DigestUtils.sha1Hex(buffer.toString());

		// 3）开发者获得加密后的字符串可与signature对比，标识该请求来自微信
		boolean isWx = sha1Str.equals(signature);

		return isWx;
	}

	public WxAccessToken getToken() {
		synchronized (globalAccessTokenRefreshLock) {
			WxAccessToken token = WxAccessToken.getToken();
			if (token != null) {
				return token;
			}

			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
					+ "&appid="
					+ WxConstants.APPID
					+ "&secret="
					+ WxConstants.APPSECRET;
			RequestExecutor<String, String> requestExecutor = new SimpleGetRequestExecutor();
			CloseableHttpClient httpclient = HttpClients.createDefault();

			try {
				String response = requestExecutor.execute(httpclient, null,
						url, null);

				return WxAccessToken.fromJson(response);

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String[] getCallbackip() {
		WxAccessToken access_token = getToken();
		if (access_token == null) {
			return null;
		}

		String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?"
				+ "access_token=" + access_token.getAccessToken();
		RequestExecutor<String, String> requestExecutor = new SimpleGetRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			String response = requestExecutor.execute(httpclient, null, url,
					null);
			JSONObject demoJson = JSONObject.parseObject(response);
			Integer errcode = demoJson.getIntValue("errcode");
			if (errcode != null && errcode.intValue() != 0) {
				return null;
			}
			JSONArray jsonArray = demoJson.getJSONArray("ip_list");
			String[] a = new String[1];
			a = jsonArray.toArray(a);

			return a;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultInfo<Object> createMenu(String menu) {

		ResultInfo<Object> result = new ResultInfo<Object>();

		WxAccessToken access_token = getToken();
		if (access_token == null) {
			result.code = 0;
			result.msg = "获取ACCESS_TOKEN失败!";

			return result;
		}

		RequestExecutor<String, String> executor = new SimplePostRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ access_token.getAccessToken();

		// menu =
		// "{\"button\":[{\"type\":\"click\",\"name\":\"项目管理\",\"key\":\"20_PROMANAGE\"},{\"type\":\"click\",\"name\":\"机构运作\",\"key\":\"30_ORGANIZATION\"},{\"name\":\"日常工作\",\"sub_button\":[{\"type\":\"click\",\"name\":\"待办工单\",\"key\":\"01_WAITING\"},{\"type\":\"click\",\"name\":\"已办工单\",\"key\":\"02_FINISH\"},{\"type\":\"click\",\"name\":\"我的工单\",\"key\":\"03_MYJOB\"},{\"type\":\"click\",\"name\":\"公告消息箱\",\"key\":\"04_MESSAGEBOX\"},{\"type\":\"click\",\"name\":\"签到\",\"key\":\"05_SIGN\"}]}]}";
		System.out.println(menu);
		try {
			String response = executor.execute(httpclient, null, url, menu);

			System.out.println(response);
			JSONObject demoJson = JSONObject.parseObject(response);
			Integer errcode = demoJson.getIntValue("errcode");
			if (errcode != null && errcode.intValue() != 0) {
				result.code = -errcode;
				result.msg = demoJson.getString("errmsg");

				return result;
			} else {
				result.code = 1;
				result.msg = "菜单创建成功!";

				return result;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		} catch (IOException e) {
			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误!";
			return result;
		}

	}

	

	
	

	
 
}
