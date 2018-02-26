package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryCatalogItem {
	@JsonProperty("id")
	int id;
	@JsonProperty("name")
	String name;
	@JsonProperty("inventory_section_catalog_id")
	int inventorySectionCatalog;

	protected InventoryCatalogItem() {
	}

	public InventoryCatalogItem(int id, String name, int inventorySectionCatalog) {
		this.id = id;
		this.name = name;
		this.inventorySectionCatalog = inventorySectionCatalog;
	}

	public int getId() {
		return id;
	}

	public InventoryCatalogItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public InventoryCatalogItem setName(String name) {
		this.name = name;
		return this;
	}

	public int getInventorySectionCatalog() {
		return inventorySectionCatalog;
	}

	public InventoryCatalogItem setInventorySectionCatalog(int inventorySectionCatalog) {
		this.inventorySectionCatalog = inventorySectionCatalog;
		return this;
	}
}
