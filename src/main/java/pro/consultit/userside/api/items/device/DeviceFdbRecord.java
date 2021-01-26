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
public class DeviceFdbRecord {
	@JsonProperty("ifIndex")
	private Integer ifIndex;
	@JsonProperty("vid")
	private Integer vlanId;
	@JsonProperty("mac")
	private String mac;
}
