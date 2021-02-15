package pro.consultit.userside.api.items.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseItem {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("parent_id")
	private Integer parentId;
	@JsonProperty("parent_ids")
	private List<Integer> parentIds;
	@JsonProperty("building_id")
	private Integer buildingId;
	@JsonProperty("floor")
	private Integer floorCount;
	@JsonProperty("entrance")
	private Integer entranceCount;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("additional_data")
	private Map<Integer, String> params = new HashMap();
	@JsonProperty("coordinates")
	private List<Double[]> coordinatesList = new ArrayList<>();
	@JsonProperty("comment")
	private String comment;
	@JsonProperty("exit_comment")
	private String exitComment;
	@JsonProperty("task_comment")
	private String taskComment;
	@JsonProperty("locality_type_id")
	private String localityType;
}
