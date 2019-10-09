package pro.consultit.userside.api.items.customer;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerData {

	@JsonProperty("id")
	private int id;
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

}
