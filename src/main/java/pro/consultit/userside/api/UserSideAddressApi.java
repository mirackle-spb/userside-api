package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.Nullable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.address.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSideAddressApi extends AbstractUserSideClient {
	public UserSideAddressApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideAddressApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	public List<RegionItem> getRegionList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_province"));
		return executeIndexEncapsulatedRequest(RegionItem.class, params);

	}

	public List<RegionDistrictItem> getRegionDistrictList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_provinsadfce"));
		return executeIndexEncapsulatedRequest(RegionDistrictItem.class, params);
	}

	public List<CityItem> getCityList(Integer regionId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_city"));
		if (regionId != null) {
			params.add(new BasicNameValuePair("province_id", regionId.toString()));
		}
		return executeIndexEncapsulatedRequest(CityItem.class, params);

	}

	public List<CityDistrictItem> getCityDistrictList(Integer cityId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_area"));
		if (cityId != null) {
			params.add(new BasicNameValuePair("city_id", cityId.toString()));
		}
		return executeIndexEncapsulatedRequest(CityDistrictItem.class, params);

	}

	public List<StreetItem> getStreetList(@Nullable List<Integer> cityIdList, List<Integer> cityRegionIdList) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_street"));
		if (cityIdList != null) {
			params.add(new BasicNameValuePair("city_id", String.join(",", cityIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		if (cityRegionIdList != null && cityRegionIdList.size() > 0) {
			params.add(new BasicNameValuePair("area_id", String.join(",", cityRegionIdList.stream().map(Object::toString).collect(Collectors.toList()))));
		}
		return executeIndexEncapsulatedRequest(StreetItem.class, params);

	}

	public List<HouseItem> getHouse(List<Integer> cityIdList, List<Integer> cityRegionIdList, List<Integer> streetIdList) throws IOException, UserSideApiErrorException {
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

		return executeIndexEncapsulatedRequest(HouseItem.class, params);
	}

	public HouseItem getHouse(Integer houseId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "address"));
		params.add(new BasicNameValuePair("action", "get_house"));
		params.add(new BasicNameValuePair("id", String.valueOf(houseId)));
		List<HouseItem> result = executeIndexEncapsulatedRequest(HouseItem.class, params);
		return result.stream().findFirst().orElse(null);
	}
}
