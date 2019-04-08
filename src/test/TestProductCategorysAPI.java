package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import bean.ProductCategory;
import com.google.gson.Gson;

import bean.Status;
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
	public String testInsertProductCategory(String name, String description, String created_at) {
		Form form = new Form();
		form.param("name", name);
		form.param("description", description);
		form.param("created_at", created_at);
		
		String callResult = client.target(REST_SERVICE_URL).request("application/json")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		return result;
	}
	public String testUpdateProductCategory(String id, String name, String description, String created_at) {
		Form form = new Form();
		form.param("id", id);
		form.param("name", name);
		form.param("description", description);
		form.param("created_at", created_at);

		String callResult = client.target(REST_SERVICE_URL).request("application/json")
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		return result;
	}
	public String testDeleteProductCategory(String id) {
		String callResult = client.target(REST_SERVICE_URL).path("/{id}").resolveTemplate("id", id)
				.request("application/json").delete(String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		System.out.println("Test case name: testDeleteProductCategory, Result: " + result);
		return result;
	}
	
	
	public static void main(String[] args) {
		TestProductCategorysAPI test = new TestProductCategorysAPI();
		//test.testGetAllProductCategorys();
//		Gson g = new Gson();
//		Status status = g.fromJson(test.testDeleteProductCategory("8"), Status.class);
//		System.out.println(status.getStatus());
		test.testDeleteProductCategory("11");
	}
}
