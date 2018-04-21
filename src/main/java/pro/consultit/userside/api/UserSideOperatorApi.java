package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.OperatorResponse;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserSideOperatorApi extends AbstractUserSideClient {
	public UserSideOperatorApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideOperatorApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public boolean doLogin(String username, String password) throws IOException, UserSideApiErrorException {
		String fingerprint = DigestUtils.md5Hex(password);
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "operator"));
		params.add(new BasicNameValuePair("action", "check_pass"));
		params.add(new BasicNameValuePair("login", username));
		params.add(new BasicNameValuePair("pass", fingerprint));
		return executeBooleanRequest(params);
	}

	public List<OperatorResponse> getOperator(@NotNull List<Integer> operatorIdList) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "operator"));
		params.add(new BasicNameValuePair("action", "get"));
		params.add(new BasicNameValuePair("id", String.join(",", operatorIdList.stream().map(Object::toString).collect(Collectors.toList()))));

		return executeIndexEncapsulatedRequest(OperatorResponse.class, params);
	}

	public OperatorResponse getOperator(@NotNull Integer operatorIdList) throws IOException, UserSideApiErrorException {
		List<OperatorResponse> result = getOperator(Collections.singletonList(operatorIdList));
		return result.get(0);
	}

	public Integer getOperatorIdByLogin(String username) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "operator"));
		params.add(new BasicNameValuePair("action", "get_id_by_login"));
		params.add(new BasicNameValuePair("login", username));
		return executeIdRequest(params);
	}
}
