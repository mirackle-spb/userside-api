package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DeviceListItem {
	private int id;
	@JsonProperty("address_city_id")
	private int cityId;
	@JsonProperty("house_id")
	private int houseId;
	@JsonProperty("interfaces")
	private int interfaceCount;

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
	private String nodeId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("activity_time")
	private Date lastActivityTime;
	@JsonProperty("additional_data")
	private Map<Integer, AdditionalParam> additionalOptionMap = new HashMap<>();

	protected DeviceListItem() {
	}

	public int getId() {
		return id;
	}

	public DeviceListItem setId(int id) {
		this.id = id;
		return this;
	}

	public int getCityId() {
		return cityId;
	}

	public DeviceListItem setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public int getHouseId() {
		return houseId;
	}

	public DeviceListItem setHouseId(int houseId) {
		this.houseId = houseId;
		return this;
	}

	public int getInterfaceCount() {
		return interfaceCount;
	}

	public DeviceListItem setInterfaceCount(int interfaceCount) {
		this.interfaceCount = interfaceCount;
		return this;
	}

	public String getName() {
		return name;
	}

	public DeviceListItem setName(String name) {
		this.name = name;
		return this;
	}

	public String getUplinkInterfaces() {
		return uplinkInterfaces;
	}

	public DeviceListItem setUplinkInterfaces(String uplinkInterfaces) {
		this.uplinkInterfaces = uplinkInterfaces;
		return this;
	}

	public String getDownlinkInterfaces() {
		return downlinkInterfaces;
	}

	public DeviceListItem setDownlinkInterfaces(String downlinkInterfaces) {
		this.downlinkInterfaces = downlinkInterfaces;
		return this;
	}

	public String getStringLocation() {
		return stringLocation;
	}

	public DeviceListItem setStringLocation(String stringLocation) {
		this.stringLocation = stringLocation;
		return this;
	}

	public String getHostname() {
		return hostname;
	}

	public DeviceListItem setHostname(String hostname) {
		this.hostname = hostname;
		return this;
	}

	public String getEntranceId() {
		return entranceId;
	}

	public DeviceListItem setEntranceId(String entranceId) {
		this.entranceId = entranceId;
		return this;
	}

	public String getNodeId() {
		return nodeId;
	}

	public DeviceListItem setNodeId(String nodeId) {
		this.nodeId = nodeId;
		return this;
	}

	public Date getLastActivityTime() {
		return lastActivityTime;
	}

	public DeviceListItem setLastActivityTime(Date lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
		return this;
	}

	public Map<Integer, AdditionalParam> getAdditionalOptionMap() {
		return additionalOptionMap;
	}

	public DeviceListItem setAdditionalOptionMap(Map<Integer, AdditionalParam> additionalOptionMap) {
		this.additionalOptionMap = additionalOptionMap;
		return this;
	}
}
