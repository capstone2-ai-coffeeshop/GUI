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
	public String testInsertStaff(String fullname, String email, String gender, String DOB, String phone, String accountId) { // à hiểu r, để mò cái insert, xí có chi ko hiểu hỏi nghe. ok, như rứa thôi
		Form form = new Form();
		form.param("fullname", fullname);
		form.param("email", email);
		form.param("gender", gender);
		form.param("dateofbirth", DOB);
		form.param("phone", phone);
		form.param("accountid", accountId);
		//form.param("fullname", "LÃª VÄƒn C");
		//form.param("email", "clen@gmai.com");
		//form.param("gender", "1");
		//form.param("dateofbirth", "20/10/1997");
		//form.param("phone", "0337272727");
		//form.param("accountid", "1");
		String callResult = client.target(REST_SERVICE_URL).request("application/json")
			.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
		
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		
		return result;
	}
	public String testUpdateStaff(String id, String fullname, String email, String gender, String DOB, String phone) {
		Form form = new Form();
		form.param("id", id);
		form.param("fullname", fullname);
		form.param("email", email);
		form.param("gender", gender);
		form.param("dateofbirth", DOB);
		form.param("phone", phone);
		
		String callResult = client.target(REST_SERVICE_URL).request("application/json")
			.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
		
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		
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
	
	}
}
