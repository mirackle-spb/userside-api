package pro.consultit.userside.api.items;


import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryListItem {
	private int id;

	@JsonProperty("catalog_id")
	private int catalogId;

	@JsonProperty("section_catalog_id")
	private int catalogSectionId;

	@JsonProperty("section_name")
	private String sectionName;

	private String name;

	private String measure;

	@JsonProperty("seller_id")
	private int sellerId;

	private int amount;

	private double cost;
	@JsonProperty("serial_number")
	private String serialNumber;
	@JsonProperty("inventory_number")
	private String inventoryNumber;

	private String barcode;

	@JsonProperty("location_type_id")
	private int locationType;

	@JsonProperty("location_subaccount")
	private int locationSubAccount;

	@JsonProperty("location_object_id")
	private int locationObject;

	public InventoryListItem() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public int getCatalogSectionId() {
		return catalogSectionId;
	}

	public void setCatalogSectionId(int catalogSectionId) {
		this.catalogSectionId = catalogSectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getBarcode() {
		return barcode;
	}

	public InventoryListItem setBarcode(String barcode) {
		this.barcode = barcode;
		return this;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public int getLocationSubAccount() {
		return locationSubAccount;
	}

	public void setLocationSubAccount(int locationSubAccount) {
		this.locationSubAccount = locationSubAccount;
	}

	public int getLocationObject() {
		return locationObject;
	}

	public void setLocationObject(int locationObject) {
		this.locationObject = locationObject;
	}
}
