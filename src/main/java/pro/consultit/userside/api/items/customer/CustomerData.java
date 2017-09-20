package pro.consultit.userside.api.items.customer;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerData {

	@JsonProperty("id")
	private String id;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("flag_corporate")
	private int flagCorporate;
	@JsonProperty("balance")
	private Double balance;
	@JsonProperty("state_id")
	private int stateId;
	@JsonProperty("date_create")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateCreate;
	@JsonProperty("date_connect")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateConnect;
	@JsonProperty("date_activity")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateActivity;
	@JsonProperty("date_activity_inet")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateActivityInet;
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
	public Double getBalance() {
		return balance;
	}

	@JsonProperty("balance")
	public void setBalance(Double balance) {
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
	public Date getDateCreate() {
		return dateCreate;
	}

	@JsonProperty("date_create")
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@JsonProperty("date_connect")
	public Date getDateConnect() {
		return dateConnect;
	}

	@JsonProperty("date_connect")
	public void setDateConnect(Date dateConnect) {
		this.dateConnect = dateConnect;
	}

	@JsonProperty("date_activity")
	public Date getDateActivity() {
		return dateActivity;
	}

	@JsonProperty("date_activity")
	public void setDateActivity(Date dateActivity) {
		this.dateActivity = dateActivity;
	}

	@JsonProperty("date_activity_inet")
	public Date getDateActivityInet() {
		return dateActivityInet;
	}

	@JsonProperty("date_activity_inet")
	public void setDateActivityInet(Date dateActivityInet) {
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
















}