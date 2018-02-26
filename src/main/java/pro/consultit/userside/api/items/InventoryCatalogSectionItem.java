package pro.consultit.userside.api.items;

public class InventoryCatalogSectionItem {
	private int id;
	private String name;
	private int typeId;

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
}
