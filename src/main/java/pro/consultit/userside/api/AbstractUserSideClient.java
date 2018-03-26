package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;

public abstract class AbstractUserSideClient {

	protected String url;
	protected String key;
	protected ObjectMapper objectMapper;
	protected HttpClient httpclient = new DefaultHttpClient();
	protected URLCodec urlCodec = new URLCodec();
	protected int timeout = 5;

	public AbstractUserSideClient(ObjectMapper objectMapper, String url, String key) {
		this.objectMapper = objectMapper;
		this.url = url;
		this.key = key;
		setHttpClientTimeout(httpclient);
	}

	public AbstractUserSideClient(ObjectMapper objectMapper, String url, String key, int timeout) {
		this.objectMapper = objectMapper;
		this.url = url;
		this.key = key;
		this.timeout = timeout;
		setHttpClientTimeout(httpclient);
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	private void setHttpClientTimeout(HttpClient httpClient) {
		HttpParams httpParams = httpClient.getParams();
		httpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout * 1000);
		httpParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout * 1000);
	}

	public enum CommutaionType {
		CUSTOMER, SWITCH, CROSS, FIBER
	}
}
