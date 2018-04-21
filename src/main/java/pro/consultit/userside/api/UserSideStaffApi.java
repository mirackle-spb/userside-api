package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.staff.StaffDivision;

import java.io.IOException;
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

	public List<StaffDivision> getDivisions(List<Integer> divisionsId) throws IOException, UserSideApiErrorException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "staff"));
		params.add(new BasicNameValuePair("subcat", "get_division"));
		if (divisionsId != null && divisionsId.size() > 0) {
			params.add(new BasicNameValuePair("id", String.join(",", divisionsId.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		return executeIndexEncapsulatedRequest(StaffDivision.class, params);
	}
}
