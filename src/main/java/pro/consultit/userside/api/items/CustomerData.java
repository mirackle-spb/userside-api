package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
		"id", "full_name", "flag_corporate", "balance", "state_id", "date_create",
		"date_connect", "date_activity", "date_activity_inet", "is_disable", "address", "is_in_billing",
		"group", "email", "agreement", "comment", "account_number", "login", "phone", "ip_mac", "billing_id"
})
public class CustomerData {

	@JsonProperty("id")
	private String id;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("flag_corporate")
	private int flagCorporate;
	@JsonProperty("balance")
	private String balance;
	@JsonProperty("state_id")
	private int stateId;
	@JsonProperty("date_create")
	private String dateCreate;
	@JsonProperty("date_connect")
	private String dateConnect;
	@JsonProperty("date_activity")
	private String dateActivity;
	@JsonProperty("date_activity_inet")
	private Object dateActivityInet;
	@JsonProperty("is_disable")
	private int isDisable;
	@JsonProperty("address")
	private List<Address> address = null;
	@JsonProperty("is_in_billing")
	private int isInBilling;
	@JsonProperty("group")
	private Map<String, Group> group;
	@JsonProperty("email")
	private List<Email> email = null;
	@JsonProperty("agreement")
	private List<Agreement> agreement = null;
	@JsonProperty("comment")
	private String comment;
	@JsonProperty("account_number")
	private String accountNumber;
	@JsonProperty("login")
	private String login;
	@JsonProperty("phone")
	private List<Phone> phone = null;
	@JsonProperty("ip_mac")
	private Map<String, IpMac> ipMac;
	@JsonProperty("billing_id")
	private String billingId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("full_name")
	public String getFullName() {
		return fullName;
	}

	@JsonProperty("full_name")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonProperty("flag_corporate")
	public int getFlagCorporate() {
		return flagCorporate;
	}

	@JsonProperty("flag_corporate")
	public void setFlagCorporate(int flagCorporate) {
		this.flagCorporate = flagCorporate;
	}

	@JsonProperty("balance")
	public String getBalance() {
		return balance;
	}

	@JsonProperty("balance")
	public void setBalance(String balance) {
		this.balance = balance;
	}

	@JsonProperty("state_id")
	public int getStateId() {
		return stateId;
	}

	@JsonProperty("state_id")
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	@JsonProperty("date_create")
	public String getDateCreate() {
		return dateCreate;
	}

	@JsonProperty("date_create")
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	@JsonProperty("date_connect")
	public String getDateConnect() {
		return dateConnect;
	}

	@JsonProperty("date_connect")
	public void setDateConnect(String dateConnect) {
		this.dateConnect = dateConnect;
	}

	@JsonProperty("date_activity")
	public String getDateActivity() {
		return dateActivity;
	}

	@JsonProperty("date_activity")
	public void setDateActivity(String dateActivity) {
		this.dateActivity = dateActivity;
	}

	@JsonProperty("date_activity_inet")
	public Object getDateActivityInet() {
		return dateActivityInet;
	}

	@JsonProperty("date_activity_inet")
	public void setDateActivityInet(Object dateActivityInet) {
		this.dateActivityInet = dateActivityInet;
	}

	@JsonProperty("is_disable")
	public int getIsDisable() {
		return isDisable;
	}

	@JsonProperty("is_disable")
	public void setIsDisable(int isDisable) {
		this.isDisable = isDisable;
	}

	@JsonProperty("address")
	public List<Address> getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@JsonProperty("is_in_billing")
	public int getIsInBilling() {
		return isInBilling;
	}

	@JsonProperty("is_in_billing")
	public void setIsInBilling(int isInBilling) {
		this.isInBilling = isInBilling;
	}

	@JsonProperty("group")
	public Map<String, Group> getGroup() {
		return group;
	}

	@JsonProperty("group")
	public void setGroup(Map<String, Group> group) {
		this.group = group;
	}

	@JsonProperty("email")
	public List<Email> getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(List<Email> email) {
		this.email = email;
	}

	@JsonProperty("agreement")
	public List<Agreement> getAgreement() {
		return agreement;
	}

	@JsonProperty("agreement")
	public void setAgreement(List<Agreement> agreement) {
		this.agreement = agreement;
	}

	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonProperty("account_number")
	public String getAccountNumber() {
		return accountNumber;
	}

	@JsonProperty("account_number")
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@JsonProperty("login")
	public String getLogin() {
		return login;
	}

	@JsonProperty("login")
	public void setLogin(String login) {
		this.login = login;
	}

