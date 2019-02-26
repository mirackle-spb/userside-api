package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.TaskItem;
import pro.consultit.userside.api.items.task.TaskCatalogState;
import pro.consultit.userside.api.items.task.TaskCatalogType;

import javax.validation.constraints.NotNull;
import java.io.IOException;
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

	public Integer addCustomerTask(int taskType, @NotNull Date dateToDo, @NotNull Integer customerId, String description,
	                               Integer parentTask) throws IOException, UserSideApiErrorException {

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
		if (parentTask != null) {
			params.add(new BasicNameValuePair("parent_task_id", String.valueOf(parentTask)));
		}

		return executeIdRequest(params);
	}

	@Deprecated
	public Integer addHouseTask(int taskType, @NotNull Date dateToDo, Integer houseCodeId, String description) throws IOException, UserSideApiErrorException {

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

		return executeIdRequest(params);
	}

	public Integer addHouseTask(int taskType, @NotNull Date dateToDo, String clientFullname, Integer cityCodeId, Integer houseCodeId, Integer apartmentNumber,
	                            String description) throws IOException, UserSideApiErrorException {

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

		return executeIdRequest(params);
	}


	public Integer addTaskComment(int taskId, String description) throws IOException, UserSideApiErrorException {

		List<NameValuePair> params = new ArrayList<>();

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("subcat", "comment_add"));
		params.add(new BasicNameValuePair("id", String.valueOf(taskId)));
		if (description != null) {
			params.add(new BasicNameValuePair("comment", description));
		}

		return executeIdRequest(params);
	}


	public boolean checkTaskVerifyCode(int taskId, String code) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("action", "check_verify_code"));
		params.add(new BasicNameValuePair("id", String.valueOf(taskId)));
		params.add(new BasicNameValuePair("verify_code", code));

		return executeBooleanRequest(params);
	}

	public TaskItem getTask(int taskId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("action", "show"));
		params.add(new BasicNameValuePair("id", String.valueOf(taskId)));

		return executeEncapsulatedRequest(TaskItem.class, params);
	}

	public List<TaskCatalogType> getTaskCatalogType(Integer type_id) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("action", "get_catalog_type"));
		if (type_id != null) {
			params.add(new BasicNameValuePair("id", String.valueOf(type_id)));
		}

		return executeIndexEncapsulatedRequest(TaskCatalogType.class, params);
	}


	public List<TaskCatalogState> getTaskCatalogState(Integer state_id) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("action", "get_catalog_state"));
		if (state_id != null) {
			params.add(new BasicNameValuePair("id", String.valueOf(state_id)));
		}

		return executeIndexEncapsulatedRequest(TaskCatalogState.class, params);
	}

	public boolean changeTaskState(@NotNull Integer id, @NotNull Integer state_id, Integer operator_id) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "task"));
		params.add(new BasicNameValuePair("action", "change_state"));
		params.add(new BasicNameValuePair("id", String.valueOf(id)));
		params.add(new BasicNameValuePair("state_id", String.valueOf(state_id)));

		if (operator_id != null) {
			params.add(new BasicNameValuePair("operator_id", String.valueOf(operator_id)));
		}

		return executeBooleanRequest(params);
	}
}
