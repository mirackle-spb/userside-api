package pro.consultit.userside.api.items.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInterface {
	@JsonProperty("ifIndex")
	private Long ifIndex;
	@JsonProperty("ifType")
	private Integer ifType;
	@JsonProperty("ifName")
	private String ifName;
	@JsonProperty("ifNumber")
	private Integer ifNumber;
}
