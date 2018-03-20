package pro.consultit.userside.api.items.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskComment {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("dateAdd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateAdd;
	@JsonProperty("operatorId")
	private Integer operatorId;
	@JsonProperty("comment")
	private String comment;

	protected TaskComment() {
	}

	public TaskComment(int id, Date dateAdd, int operatorId, String comment) {
		this.id = id;
		this.dateAdd = dateAdd;
		this.operatorId = operatorId;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public TaskComment setId(int id) {
		this.id = id;
		return this;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public TaskComment setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
		return this;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public TaskComment setOperatorId(int operatorId) {
		this.operatorId = operatorId;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public TaskComment setComment(String comment) {
		this.comment = comment;
		return this;
	}
}
