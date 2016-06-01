package common.util.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class SimpleGetRequestExecutor implements RequestExecutor<String, String> {

	public String execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, String queryParam) throws ClientProtocolException, IOException {
		String responseStr = null;
		if (queryParam != null) {
			if (uri.indexOf('?') == -1) {
				uri += '?';
			}
			uri += uri.endsWith("?") ? queryParam : '&' + queryParam;
		}
		HttpGet httpGet = new HttpGet(uri);
		if (httpProxy != null) {
			RequestConfig config = RequestConfig.custom().setProxy(httpProxy)
					.build();
			httpGet.setConfig(config);
		}

		CloseableHttpResponse response = httpclient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		responseStr = EntityUtils.toString(entity, "UTF-8");
		
		return responseStr;
	}

}
