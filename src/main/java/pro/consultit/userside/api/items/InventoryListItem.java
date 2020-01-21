package pro.consultit.userside.api.items;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

}
