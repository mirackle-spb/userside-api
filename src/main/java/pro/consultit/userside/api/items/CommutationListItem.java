package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommutationListItem {
	@JsonProperty("object_type")
	private String objectType;
	@JsonProperty("object_id")
	private int objectId;
	@JsonProperty("direction")
	private int direction;
	@JsonProperty("interface")
	private int connectedInterface;
	@JsonProperty("comment")
	private String comment;
	@JsonProperty("connect_id")
	private int connectId;

	protected CommutationListItem() {
	}

	public String getObjectType() {
		return objectType;
	}

	public CommutationListItem setObjectType(String objectType) {
		this.objectType = objectType;
		return this;
	}

	public int getObjectId() {
		return objectId;
	}

	public CommutationListItem setObjectId(int objectId) {
		this.objectId = objectId;
		return this;
	}

	public int getDirection() {
		return direction;
	}

	public CommutationListItem setDirection(int direction) {
		this.direction = direction;
		return this;
	}

	public int getConnectedInterface() {
		return connectedInterface;
	}

	public CommutationListItem setConnectedInterface(int connectedInterface) {
		this.connectedInterface = connectedInterface;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public CommutationListItem setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public int getConnectId() {
		return connectId;
	}

	public CommutationListItem setConnectId(int connectId) {
		this.connectId = connectId;
		return this;
	}
}
