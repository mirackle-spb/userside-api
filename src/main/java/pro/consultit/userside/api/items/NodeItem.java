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
public class NodeItem {
	@JsonProperty("id")
	private Integer id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("date_add")
	private Date addDate;
	@JsonProperty("entrance")
	private Integer entrance;
	@JsonProperty("address_id")
	private Integer addressId;
	@JsonSerialize(using = NumericBooleanSerializer.class)
	@JsonDeserialize(using = NumericBooleanDeserializer.class)
	@JsonProperty("is_planned")
	private boolean planned = false;
	@JsonProperty("location")
	private String location;
	@JsonProperty("comment")
	private String comment;
	@JsonProperty("name")
	private String name;
	@JsonProperty("type")
	private Integer type;
	@JsonProperty("number")
	private Integer number;
	@JsonProperty("additional_data")
	private Map<Integer, String> params = new HashMap();
	@JsonProperty("mark")
	private Map<Integer, String> marks = new HashMap();
	@JsonProperty("coordinates")
	private Coordinates coordinates;
}
