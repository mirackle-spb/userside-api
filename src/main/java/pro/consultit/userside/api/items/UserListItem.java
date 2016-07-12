package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserListItem {
	private int id;
	private String login;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("flag_corporate")
	@JsonSerialize(using = NumericBooleanSerializer.class)
	@JsonDeserialize(using = NumericBooleanDeserializer.class)
	private boolean corporate;
	@JsonProperty("tariff")
	private Map<String, Map<String, Map<String, String>>> tariffInfo;
	@JsonProperty("agreement")
	private List<AgreementInfo> agreementInfo;
	@JsonProperty("account_number")
	private int accountNumber;
	@JsonProperty("group")
	private Map<Integer, GroupInfo> groupInfo;
	private String comment;
	private double balance;
	private double credit;
	@JsonProperty("state_id")
	private int status;
	@JsonProperty("date_create")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@JsonProperty("date_connect")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date connectDate;
	@JsonProperty("date_activity")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastActivity;
	@JsonProperty("traffic")
	private Map<String, TrafficInfo> trafficInfo;
	@JsonProperty("address")
	private List<AddressInfo> addressInfo;
	@JsonProperty("phone")
	private List<PhoneInfo> phoneInfo;
	@JsonProperty("email")
	private List<EmailInfo> emailInfo;
	@JsonProperty("ip_mac")
	private Map<Long, IpInfo> ipInfo;


	public UserListItem(int id, String login, String fullName, boolean corporate, Map<String, Map<String, Map<String, String>>> tariffInfo, List<AgreementInfo> agreementInfo,
	                    int accountNumber, Map<Integer, GroupInfo> groupInfo, String comment, double balance, double credit, int status, Date createDate, Date connectDate,
	                    Date lastActivity, Map<String, TrafficInfo> trafficInfo, List<AddressInfo> addressInfo, List<PhoneInfo> phoneInfo, List<EmailInfo> emailInfo,
	                    Map<Long, IpInfo> ipInfo) {
		this.id = id;
		this.login = login;
		this.fullName = fullName;
		this.corporate = corporate;
		this.tariffInfo = tariffInfo;
		this.agreementInfo = agreementInfo;
		this.accountNumber = accountNumber;
		this.groupInfo = groupInfo;
		this.comment = comment;
		this.balance = balance;
		this.credit = credit;
		this.status = status;
		this.createDate = createDate;
		this.connectDate = connectDate;
		this.lastActivity = lastActivity;
		this.trafficInfo = trafficInfo;
		this.addressInfo = addressInfo;
		this.phoneInfo = phoneInfo;
		this.emailInfo = emailInfo;
		this.ipInfo = ipInfo;
	}

	public int getId() {
		return id;
	}

	public UserListItem setId(int id) {
		this.id = id;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public UserListItem setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public UserListItem setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public boolean isCorporate() {
		return corporate;
	}

	public UserListItem setCorporate(boolean corporate) {
		this.corporate = corporate;
		return this;
	}

	public Map<String, Map<String, Map<String, String>>> getTariffInfo() {
		return tariffInfo;
	}

	public UserListItem setTariffInfo(Map<String, Map<String, Map<String, String>>> tariffInfo) {
		this.tariffInfo = tariffInfo;
		return this;
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	public UserListItem setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public UserListItem setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public double getBalance() {
		return balance;
	}

	public UserListItem setBalance(double balance) {
		this.balance = balance;
		return this;
	}

	public double getCredit() {
		return credit;
	}

	public UserListItem setCredit(double credit) {
		this.credit = credit;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public UserListItem setStatus(int status) {
		this.status = status;
		return this;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public UserListItem setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}

	public Date getConnectDate() {
		return connectDate;
	}

	public UserListItem setConnectDate(Date connectDate) {
		this.connectDate = connectDate;
		return this;
	}

	public Date getLastActivity() {
		return lastActivity;
	}

	public UserListItem setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
		return this;
	}

	public Map<String, TrafficInfo> getTrafficInfo() {
		return trafficInfo;
	}

	public UserListItem setTrafficInfo(Map<String, TrafficInfo> trafficInfo) {
		this.trafficInfo = trafficInfo;
		return this;
	}


	public Map<Long, IpInfo> getIpInfo() {
		return ipInfo;
	}

	public UserListItem setIpInfo(Map<Long, IpInfo> ipInfo) {
		this.ipInfo = ipInfo;
		return this;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class IpInfo {
		private Long ip;
		private String mac;
		@JsonProperty("ip_net")
		private String ipnet;

		public IpInfo(Long ip) {
			this.ip = ip;
		}

		public IpInfo(Long ip, String mac) {
			this.ip = ip;
			this.mac = mac;
		}

		public IpInfo(String ipnet) {
			this.ipnet = ipnet;
		}

		public Long getIp() {
			return ip;
		}

		public IpInfo setIp(Long ip) {
			this.ip = ip;
			return this;
		}

		public String getMac() {
			return mac;
		}

		public IpInfo setMac(String mac) {
			this.mac = mac;
			return this;
		}

		public String getIpnet() {
			return ipnet;
		}

		public IpInfo setIpnet(String ipnet) {
			this.ipnet = ipnet;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class EmailInfo {
		private String address;
		@JsonProperty("flag_main")
		@JsonSerialize(using = NumericBooleanSerializer.class)
		@JsonDeserialize(using = NumericBooleanDeserializer.class)
		private boolean main;
		private String comment;

		public EmailInfo(String address, boolean main, String comment) {
			this.address = address;
			this.main = main;
			this.comment = comment;
		}

		public String getAddress() {
			return address;
		}

		public EmailInfo setAddress(String address) {
			this.address = address;
			return this;
		}

		public boolean isMain() {
			return main;
		}

		public EmailInfo setMain(boolean main) {
			this.main = main;
			return this;
		}

		public String getComment() {
			return comment;
		}

		public EmailInfo setComment(String comment) {
			this.comment = comment;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class PhoneInfo {
		private String number;
		@JsonProperty("flag_main")
		@JsonSerialize(using = NumericBooleanSerializer.class)
		@JsonDeserialize(using = NumericBooleanDeserializer.class)
		private boolean main;
		private String comment;

		public PhoneInfo(String number, boolean main, String comment) {
			this.number = number;
			this.main = main;
			this.comment = comment;
		}

		public String getNumber() {
			return number;
		}

		public PhoneInfo setNumber(String number) {
			this.number = number;
			return this;
		}

		public boolean isMain() {
			return main;
		}

		public PhoneInfo setMain(boolean main) {
			this.main = main;
			return this;
		}

		public String getComment() {
			return comment;
		}

		public PhoneInfo setComment(String comment) {
			this.comment = comment;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class AddressInfo {
		@JsonProperty("full_name")
		private String fullName;
		private String type;
		@JsonProperty("house_id")
		private Integer objectId;
		private AddressAppartementInfo apartment;
		private Integer entrance;
		private Integer floor;

		public AddressInfo(String fullName, String type, Integer objectId, AddressAppartementInfo apartment, Integer entrance, Integer floor) {
			this.fullName = fullName;
			this.type = type;
			this.objectId = objectId;
			this.apartment = apartment;
			this.entrance = entrance;
			this.floor = floor;
		}

		public String getFullName() {
			return fullName;
		}

		public AddressInfo setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public String getType() {
			return type;
		}

		public AddressInfo setType(String type) {
			this.type = type;
			return this;
		}

		public Integer getObjectId() {
			return objectId;
		}

		public AddressInfo setObjectId(Integer objectId) {
			this.objectId = objectId;
			return this;
		}

		public AddressAppartementInfo getApartment() {
			return apartment;
		}

		public AddressInfo setApartment(AddressAppartementInfo apartment) {
			this.apartment = apartment;
			return this;
		}

		public Integer getEntrance() {
			return entrance;
		}

		public AddressInfo setEntrance(Integer entrance) {
			this.entrance = entrance;
			return this;
		}

		public Integer getFloor() {
			return floor;
		}

		public AddressInfo setFloor(Integer floor) {
			this.floor = floor;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class AddressAppartementInfo {
		private int id;
		@JsonProperty("full_name")
		private String name;
		private Integer number;
		private String block;

		public AddressAppartementInfo(String name, Integer number, String block) {
			this.name = name;
			this.number = number;
			this.block = block;
		}


		public String getName() {
			return name;
		}

		public AddressAppartementInfo setName(String name) {
			this.name = name;
			return this;
		}

		public Integer getNumber() {
			return number;
		}

		public AddressAppartementInfo setNumber(Integer number) {
			this.number = number;
			return this;
		}

		public String getBlock() {
			return block;
		}

		public AddressAppartementInfo setBlock(String block) {
			this.block = block;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class TrafficInfo {
		private long up;
		private long down;

		public TrafficInfo(long up, long down) {
			this.up = up;
			this.down = down;
		}

		public long getUp() {
			return up;
		}

		public TrafficInfo setUp(long up) {
			this.up = up;
			return this;
		}

		public long getDown() {
			return down;
		}

		public TrafficInfo setDown(long down) {
			this.down = down;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class GroupInfo {
		private int id;

		public GroupInfo(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public GroupInfo setId(int id) {
			this.id = id;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class AgreementInfo {
		private String number;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private Date date;

		public AgreementInfo(String number, Date date) {
			this.number = number;
			this.date = date;
		}

		public String getNumber() {
			return number;
		}

		public AgreementInfo setNumber(String number) {
			this.number = number;
			return this;
		}

		public Date getDate() {
			return date;
		}

		public AgreementInfo setDate(Date date) {
			this.date = date;
			return this;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class TariffInfo {
		private int id;
		@JsonProperty("date_start")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
		private Date dateStart;
		@JsonProperty("date_finish")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
		private Date dateStop;


		public TariffInfo(int id, Date dateStart, Date dateStop) {
			this.id = id;
			this.dateStart = dateStart;
			this.dateStop = dateStop;
		}

		public int getId() {
			return id;
		}

		public TariffInfo setId(int id) {
			this.id = id;
			return this;
		}

		public Date getDateStart() {
			return dateStart;
		}

		public TariffInfo setDateStart(Date dateStart) {
			this.dateStart = dateStart;
			return this;
		}

		public Date getDateStop() {
			return dateStop;
		}

		public TariffInfo setDateStop(Date dateStop) {
			this.dateStop = dateStop;
			return this;
		}
	}
}
