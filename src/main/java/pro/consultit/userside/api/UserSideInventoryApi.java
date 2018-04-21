package pro.consultit.userside.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pro.consultit.userside.api.items.InventoryCatalogItem;
import pro.consultit.userside.api.items.InventoryCatalogSectionItem;
import pro.consultit.userside.api.items.InventoryListItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSideInventoryApi extends AbstractUserSideClient {
	public UserSideInventoryApi(ObjectMapper objectMapper, String url, String key) {
		super(objectMapper, url, key);
	}

	public UserSideInventoryApi(ObjectMapper objectMapper, String url, String key, int timeout) {
		super(objectMapper, url, key, timeout);
	}

	/**
	 * Looking for item inventory category identifier by item name
	 *
	 * @param name Item name to find
	 * @return id of US category or null if not found
	 * @throws IOException
	 * @throws UserSideApiErrorException
	 */
	public Integer getCatalogId(String name) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "get_inventory_catalog_id_by_name"));
		params.add(new BasicNameValuePair("name", name));
		return executeIdRequest(params);
	}

	/**
	 * Looking for item inventory category identifier by item name
	 *
	 * @return id of US category or null if not found
	 * @throws IOException
	 * @throws UserSideApiErrorException
	 */
	public List<InventoryCatalogItem> getInventoryCatalogList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "get_inventory_catalog"));
		return executeIndexEncapsulatedRequest(InventoryCatalogItem.class, params);
	}

	/**
	 * Looking for item inventory category identifier by item name
	 *
	 * @return id of US category or null if not found
	 * @throws IOException
	 * @throws UserSideApiErrorException
	 */
	public List<InventoryCatalogSectionItem> getInventoryCatalogSectionList() throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "get_inventory_section_catalog"));
		return executeIndexEncapsulatedRequest(InventoryCatalogSectionItem.class, params);

	}

	/**
	 * Looking for item inventory id by asset number
	 *
	 * @param assetNumber asset number
	 * @return id of inventory item or null if not found
	 * @throws IOException
	 * @throws UserSideApiErrorException
	 */

	public Integer getInventoryId(String assetNumber) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "get_inventory_id"));
		params.add(new BasicNameValuePair("data_typer", "inventory_number"));
		params.add(new BasicNameValuePair("data_value", assetNumber));
		return executeIdRequest(params);
	}

	/**
	 * Looking for item inventory id by asset number
	 *
	 * @param inventoryId inventoryId
	 * @return id of inventory item or null if not found
	 * @throws IOException
	 * @throws UserSideApiErrorException
	 */

	public InventoryListItem getInventoryById(int inventoryId) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "get_inventory"));
		params.add(new BasicNameValuePair("id", String.valueOf(inventoryId)));
		return executeEncapsulatedRequest(InventoryListItem.class, params);
	}

	public Integer addInventory(int catalogId, int traderId, int amount, double cost, int storageId, String serial, String assetNumber) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "add_inventory"));
		params.add(new BasicNameValuePair("inventory_catalog_id", String.valueOf(catalogId)));
		params.add(new BasicNameValuePair("trader_id", String.valueOf(traderId)));
		params.add(new BasicNameValuePair("amount", String.valueOf(amount)));
		params.add(new BasicNameValuePair("cost", String.valueOf(cost)));
		params.add(new BasicNameValuePair("storage_id", String.valueOf(storageId)));
		params.add(new BasicNameValuePair("sn", serial));
		params.add(new BasicNameValuePair("inventory_number", assetNumber));
		return executeIdRequest(params);
	}

	public Integer inventoryTransfer(int inventoryId, String dstAccount) throws IOException, UserSideApiErrorException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("cat", "inventory"));
		params.add(new BasicNameValuePair("action", "transfer_inventory"));
		params.add(new BasicNameValuePair("inventory_id", String.valueOf(inventoryId)));
		params.add(new BasicNameValuePair("dst_account", String.valueOf(dstAccount)));
		return executeIdRequest(params);
	}
}
