
package pro.consultit.userside.api.items.staff;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffEntry {

	@JsonProperty("staff_id")
	private Integer staffId;
	@JsonProperty("position")
	private String position;
	@JsonProperty("date_add")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String dateAdd;
	@JsonProperty("status")
	private Integer status;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("staff_id")
	public Integer getStaffId() {
		return staffId;
	}

	@JsonProperty("staff_id")
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@JsonProperty("position")
	public String getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(String position) {
		this.position = position;
	}

	@JsonProperty("date_add")
	public String getDateAdd() {
		return dateAdd;
	}

	@JsonProperty("date_add")
	public void setDateAdd(String dateAdd) {
		this.dateAdd = dateAdd;
	}

	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
