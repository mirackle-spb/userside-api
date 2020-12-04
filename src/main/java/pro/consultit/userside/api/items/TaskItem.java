package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.consultit.userside.api.items.task.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskItem {
	@JsonProperty("id")
	private int id;
	@JsonProperty("parentTaskId")
	private Integer parentTaskId;
	@JsonProperty("priority")
	private Integer priority;
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
	private TaskNode[] node;
	@JsonProperty("description")
	private String description;
	@JsonProperty("authorId")
	private Integer authorId;
	@JsonProperty("comments")
	private Map<Integer, TaskComment> comments = new HashMap<>();
	@JsonProperty("staff")
	private TaskStaff staff;
	@JsonProperty("customerId")
	private Integer customerId;

}