	@JsonProperty("phone")
	public List<Phone> getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	@JsonProperty("ip_mac")
	public Map<String, IpMac> getIpMac() {
		return ipMac;
	}

	@JsonProperty("ip_mac")
	public void setIpMac(Map<String, IpMac> ipMac) {
		this.ipMac = ipMac;
	}

	@JsonProperty("billing_id")
	public String getBillingId() {
		return billingId;
	}

	@JsonProperty("billing_id")
	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"type", "house_id", "apartment", "entrance", "floor"})
	public class Address {

		@JsonProperty("type")
		private String type;
		@JsonProperty("house_id")
		private int houseId;
		@JsonProperty("apartment")
		private Apartment apartment;
		@JsonProperty("entrance")
		private int entrance;
		@JsonProperty("floor")
		private String floor;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("type")
		public String getType() {
			return type;
		}

		@JsonProperty("type")
		public void setType(String type) {
			this.type = type;
		}

		@JsonProperty("house_id")
		public int getHouseId() {
			return houseId;
		}

		@JsonProperty("house_id")
		public void setHouseId(int houseId) {
			this.houseId = houseId;
		}

		@JsonProperty("apartment")
		public Apartment getApartment() {
			return apartment;
		}

		@JsonProperty("apartment")
		public void setApartment(Apartment apartment) {
			this.apartment = apartment;
		}

		@JsonProperty("entrance")
		public int getEntrance() {
			return entrance;
		}

		@JsonProperty("entrance")
		public void setEntrance(int entrance) {
			this.entrance = entrance;
		}

		@JsonProperty("floor")
		public String getFloor() {
			return floor;
		}

		@JsonProperty("floor")
		public void setFloor(String floor) {
			this.floor = floor;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"number", "date"})
	public class Agreement {

		@JsonProperty("number")
		private String number;
		@JsonProperty("date")
		private String date;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("number")
		public String getNumber() {
			return number;
		}

		@JsonProperty("number")
		public void setNumber(String number) {
			this.number = number;
		}

		@JsonProperty("date")
		public String getDate() {
			return date;
		}

		@JsonProperty("date")
		public void setDate(String date) {
			this.date = date;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"full_name", "number", "block"})
	public class Apartment {

		@JsonProperty("full_name")
		private String fullName;
		@JsonProperty("number")
		private String number;
		@JsonProperty("block")
		private String block;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("full_name")
		public String getFullName() {
			return fullName;
		}

		@JsonProperty("full_name")
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		@JsonProperty("number")
		public String getNumber() {
			return number;
		}

		@JsonProperty("number")
		public void setNumber(String number) {
			this.number = number;
		}

		@JsonProperty("block")
		public String getBlock() {
			return block;
		}

		@JsonProperty("block")
		public void setBlock(String block) {
			this.block = block;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"address", "flag_main"})
	public class Email {

		@JsonProperty("address")
		private String address;
		@JsonProperty("flag_main")
		private int flagMain;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("address")
		public String getAddress() {
			return address;
		}

		@JsonProperty("address")
		public void setAddress(String address) {
			this.address = address;
		}

		@JsonProperty("flag_main")
		public int getFlagMain() {
			return flagMain;
		}

		@JsonProperty("flag_main")
		public void setFlagMain(int flagMain) {
			this.flagMain = flagMain;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"number", "flag_main"})
	public class Phone {

		@JsonProperty("number")
		private String number;
		@JsonProperty("flag_main")
		private int flagMain;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("number")
		public String getNumber() {
			return number;
		}

		@JsonProperty("number")
		public void setNumber(String number) {
			this.number = number;
		}

		@JsonProperty("flag_main")
		public int getFlagMain() {
			return flagMain;
		}

		@JsonProperty("flag_main")
		public void setFlagMain(int flagMain) {
			this.flagMain = flagMain;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"ip", "mac"})
	public class IpMac {

		@JsonProperty("ip")
		private String ip;
		@JsonProperty("mac")
		private String mac;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("ip")
		public String getIp() {
			return ip;
		}

		@JsonProperty("ip")
		public void setIp(String ip) {
			this.ip = ip;
		}

		@JsonProperty("mac")
		public String getMac() {
			return mac;
		}

		@JsonProperty("mac")
		public void setMac(String mac) {
			this.mac = mac;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"id"})
	public class Group {

		@JsonProperty("id")
		private int id;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("id")
		public int getId() {
			return id;
		}

		@JsonProperty("id")
		public void setId(int id) {
			this.id = id;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

	}
}