package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import bean.Tables;

public class TestTablesAPI {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/Restful_API_AI_CoffeeShop/tables/action-tables";
	private static final String SUCCESS_RESULT = "{\"status\":\"success\"}";
	private static final String PASS = "{\"status\": \"pass\"}";
	private static final String FAIL = "{\"status\": \"fail\"}";
	
	public TestTablesAPI() {
		this.client = ClientBuilder.newClient();
	}
	
/////////////////////////////////////////////////////
	public List<Tables> testGetAllTables() {
		GenericType<List<Tables>> list = new GenericType<List<Tables>>() {
		};
		List<Tables> tables = client.target(REST_SERVICE_URL).request("application/json").get(list);
		String result = PASS;
		if (tables.isEmpty()) {
			result = FAIL;
		}
		//System.out.println("Test case name: testGetAllTables, Result: " + result);
		return tables;
	}
	public String testUpdateTable(String id, String quantityOfCustomer, String description, String status) {
		Form form = new Form();
		form.param("id", id);
		form.param("quantityOfCustomer", quantityOfCustomer);
		form.param("description", description);
		form.param("status", status);
		
		String callResult = client.target(REST_SERVICE_URL).request("application/json")
			.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
		
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		//System.out.println(result);
		return result;
	}
	public String testDeleteStaff(String id) {
		String callResult = client.target(REST_SERVICE_URL).path("/{id}").resolveTemplate("id", id)
			.request("application/json").delete(String.class);
		
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		
		System.out.println("Test case name: testDeleteUser, Result: " + result);
		return result;
	}


	public static void main(String[] args) {
		TestTablesAPI test = new TestTablesAPI();
		test.testUpdateTable("1", "0", "No Descriptionnn", "0");
		//test.testGetAllTables();
	}
}
