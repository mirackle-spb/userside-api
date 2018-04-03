package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.IndexEncapsulatedResponse;
import pro.consultit.userside.api.items.staff.StaffDivision;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSideStaffApi extends AbstractUserSideClient {
	public UserSideStaffApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideStaffApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public List<StaffDivision> getDivisions(List<Integer> divisionsId) throws IOException {

		List<NameValuePair> params = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "staff"));
		params.add(new BasicNameValuePair("subcat", "get_division"));
		if (divisionsId != null && divisionsId.size() > 0) {
			params.add(new BasicNameValuePair("id", String.join(",", divisionsId.stream().map(Object::toString).collect(Collectors.toList()))));
		}


		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
		HttpResponse response = httpclient.execute(httpPost);

		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, StaffDivision> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, StaffDivision>>() {
		});
		if (result.getResult().equals("OK")) {
			return new ArrayList<>(result.getData().values());
		} else {
			return null;
		}
	}
}
