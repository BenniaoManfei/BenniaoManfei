package common.util;

import java.io.IOException;
import java.util.Date;

import model.bean.wx.WxAccessToken;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.classfile.Code;

import common.util.http.RequestExecutor;
import common.util.http.SimplePostRequestExecutor;

public final class TulingText {

	public static String getTulingReponse(String info,String fromUserName){
		RequestExecutor<String,String> executor = new SimplePostRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String uri = "http://www.tuling123.com/openapi/api";
		String API_KEY = "7f6411ba72703cc6fda9a28722ddd10d";
		
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("key", API_KEY);
		jsonParam.put("info", info);
		jsonParam.put("userid", fromUserName);
		
		String response = "哎哟我去，喵主子饿了，暂时就这样儿吧......";
		try {
			response = executor.execute(httpclient, null, uri, jsonParam.toString());
			
			JSONObject demoJson = JSONObject.parseObject(response);
			int errcode = demoJson.getIntValue("code");
			if(errcode == 40004){
				response = "喵主子今天累了,小的们明天再来玩吧!赶紧跪安下去吧!";
			} else if(errcode == 100000) {
				response = demoJson.getString("text");
			} else {
				response = "你是哪个星球来的,本喵竟然听不懂?";
			}
			
			System.out.println(response);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
}
