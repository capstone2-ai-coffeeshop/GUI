package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import bean.Products;

public class TestProductsAPI {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/Restful_API_AI_CoffeeShop/products/action-products"; 
	private static final String SUCCESS_RESULT = "{\"status\":\"success\"}";
	private static final String PASS = "{\"status\": \"pass\"}";
	private static final String FAIL = "{\"status\": \"fail\"}";

	public TestProductsAPI() {
		this.client = ClientBuilder.newClient();
	}
	
/////////////////////////////////////////////////////lỗi gì? có bị gì đâu, mỗi lần  tạo file test mới là phải chạy cái restful hả, khi nào mất kết nối như nãy biuld lại cái restfull, k biu sao có API mà xài
	public List<Products> testGetAllProducts() {
		GenericType<List<Products>> list = new GenericType<List<Products>>() {
		};
		List<Products> products = client.target(REST_SERVICE_URL).request("application/json").get(list);
		String result = PASS;
		if (products.isEmpty()) {
		result = FAIL;
		}
		//System.out.println("Test case name: testGetAllUsers, Result: " + result);
		return products;
	}
	public Products testGetProduct(String id) {
		Products product = client.target(REST_SERVICE_URL).path("/{id}").resolveTemplate("id", id)
				.request("application/json").get(Products.class);
		String result = FAIL;
		if (product != null) {
			result = PASS;
		}
		//System.out.println("Test case name: testGetProduct, Result: " + result);
		return product;
	}
	public String testInsertProduct(String name, String categoryID, String unitprice, String description, String status, String createdAt) {
		Form form = new Form();
		form.param("name", name);
		form.param("categoryid", categoryID);
		form.param("unitprice", unitprice);
		form.param("description", description);
		form.param("status", status);
		form.param("createdat", createdAt);
		String callResult = client.target(REST_SERVICE_URL).request("application/json")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		return result;
	}
	public String testUpdateProduct(String id, String name, String categoryID, String unitprice, String description, String status, String createdAt) {
		Form form = new Form();
		form.param("id", id);
		form.param("name", name);
		form.param("categoryid", categoryID);
		form.param("unitprice", unitprice);
		form.param("description", description);
		form.param("status", status);
		form.param("createdat", createdAt);

		String callResult = client.target(REST_SERVICE_URL).request("application/json")
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		return result;
	}
	public String testDeleteProduct(String id) {
		String callResult = client.target(REST_SERVICE_URL).path("/{id}").resolveTemplate("id", id)
				.request("application/json").delete(String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		//System.out.println("Test case name: testDeleteProduct, Result: " + result);
		return result;
	}
	
	public static void main(String[] args) {
		TestProductsAPI test = new TestProductsAPI();
		test.testGetAllProducts();
		test.testGetProduct("1");
	}
}
