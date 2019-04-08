package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import bean.Customer;

public class TestCustomersAPI {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/Restful_API_AI_CoffeeShop/customers/action-customers";
	private static final String SUCCESS_RESULT = "{\"status\":\"success\"}";
	private static final String PASS = "{\"status\": \"pass\"}";
	private static final String FAIL = "{\"status\": \"fail\"}";

	public TestCustomersAPI() {
		this.client = ClientBuilder.newClient();
	}
	
/////////////////////////////////////////////////////
	public List<Customer> testGetAllCustomers() {
		GenericType<List<Customer>> list = new GenericType<List<Customer>>() {
		};
		List<Customer> customers = client.target(REST_SERVICE_URL).request("application/json").get(list);
		String result = PASS;
		if (customers.isEmpty()) {
			result = FAIL;
		}
		//System.out.println("Test case name: testGetAllCustomers, Result: " + result);
		return customers;
	}
	
	public static void main(String[] args) {
		TestCustomersAPI test = new TestCustomersAPI();
		test.testGetAllCustomers();
	}
}
