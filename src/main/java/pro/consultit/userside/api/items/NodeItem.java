package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeItem {

	private Integer id;
	@JsonProperty("city_id")
	private Integer cityId;
	@JsonProperty("date_add")
	private String addDate;
	@JsonProperty("entirance")
	private Integer entirance;
	@JsonProperty("house_id")
	private Integer houseId;
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
	@JsonProperty("coordinates")
	private Coordinates coordinates;


	protected NodeItem() {
	}

	public NodeItem(final Integer id, final Integer cityId, final String addDate, final Integer entirance, final Integer houseId, final boolean planned, final String location,
	                final String comment, final String name,
	                final Integer type, final Integer number, final Map<Integer, String> params, final Coordinates coordinates) {
		this.id = id;
		this.cityId = cityId;
		this.addDate = addDate;
		this.entirance = entirance;
		this.houseId = houseId;
		this.planned = planned;
		this.location = location;
		this.comment = comment;
		this.name = name;
		this.type = type;
		this.number = number;
		this.params = params;
		this.coordinates = coordinates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(final Integer cityId) {
		this.cityId = cityId;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(final String addDate) {
		this.addDate = addDate;
	}

	public Integer getEntirance() {
		return entirance;
	}

	public void setEntirance(final Integer entirance) {
		this.entirance = entirance;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(final Integer houseId) {
		this.houseId = houseId;
	}

	public boolean isPlanned() {
		return planned;
	}

	public void setPlanned(final boolean planned) {
		this.planned = planned;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(final Integer type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

	public Map<Integer, String> getParams() {
		return params;
	}

	public void setParams(final Map<Integer, String> params) {
		this.params = params;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(final Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}
