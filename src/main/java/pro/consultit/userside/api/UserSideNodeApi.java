package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.NodeItem;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSideNodeApi extends AbstractUserSideClient {
	public UserSideNodeApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideNodeApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public NodeItem get(@NotNull Integer nodeId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "node"));
		params.add(new BasicNameValuePair("action", "get"));
		params.add(new BasicNameValuePair("id", nodeId.toString()));

		return executeIndexEncapsulatedRequest(NodeItem.class, params).stream().findFirst().orElse(null);
	}

	public List<NodeItem> get(@NotNull List<Integer> nodeList) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "node"));
		params.add(new BasicNameValuePair("action", "get"));
		if (nodeList.size() > 0) {
			params.add(new BasicNameValuePair("id", nodeList.stream().map(Object::toString).collect(Collectors.joining(","))));
		}

		return executeIndexEncapsulatedRequest(NodeItem.class, params);
	}

}
