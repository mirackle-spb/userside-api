package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pro.consultit.userside.api.items.task.*;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskItem {
	@JsonProperty("todo")
	private int id;
	@JsonProperty("parentTaskId")
	private int parentTaskId;
	@JsonProperty("priority")
	private int priority;
	@JsonProperty("type")
	private TaskType type;
	@JsonProperty("date")
	private TaskDates date;
	@JsonProperty("state")
	private TaskState state;
	@JsonProperty("customer")
	private TaskCustomer customer;
	@JsonProperty("address")
	private TaskAddress address;
	@JsonProperty("node")
	private TaskNode node;
	@JsonProperty("description")
	private String description;
	@JsonProperty("authorId")
	private Integer authorId;
	@JsonProperty("comments")
	private Map<Integer, TaskComment> comments = new HashMap<>();
	@JsonProperty("staff")
	private TaskStaff staff;
}
