package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.EncapsulatedResponse;
import pro.consultit.userside.api.items.IdResponse;
import pro.consultit.userside.api.items.TaskItem;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSideTaskApi extends AbstractUserSideClient {
	public UserSideTaskApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideTaskApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public Integer addCustomerTask(int taskType, @NotNull Date dateToDo, @NotNull Integer customerId, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("work_typer", String.valueOf(taskType)));
		params.add(new BasicNameValuePair("work_datedo", dateFormat.format(dateToDo)));
		if (customerId != null) {
			params.add(new BasicNameValuePair("usercode", String.valueOf(customerId)));
		}
		if (description != null) {
			params.add(new BasicNameValuePair("opis", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	@Deprecated
	public Integer addHouseTask(int taskType, @NotNull Date dateToDo, Integer houseCodeId, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("work_typer", String.valueOf(taskType)));
		params.add(new BasicNameValuePair("work_datedo", dateFormat.format(dateToDo)));
		if (houseCodeId != null) {
			params.add(new BasicNameValuePair("housecode", String.valueOf(houseCodeId)));
		}
		if (description != null) {
			params.add(new BasicNameValuePair("opis", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}

	public Integer addHouseTask(int taskType, @NotNull Date dateToDo, String clientFullname, Integer cityCodeId, Integer houseCodeId, Integer apartmentNumber, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("work_typer", String.valueOf(taskType)));
		params.add(new BasicNameValuePair("work_datedo", dateFormat.format(dateToDo)));
		if (cityCodeId != null) {
			params.add(new BasicNameValuePair("citycode", String.valueOf(cityCodeId)));
		}
		if (houseCodeId != null) {
			params.add(new BasicNameValuePair("housecode", String.valueOf(houseCodeId)));
		}
		if (apartmentNumber != null) {
			params.add(new BasicNameValuePair("apart", String.valueOf(apartmentNumber)));
		}
		if (clientFullname != null) {
			params.add(new BasicNameValuePair("fio", clientFullname));
		}
		if (description != null) {
			params.add(new BasicNameValuePair("opis", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}


	public Integer addTaskComment(int taskId, String description) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "comment_add"));
		params.add(new BasicNameValuePair("id", String.valueOf(taskId)));
		if (description != null) {
			params.add(new BasicNameValuePair("comment", description));
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IdResponse result = objectMapper.readValue(entity.getContent(), new TypeReference<IdResponse>() {
		});
		if (result.getResult().equals("OK") && result.getResultId() != null) {
			return result.getResultId();
		} else {
			return null;
		}
	}


	public boolean checkTaskVerifyCode(int taskId, String code) throws IOException, UserSideApiErrorException {
		HttpEntity entity = null;
		EncapsulatedResponse<String> incResponse = null;
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("action", "check_verify_code"));
		params.add(new BasicNameValuePair("id", String.valueOf(taskId)));
		params.add(new BasicNameValuePair("verify_code", code));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		entity = response.getEntity();
		incResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<String>>() {
		});
		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK") && incResponse.getData() != null) {
			return true;
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			return false;
		}
	}

	public TaskItem getTask(int taskId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("action", "show"));
		params.add(new BasicNameValuePair("id", String.valueOf(taskId)));

		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		EncapsulatedResponse<TaskItem> incResponse = objectMapper.readValue(entity.getContent(), new TypeReference<EncapsulatedResponse<TaskItem>>() {
		});

		if (incResponse.getResult() != null && incResponse.getResult().equalsIgnoreCase("OK") && incResponse.getData() != null) {
			return incResponse.getData();
		}
		if (incResponse.getError() != null) {
			throw new UserSideApiErrorException(incResponse.getError());
		} else {
			return null;
		}
	}
}
