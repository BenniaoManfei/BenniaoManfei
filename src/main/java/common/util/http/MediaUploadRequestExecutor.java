package common.util.http;

import java.io.File;
import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class MediaUploadRequestExecutor implements RequestExecutor<String, File> {

	public String execute(CloseableHttpClient httpclient, HttpHost httpProxy,
			String uri, File file) throws ClientProtocolException, IOException {

		HttpPost httpPost = new HttpPost(uri);
		if (httpProxy != null) {
			RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
			httpPost.setConfig(config);
		}
		if (file != null) {

			FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY,file.getName());

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart("media", fileBody);

			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			
			CloseableHttpResponse response = httpclient.execute(httpPost);
			
			final StatusLine statusLine = response.getStatusLine();
			final HttpEntity entityResponse = response.getEntity();
			if (statusLine.getStatusCode() >= 300) {
				EntityUtils.consume(entityResponse);
				throw new HttpResponseException(statusLine.getStatusCode(),statusLine.getReasonPhrase());
			}
			System.out.println(entityResponse);
			return (entity == null ? null : EntityUtils.toString(entityResponse,Consts.UTF_8));
		}
		
		return null;
	}
}
