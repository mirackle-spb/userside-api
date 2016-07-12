package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OperatorResponse {
	private int id;
	private String login;
	@JsonProperty("is_blocked")
	private boolean blocked;
	@JsonProperty("profile_id")
	private int profileId;
	@JsonProperty("last_activity_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastActivityTime;
	private Map<String, Integer> rights = new HashMap<>();

	protected OperatorResponse() {
	}

	public OperatorResponse(int id, String login, boolean blocked, int profileId, Date lastActivityTime, Map<String, Integer> rights) {
		this.id = id;
		this.login = login;
		this.blocked = blocked;
		this.profileId = profileId;
		this.lastActivityTime = lastActivityTime;
		this.rights = rights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public Date getLastActivityTime() {
		return lastActivityTime;
	}

	public void setLastActivityTime(Date lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
	}

	public Map<String, Integer> getRights() {
		return rights;
	}

	public void setRights(Map<String, Integer> rights) {
		this.rights = rights;
	}
}
