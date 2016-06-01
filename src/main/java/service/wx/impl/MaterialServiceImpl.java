package service.wx.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.bean.wx.MaterialNews;
import model.bean.wx.WxAccessToken;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONObject;

import common.util.http.MediaUploadRequestExecutor;
import common.util.http.RequestExecutor;
import common.util.http.SimpleGetRequestExecutor;
import common.util.http.SimplePostRequestExecutor;
import ResultInfo.ResultInfo;
import service.wx.MaterialService;
import service.wx.WxService;

public class MaterialServiceImpl implements MaterialService {

	private static WxService wxService = new WxServiceImpl();

	@Override
	public ResultInfo<Map<String, Object>> uploadMedia(File file,String mediaType) {
		ResultInfo<Map<String, Object>> result = new ResultInfo<Map<String, Object>>();

		WxAccessToken access_token = wxService.getToken();
		if (access_token == null) {
			result.code = 0;
			result.msg = "获取ACCESS_TOKEN失败!";

			return result;
		}
		
		String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token="+access_token.getAccessToken()+"&type="+mediaType ;
		MediaUploadRequestExecutor requestExecutor = new MediaUploadRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			String response = requestExecutor.execute(httpclient, null, url,file);

			JSONObject demoJson = JSONObject.parseObject(response);
			Integer errcode = demoJson.getIntValue("errcode");
			if (errcode != null && errcode.intValue() != 0) {
				result.code = -errcode;
				result.msg = demoJson.getString("errmsg");

				return result;
			}

			result.code = 1;
			result.msg = "上传临时素材成功!";
			Map<String, Object> obj = new HashMap<String, Object>();
			obj.put("type", demoJson.getString("type"));
			obj.put("media_id", demoJson.getString("media_id"));
			obj.put("created_at", demoJson.getLong("created_at"));

			result.obj = obj;
			return result;

		} catch (ClientProtocolException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		} catch (IOException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		}
		
	}


	@Override
	public ResultInfo<Map<String, String>> uploadMaterial(File file,String mediaType) {
		ResultInfo<Map<String, String>> result = new ResultInfo<Map<String, String>>();

		WxAccessToken access_token = wxService.getToken();
		if (access_token == null) {
			result.code = 0;
			result.msg = "获取ACCESS_TOKEN失败!";

			return result;
		}
		
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="+access_token.getAccessToken()+"&type="+mediaType ;
		MediaUploadRequestExecutor requestExecutor = new MediaUploadRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			String response = requestExecutor.execute(httpclient, null, url,file);

			JSONObject demoJson = JSONObject.parseObject(response);
			Integer errcode = demoJson.getIntValue("errcode");
			if (errcode != null && errcode.intValue() != 0) {
				result.code = -errcode;
				result.msg = demoJson.getString("errmsg");

				return result;
			}

			result.code = 1;
			result.msg = "上传永久素材成功!";
			Map<String, String> obj = new HashMap<String, String>();
			obj.put("media_id", demoJson.getString("media_id"));
			obj.put("url", demoJson.getString("url"));

			result.obj = obj;
			return result;

		} catch (ClientProtocolException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		} catch (IOException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		}
	}

	@Override
	public ResultInfo<String> uploadNewsImg(File file) {
		
		ResultInfo<String> result = new ResultInfo<String>();

		WxAccessToken access_token = wxService.getToken();
		if (access_token == null) {
			result.code = 0;
			result.msg = "获取ACCESS_TOKEN失败!";

			return result;
		}
		
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token="+access_token.getAccessToken();
		MediaUploadRequestExecutor requestExecutor = new MediaUploadRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			String response = requestExecutor.execute(httpclient, null, url,file);

			JSONObject demoJson = JSONObject.parseObject(response);
			Integer errcode = demoJson.getIntValue("errcode");
			if (errcode != null && errcode.intValue() != 0) {
				result.code = -errcode;
				result.msg = demoJson.getString("errmsg");

				return result;
			}

			result.code = 1;
			result.msg = "上传图文消息内的图片获取URL成功!";
			String imgUrl = demoJson.getString("url");

			result.obj = imgUrl;
			return result;

		} catch (ClientProtocolException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		} catch (IOException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		}
	}
	
	@Override
	public ResultInfo<String> uploadMaterialNews(MaterialNews news) {
		ResultInfo<String> result = new ResultInfo<String>();

		WxAccessToken access_token = wxService.getToken();
		if (access_token == null) {
			result.code = 0;
			result.msg = "获取ACCESS_TOKEN失败!";

			return result;
		}

		String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token="+ access_token.getAccessToken();
		RequestExecutor<String, String> requestExecutor = new SimplePostRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			
			String newsJSON = news.toJSONString();
			String response = requestExecutor.execute(httpclient, null, url,newsJSON);

			JSONObject demoJson = JSONObject.parseObject(response);
			Integer errcode = demoJson.getIntValue("errcode");
			if (errcode != null && errcode.intValue() != 0) {
				result.code = -errcode;
				result.msg = demoJson.getString("errmsg");

				return result;
			}

			result.code = 1;
			result.msg = "上传永久图文素材成功!";
			
			String media_id = demoJson.getString("media_id");

			result.obj = media_id ;
			return result;

		} catch (ClientProtocolException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		} catch (IOException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		}
	}
	
	public ResultInfo<Map<String, Integer>> getMaterialcount() {
		ResultInfo<Map<String, Integer>> result = new ResultInfo<Map<String, Integer>>();

		WxAccessToken access_token = wxService.getToken();
		if (access_token == null) {
			result.code = 0;
			result.msg = "获取ACCESS_TOKEN失败!";

			return result;
		}

		String url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token="+ access_token.getAccessToken();
		RequestExecutor<String, String> requestExecutor = new SimpleGetRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			String response = requestExecutor.execute(httpclient, null, url,null);

			JSONObject demoJson = JSONObject.parseObject(response);
			Integer errcode = demoJson.getIntValue("errcode");
			if (errcode != null && errcode.intValue() != 0) {
				result.code = -errcode;
				result.msg = demoJson.getString("errmsg");

				return result;
			}

			result.code = 1;
			result.msg = "获取永久素材数量成功!";
			Map<String, Integer> obj = new HashMap<String, Integer>();
			obj.put("voice_count", demoJson.getInteger("voice_count"));
			obj.put("video_count", demoJson.getInteger("video_count"));
			obj.put("image_count", demoJson.getInteger("image_count"));
			obj.put("news_count", demoJson.getInteger("news_count"));

			result.obj = obj;
			return result;

		} catch (ClientProtocolException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		} catch (IOException e) {
			e.printStackTrace();

			e.printStackTrace();

			result.code = -1;
			result.msg = "请求出现错误";
			return result;
		}

	}

}
