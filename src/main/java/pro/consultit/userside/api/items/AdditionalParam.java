package pro.consultit.userside.api.items;

public class AdditionalParam {
	private int id;
	private String name;

	protected AdditionalParam() {
	}

	public AdditionalParam(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
