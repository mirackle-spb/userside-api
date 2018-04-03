
package pro.consultit.userside.api.items.staff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffDivision {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("parent_id")
	private Integer parentId;
	@JsonProperty("comment")
	private String comment;
	@JsonProperty("date_add")
	private String dateAdd;
	@JsonProperty("staff")
	private Map<String, List<StaffEntry>> staff = new HashMap<>();

	public Integer getId() {
		return id;
	}

	public StaffDivision setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public StaffDivision setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getParentId() {
		return parentId;
	}

	public StaffDivision setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public StaffDivision setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public String getDateAdd() {
		return dateAdd;
	}

	public StaffDivision setDateAdd(String dateAdd) {
		this.dateAdd = dateAdd;
		return this;
	}

	public Map<String, List<StaffEntry>> getStaff() {
		return staff;
	}

	public StaffDivision setStaff(Map<String, List<StaffEntry>> staff) {
		this.staff = staff;
		return this;
	}
}
