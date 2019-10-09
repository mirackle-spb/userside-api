package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceListItem {
	private int id;
	@JsonProperty("citycode")
	private int cityId;
	@JsonProperty("interfaces")
	private int interfaceCount;
	@JsonProperty("inventory_id")
	private int inventoryId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("uplink_iface")
	private String uplinkInterfaces;
	@JsonProperty("dnlink_iface")
	private String downlinkInterfaces;
	@JsonProperty("location")
	private String stringLocation;
	@JsonProperty("host")
	private String hostname;
	@JsonProperty("entrance")
	private String entranceId;
	@JsonProperty("node_id")
	private Integer nodeId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("activity_time")
	private Date lastActivityTime;
	@JsonProperty("additional_data")
	private Map<Integer, String> additionalOptionMap = new HashMap<>();
	@JsonProperty("mark")
	private Map<Integer, Integer> marks = new HashMap<>();
	@JsonProperty("is_online")
	@JsonSerialize(using = NumericBooleanSerializer.class)
	@JsonDeserialize(using = NumericBooleanDeserializer.class)
	private boolean online;


}
