package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import bean.Bills;
import bean.BillItems;

public class TestBillsAPI {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/Restful_API_AI_CoffeeShop/bills/action-bills";
	private String REST_SERVICE_URL1 = "http://localhost:8080/Restful_API_AI_CoffeeShop/bills/action-billinfo";
	private static final String SUCCESS_RESULT = "{\"status\":\"success\"}";
	private static final String PASS = "{\"status\": \"pass\"}";
	private static final String FAIL = "{\"status\": \"fail\"}";
	
	public TestBillsAPI() {
		this.client = ClientBuilder.newClient();
	}
	
/////////////////////////////////////////////////////
	public String testInsertBills(String staff_id, String customer_id, String table_id, String created_at) { 
		Form form = new Form();
		form.param("staff_id", staff_id);
		form.param("customer_id", customer_id);
		form.param("table_id", table_id);
		form.param("created_at", created_at);
		String callResult = client.target(REST_SERVICE_URL).request("application/json")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		System.out.println(result);
		return result;
	}
	public String testInsertBillsInfo(String product_id, String quantity, String session, String weather, String discount, String description) { 
		Form form = new Form();
		form.param("product_id", product_id);
		form.param("quantity", quantity);
		form.param("session", session);
		form.param("weather", weather);
		form.param("discount", discount);
		form.param("description", description);
		String callResult = client.target(REST_SERVICE_URL1).request("application/json")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		TestBillsAPI test = new TestBillsAPI();
		test.testInsertBills("9", "1", "2", "2019/04/04 11:00:00");
		test.testInsertBillsInfo("4", "2", "1", "1", "0", "No");
	}
}
