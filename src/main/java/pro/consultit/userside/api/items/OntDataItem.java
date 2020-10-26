package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OntDataItem {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("device_id")
	private Integer deviceId;

	@JsonProperty("date_add")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime addDate;

	@JsonProperty("mac")
	private String mac;

	@JsonProperty("sn")
	private String serial;

	@JsonProperty("iface_olt_number")
	private String connectedOltIfIndex;

	@JsonProperty("iface_number")
	private String connectedOltSubIfIndex;

	@JsonProperty("iface_name")
	private String oltIfName;

	@JsonProperty("iface_state")
	private Integer connectedOltIfState;

	@JsonProperty("distance")
	private Integer distance;

	@JsonProperty("description")
	private String description;

	@JsonProperty("level_onu_rx")
	private Integer ontRxLevel;

	@JsonProperty("level_onu_rx")
	private Integer ontTxLevel;

	@JsonProperty("level_onu_tx")
	private Integer oltRxLevel;

	@JsonProperty("level_olt_tx")
	private Integer oltTxLevel;

	@JsonProperty("level_min")
	private Integer minLevel;

	@JsonProperty("level_max")
	private Integer maxLevel;

}
