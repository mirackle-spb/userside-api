package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.customer.CustomerData;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSideCustomerApi extends AbstractUserSideClient {
	public UserSideCustomerApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideCustomerApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public Integer getCustomerByBillingId(int billingId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "get_abon_id"));
		params.add(new BasicNameValuePair("data_typer", "billing_uid"));
		params.add(new BasicNameValuePair("data_value", String.valueOf(billingId)));
		return executeIdRequest(params);
	}

	public List<Integer> getCustomerByPhone(String customerPhone, boolean skipArchive) throws IOException, UserSideApiErrorException {

		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "get_abon_id"));
		params.add(new BasicNameValuePair("data_typer", "phone"));
		params.add(new BasicNameValuePair("data_value", customerPhone));
		if (skipArchive) {
			params.add(new BasicNameValuePair("is_skip_old", "1"));
		} else {
			params.add(new BasicNameValuePair("is_skip_old", "0"));
		}
		return executeIdArrayRequest(params);
	}

	public CustomerData getCustomerData(int customerId) throws IOException, UserSideApiErrorException {

		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "get_data"));
		params.add(new BasicNameValuePair("customer_id", Integer.toString(customerId)));

		return executeEncapsulatedRequest(CustomerData.class, params);
	}

	public Integer addClient(@NotNull String clientFullname, Integer clientBillingId, Integer billingId, Boolean isPotential) throws IOException, UserSideApiErrorException {

		List<NameValuePair> params = new ArrayList<>();

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "add"));
		params.add(new BasicNameValuePair("fio", clientFullname));
		if (clientBillingId != null && billingId != null) {
			params.add(new BasicNameValuePair("codeti", String.valueOf(clientBillingId)));
			params.add(new BasicNameValuePair("billing_id", String.valueOf(billingId)));
		}
		if (isPotential != null) {
			params.add(new BasicNameValuePair("is_potential", isPotential ? "1" : "0"));
		}
		return executeIdRequest(params);
	}

	public boolean editClient(@NotNull Integer clientId, String clientFullname,
	                          String agreementNumber, Date agreementDate,
	                          String apartmentNumber, String email,
	                          String floor, Integer houseId, String login,
	                          String phone0, String phone1, Boolean isPotential) throws IOException, UserSideApiErrorException {

		List<NameValuePair> params = new ArrayList<>();

		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "customer"));
		params.add(new BasicNameValuePair("subcat", "edit"));
		params.add(new BasicNameValuePair("id", String.valueOf(clientId)));
		if (clientFullname != null) {
			params.add(new BasicNameValuePair("name", clientFullname));
		}
		if (agreementNumber != null && agreementDate != null) {
			params.add(new BasicNameValuePair("agreement_number", String.valueOf(agreementNumber)));
			params.add(new BasicNameValuePair("agreement_date", String.valueOf(agreementDate)));
		}
		if (email != null) {
			params.add(new BasicNameValuePair("email", email));
		}
		if (houseId != null) {
			params.add(new BasicNameValuePair("house_id", String.valueOf(houseId)));
		}
		if (apartmentNumber != null) {
			params.add(new BasicNameValuePair("apartment_number", apartmentNumber));
		}
		if (floor != null) {
			params.add(new BasicNameValuePair("floor", String.valueOf(floor)));
		}
		if (login != null) {
			params.add(new BasicNameValuePair("login", login));
		}
		if (phone0 != null) {
			params.add(new BasicNameValuePair("phone0", phone0));
		}
		if (phone1 != null) {
			params.add(new BasicNameValuePair("phone1", phone1));
		}
		if (isPotential != null) {
			params.add(new BasicNameValuePair("is_potential", isPotential ? "1" : "0"));
		}
		return executeBooleanRequest(params);
	}

}
