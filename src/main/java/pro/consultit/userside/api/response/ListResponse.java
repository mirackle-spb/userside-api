package pro.consultit.userside.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponse extends DefaultResponse {
	@JsonProperty("list")
	@JsonDeserialize(converter = ListResponseConverter.class)
	private List<Integer> list = new ArrayList<>();

}
