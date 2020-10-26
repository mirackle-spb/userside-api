package pro.consultit.userside.api.items;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InventoryAmountItem {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("document_number")
	private String documentNumber;

	@JsonProperty("document_date")
	private LocalDate documentDate;

	@JsonProperty("location_type")
	private String locationType;

	@JsonProperty("catalog_id")
	private int catalogId;

	@JsonProperty("amount")
	private Integer amount;

	@JsonProperty("cost")
	private Double cost;

	@JsonProperty("account")
	private String account;

	@JsonProperty("inventory_number")
	private String inventoryNumber;

	@JsonProperty("serial_number")
	private String serialNumber;

	@JsonProperty("mac")
	private String mac;

	@JsonProperty("object_id")
	private int locationObject;

}
