package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDates {
	@JsonProperty("create")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create;
	@JsonProperty("todo")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date todo;
	@JsonProperty("update")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date update;
	@JsonProperty("complete")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date complete;

	protected TaskDates() {
	}

	public TaskDates(Date create, Date todo, Date update, Date complete) {
		this.create = create;
		this.todo = todo;
		this.update = update;
		this.complete = complete;
	}

	public Date getCreate() {
		return create;
	}

	public TaskDates setCreate(Date create) {
		this.create = create;
		return this;
	}

	public Date getTodo() {
		return todo;
	}

	public TaskDates setTodo(Date todo) {
		this.todo = todo;
		return this;
	}

	public Date getUpdate() {
		return update;
	}

	public TaskDates setUpdate(Date update) {
		this.update = update;
		return this;
	}

	public Date getComplete() {
		return complete;
	}

	public TaskDates setComplete(Date complete) {
		this.complete = complete;
		return this;
	}
}
