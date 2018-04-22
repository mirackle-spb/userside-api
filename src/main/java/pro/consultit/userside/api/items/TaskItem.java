package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pro.consultit.userside.api.items.task.*;

import java.util.HashMap;
import java.util.Map;

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
	private TaskNode node;
	@JsonProperty("description")
	private String description;
	@JsonProperty("authorId")
	private Integer authorId;
	@JsonProperty("comments")
	private Map<Integer, TaskComment> comments = new HashMap<>();
	@JsonProperty("staff")
	private TaskStaff staff;

	protected  TaskItem() {
	}

	public int getId() {
		return id;
	}

	public TaskItem setId(int id) {
		this.id = id;
		return this;
	}

	public Integer getParentTaskId() {
		return parentTaskId;
	}

	public TaskItem setParentTaskId(Integer parentTaskId) {
		this.parentTaskId = parentTaskId;
		return this;
	}

	public Integer getPriority() {
		return priority;
	}

	public TaskItem setPriority(Integer priority) {
		this.priority = priority;
		return this;
	}

	public TaskType getType() {
		return type;
	}

	public TaskItem setType(TaskType type) {
		this.type = type;
		return this;
	}

	public TaskDates getDate() {
		return date;
	}

	public TaskItem setDate(TaskDates date) {
		this.date = date;
		return this;
	}

	public TaskState getState() {
		return state;
	}

	public TaskItem setState(TaskState state) {
		this.state = state;
		return this;
	}

	public TaskCustomer getCustomer() {
		return customer;
	}

	public TaskItem setCustomer(TaskCustomer customer) {
		this.customer = customer;
		return this;
	}

	public TaskAddress getAddress() {
		return address;
	}

	public TaskItem setAddress(TaskAddress address) {
		this.address = address;
		return this;
	}

	public TaskNode getNode() {
		return node;
	}

	public TaskItem setNode(TaskNode node) {
		this.node = node;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public TaskItem setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public TaskItem setAuthorId(Integer authorId) {
		this.authorId = authorId;
		return this;
	}

	public Map<Integer, TaskComment> getComments() {
		return comments;
	}

	public TaskItem setComments(Map<Integer, TaskComment> comments) {
		this.comments = comments;
		return this;
	}

	public TaskStaff getStaff() {
		return staff;
	}

	public TaskItem setStaff(TaskStaff staff) {
		this.staff = staff;
		return this;
	}
}
