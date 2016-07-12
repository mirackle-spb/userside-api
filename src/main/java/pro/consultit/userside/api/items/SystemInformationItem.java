package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SystemInformationItem {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;
	private String os;
	private SystemDescriprion erp = new SystemDescriprion();

	public SystemInformationItem(Date date, String os) {
		this.date = date;
		this.os = os;
	}

	public Date getDate() {
		return date;
	}

	public SystemInformationItem setDate(Date date) {
		this.date = date;
		return this;
	}

	public String getOs() {
		return os;
	}

	public SystemInformationItem setOs(String os) {
		this.os = os;
		return this;
	}

	public SystemDescriprion getErp() {
		return erp;
	}

	public SystemInformationItem setErp(SystemDescriprion erp) {
		this.erp = erp;
		return this;
	}

	public class SystemDescriprion {
		private String name = "SilverBill";
		private String version = "4.0";

		public String getName() {
			return name;
		}

		public SystemDescriprion setName(String name) {
			this.name = name;
			return this;
		}

		public String getVersion() {
			return version;
		}

		public SystemDescriprion setVersion(String version) {
			this.version = version;
			return this;
		}
	}
}
