package pro.consultit.userside.api.items;

public class ApiInformationItem {
	private String version = "1.2";
	private String date = "2016-04-01";

	public ApiInformationItem() {
	}

	public String getVersion() {
		return version;
	}

	public ApiInformationItem setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getDate() {
		return date;
	}

	public ApiInformationItem setDate(String date) {
		this.date = date;
		return this;
	}
}
