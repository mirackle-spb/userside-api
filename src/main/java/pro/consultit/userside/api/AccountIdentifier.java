package pro.consultit.userside.api;

public class AccountIdentifier {
	private int type;
	private int subType;
	private int subject;

	public AccountIdentifier(String inventoryIdentifier) {
		String typeStr = inventoryIdentifier.substring(0, 3);
		String subTypeStr = inventoryIdentifier.substring(3, 5);
		String subjectStr = inventoryIdentifier.substring(5);
		this.type = Integer.parseInt(typeStr);
		this.subType = Integer.parseInt(subTypeStr);
		this.subject = Integer.parseInt(subjectStr);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}
}
