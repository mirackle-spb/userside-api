package pro.consultit.userside.api.items.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressItem {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("parent_ids")
	private List<Integer> parentIds;
	@JsonProperty("building_id")
	private Integer buildingId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("additional_data")
	private Map<Integer, OptionItem> params = new HashMap<>();
	@JsonProperty("locality_type_id")
	private Integer localityType;
}
