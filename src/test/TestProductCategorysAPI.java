package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import bean.ProductCategory;

public class TestProductCategorysAPI {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/Restful_API_AI_CoffeeShop/categorys/action-categorys"; 
	private static final String SUCCESS_RESULT = "{\"status\":\"success\"}";
	private static final String PASS = "{\"status\": \"pass\"}";
	private static final String FAIL = "{\"status\": \"fail\"}";

	public TestProductCategorysAPI() {
		this.client = ClientBuilder.newClient();
	}
	
/////////////////////////////////////////////////////	
	public List<ProductCategory> testGetAllProductCategorys() {
		GenericType<List<ProductCategory>> list = new GenericType<List<ProductCategory>>() {
		};
		List<ProductCategory> categorys = client.target(REST_SERVICE_URL).request("application/json").get(list);
		String result = PASS;
		if (categorys.isEmpty()) {
		result = FAIL;
		}
		//System.out.println("Test case name: testGetAllProductCategorys, Result: " + result);
		return categorys;
	}
	
	public static void main(String[] args) {
		TestProductCategorysAPI test = new TestProductCategorysAPI();
		test.testGetAllProductCategorys();
	}
}
