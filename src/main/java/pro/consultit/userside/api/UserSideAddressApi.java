package pro.consultit.userside.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.IndexEncapsulatedResponse;
import pro.consultit.userside.api.items.address.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserSideAddressApi extends AbstractUserSideClient {
	public UserSideAddressApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideAddressApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public Map<Integer, RegionItem> getRegionList() throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_province"));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, RegionItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, RegionItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, RegionDistrictItem> getRegionDistrictList() throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_provinsadfce"));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, RegionDistrictItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, RegionDistrictItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, CityItem> getCityList(Integer regionId) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_city"));
		if (regionId != null) {
			params.add(new BasicNameValuePair("province_id", regionId.toString()));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, CityItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, CityItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, CityDistrictItem> getCityDistrictList(Integer cityId) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_area"));
		if (cityId != null) {
			params.add(new BasicNameValuePair("city_id", cityId.toString()));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, CityDistrictItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, CityDistrictItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, StreetItem> getStreetList(@NotNull List<Integer> cityIdList, List<Integer> cityRegionIdList) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_street"));
		params.add(new BasicNameValuePair("city_id", String.join(",", cityIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		if (cityRegionIdList != null && cityRegionIdList.size() > 0) {
			params.add(new BasicNameValuePair("area_id", String.join(",", cityRegionIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, StreetItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, StreetItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}

	public Map<Integer, HouseItem> getHouse(List<Integer> cityIdList, List<Integer> cityRegionIdList, List<Integer> streetIdList) throws IOException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_house"));
		if (cityIdList != null && cityIdList.size() > 0) {
			params.add(new BasicNameValuePair("city_id", String.join(",", cityIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		if (cityRegionIdList != null && cityRegionIdList.size() > 0) {
			params.add(new BasicNameValuePair("area_id", String.join(",", cityRegionIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		if (streetIdList != null && streetIdList.size() > 0) {
			params.add(new BasicNameValuePair("street_id", String.join(",", streetIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		HttpGet httpget = new HttpGet(url + "?" + paramString);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		IndexEncapsulatedResponse<Integer, HouseItem> result = objectMapper.readValue(entity.getContent(), new TypeReference<IndexEncapsulatedResponse<Integer, HouseItem>>() {
		});
		if (result.getResult().equalsIgnoreCase("OK") || result.getData().size() > 0) {
			return result.getData();
		} else {
			return null;
		}
	}
}
