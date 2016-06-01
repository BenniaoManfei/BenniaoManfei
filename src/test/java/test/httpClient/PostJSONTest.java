package test.httpClient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import common.util.http.RequestExecutor;
import common.util.http.SimplePostRequestExecutor;

public class PostJSONTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("你好");
		RequestExecutor<String,String> executor = new SimplePostRequestExecutor();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String uri = "http://www.tuling123.com/openapi/api";
		String API_KEY = "7f6411ba72703cc6fda9a28722ddd10d";
		
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("key", API_KEY);
		jsonParam.put("info", "你叫啥名字?");
		jsonParam.put("userid", "33562423");
		
		try {
			String response = executor.execute(httpclient, null, uri, jsonParam.toString());
			System.out.println(response);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
