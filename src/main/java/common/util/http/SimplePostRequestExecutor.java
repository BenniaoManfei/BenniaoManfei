package common.util.http;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class SimplePostRequestExecutor implements RequestExecutor<String, String> {

	public String execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, String postEntity) throws ClientProtocolException,IOException {
		String responseStr = null;
		HttpPost httpPost = new HttpPost(uri);
		if (httpProxy != null) {
			RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
			httpPost.setConfig(config);
		}

		if (postEntity != null) {
			StringEntity entity = new StringEntity(postEntity, Consts.UTF_8);
			httpPost.setEntity(entity);
		}
		CloseableHttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		responseStr = EntityUtils.toString(entity, "UTF-8");

		return responseStr;
	}

}
