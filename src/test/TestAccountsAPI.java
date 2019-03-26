package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import bean.Account;
import bean.Staffs;

public class TestAccountsAPI {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/Restful_API_AI_CoffeeShop/accounts/action-accounts"; 
	private static final String SUCCESS_RESULT = "{\"status\":\"success\"}";
	private static final String PASS = "{\"status\": \"pass\"}";
	private static final String FAIL = "{\"status\": \"fail\"}";

	public TestAccountsAPI() {
		this.client = ClientBuilder.newClient();
	}
	
/////////////////////////////////////////////////////
	public List<Account> testGetAllAccounts() {
		GenericType<List<Account>> list = new GenericType<List<Account>>() {
		};
		List<Account> accounts = client.target(REST_SERVICE_URL).request("application/json").get(list);
		String result = PASS;
		if (accounts.isEmpty()) {
		result = FAIL;
		}
		//System.out.println("Test case name: testGetAllAccounts, Result: " + result);
		return accounts;
	}
	public Account testGetAccount(String id) {
		Account account = client.target(REST_SERVICE_URL).path("/{id}").resolveTemplate("id", id)
				.request("application/json").get(Account.class);
		String result = FAIL;
		if (account != null) {
			result = PASS;
		}
		System.out.println("Test case name: testGetAccount, Result: " + account.getUsername());
		System.out.println(account.getPassword());
		return account;
	}
	public String testInsertAccount(String username, String password, String role) {
		Form form = new Form();
		form.param("username", username);
		form.param("password", password);
		form.param("role", role);
		String callResult = client.target(REST_SERVICE_URL).request("application/json")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		return result;
	}
	public String testUpdateAccount(String username, String password, String newpassword, String cfpassword) {
		Form form = new Form();
		form.param("username", username);
		form.param("password", password);
		form.param("newpassword", newpassword);
		form.param("cfpassword", cfpassword);

		String callResult = client.target(REST_SERVICE_URL).request("application/json")
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}
		System.out.println("Test case name: testUpdateAccount, Result: " + result);
		return result;
	}
	public String testDeleteAccount(String id) {
		String callResult = client.target(REST_SERVICE_URL).path("/{id}").resolveTemplate("id", id)
				.request("application/json").delete(String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testDeleteAccount, Result: " + result);
		return result;
	}
	public Account testGetAccountByUsername(String username) {
		Account account = client.target(REST_SERVICE_URL).path("/{username}").resolveTemplate("username", username)
				.request("application/json").get(Account.class);
		String result = FAIL;
		if (account != null) {
			result = PASS;
		}
		//System.out.println("Test case name: testGetAccountByUsername, Result: " + account.getUsername());
		//System.out.println(account.getPassword());
		return account;
	}
	
	public static void main(String[] args) {
		TestAccountsAPI test = new TestAccountsAPI();
		//test.testGetAllAccounts(); 
		//test.testUpdateAccount("nhanha", "123123", "123456", "123456");
		test.testGetAccountByUsername("nhanha");
	}
}
