package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryCatalogSectionItem {
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("type_id")
	private int typeId;
	@JsonProperty("parent_id")
	private int parentId;

	protected InventoryCatalogSectionItem() {
	}

	public InventoryCatalogSectionItem(int id, String name, int typeId) {
		this.id = id;
		this.name = name;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public InventoryCatalogSectionItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public InventoryCatalogSectionItem setName(String name) {
		this.name = name;
		return this;
	}

	public int getTypeId() {
		return typeId;
	}

	public InventoryCatalogSectionItem setTypeId(int typeId) {
		this.typeId = typeId;
		return this;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(final int parentId) {
		this.parentId = parentId;
	}
}
