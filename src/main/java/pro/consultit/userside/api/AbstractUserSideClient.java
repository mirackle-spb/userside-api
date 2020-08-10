package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import pro.consultit.userside.api.response.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractUserSideClient {

	protected String url;
	protected String key;
	protected ObjectMapper objectMapper;
	protected HttpClient httpclient = new DefaultHttpClient();
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

	protected <T> List<T> executeIndexEncapsulatedRequest(Class<T> returnClass, List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}

		JavaType type = objectMapper.getTypeFactory().constructParametricType(IndexEncapsulatedResponse.class, Integer.class, returnClass);
		IndexEncapsulatedResponse<Integer, T> incResponse = objectMapper.readValue(entity.getContent(), type);

		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK") && incResponse.getData() != null) {
			return new ArrayList<>(incResponse.getData().values());
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			return Collections.emptyList();
		}
	}

	protected <T> List<T> executeStringIndexEncapsulatedRequest(Class<T> returnClass, List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}

		JavaType type = objectMapper.getTypeFactory().constructParametricType(IndexEncapsulatedResponse.class, String.class, returnClass);
		IndexEncapsulatedResponse<Integer, T> incResponse = objectMapper.readValue(entity.getContent(), type);

		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK") && incResponse.getData() != null) {
			return new ArrayList<>(incResponse.getData().values());
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			return Collections.emptyList();
		}
	}

	protected <T> T executeEncapsulatedRequest(Class<T> returnClass, List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}

		JavaType type = objectMapper.getTypeFactory().constructParametricType(EncapsulatedResponse.class, returnClass);
		EncapsulatedResponse<T> incResponse = objectMapper.readValue(entity.getContent(), type);


		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK") && incResponse.getData() != null) {
			return incResponse.getData();
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			return null;
		}
	}

	protected <T> List<T> executeArrayRequest(Class<T> returnClass, List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}

		JavaType type = objectMapper.getTypeFactory().constructParametricType(ArrayResponse.class, returnClass);
		ArrayResponse<T> incResponse = objectMapper.readValue(entity.getContent(), type);


		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK") && incResponse.getData() != null) {
			return incResponse.getData();
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			return null;
		}
	}

	protected List<Integer> executeIdArrayRequest(List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}

		JavaType type = objectMapper.getTypeFactory().constructType(IdArrayResponse.class);
		IdArrayResponse incResponse = objectMapper.readValue(entity.getContent(), type);

		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK") && incResponse.getCustomerId() != null) {
			return incResponse.getCustomerId();
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			return null;
		}
	}

	@NotNull
	protected List<Integer> executeListRequest(List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}

		JavaType type = objectMapper.getTypeFactory().constructType(ListResponse.class);
		ListResponse incResponse = objectMapper.readValue(entity.getContent(), type);

		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK")) {
			return incResponse.getList();
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			throw new UserSideApiErrorException("Unknown Error");
		}
	}

	protected Integer executeIdRequest(List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}
		String resultContent = IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8);
		IdResponse idResponse = objectMapper.readValue(resultContent, objectMapper.getTypeFactory().constructType(IdResponse.class));

		if (idResponse.getResult() != null && idResponse.getResult().equalsIgnoreCase("OK") && idResponse.getResultId() != null) {
			return idResponse.getResultId();
		}
		if (idResponse.getError() != null) {
			throw new UserSideApiErrorException(idResponse.getError());
		} else {
			throw new UserSideApiErrorException("Userside returned NULL id value. Content:" + resultContent);
		}
	}

	protected boolean executeBooleanRequest(List<NameValuePair> parameters) throws IOException, UserSideApiErrorException {
		String paramString = URLEncodedUtils.format(parameters, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (response.getStatusLine().getStatusCode() != 200) {
			entity.getContent().close();
			throw new UserSideApiErrorException("Return code of " + paramString + " is not 200!");
		}

		DefaultResponse responseObject = objectMapper.readValue(entity.getContent(), objectMapper.getTypeFactory().constructType(DefaultResponse.class));

		if (responseObject.getResult() != null && responseObject.getResult().equalsIgnoreCase("OK")) {
			return true;
		}
		if (responseObject.getError() != null) {
			throw new UserSideApiErrorException(responseObject.getError());
		} else {
			return false;
		}
	}


	public enum CommutaionType {
		CUSTOMER, SWITCH, CROSS, FIBER
	}
}
