package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ws.rs.PathParam;

import bean.Account;
import bean.Products;
import bean.Staffs;
import bean.Tables;
import bean.ProductCategory;
import bean.Bills;
import bean.BillItems;
import bean.Customer;
import test.TestStaffsAPI;
import test.TestProductsAPI;
import test.TestAccountsAPI;
import test.TestBillsAPI;
import test.TestTablesAPI;
import test.TestProductCategorysAPI;
import test.TestCustomersAPI;

 
public class MySQLConnUtils {
	private final String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/ai_coffeeshop";
	private String userName = "root";
	private String password = "haquangnhan2091";
	private static MySQLConnUtils instance;
	
	private Connection connection;
 
	public Connection connect() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connect Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Connection!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class Not found");
		}
		return connection;
	}
	public Connection createConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, userName, password);
				System.out.println("ok");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection; //còn web đâu mà rub :)))c
	}

/////////////////////////////////////////////////////
	public List<Staffs> getStaffs(){// đây là cái hàm mà mình gọi từ lớp test đó
		TestStaffsAPI t = new TestStaffsAPI();
		return t.testGetAllUsers();
	}
	public String insertStaff(String fullname, String email, String gender, String DOB, String phone, String accountId) { // ri thôi, -> xài, xong qua bên kia gọi lại cái này thôi, có gì đâu :D
		TestStaffsAPI t = new TestStaffsAPI();
		return t.testInsertStaff(fullname, email, gender, DOB, phone, accountId);
	}
	public String updateStaff (String id, String fullname, String email, String gender, String DOB, String phone) {
		TestStaffsAPI t = new TestStaffsAPI();
		return t.testUpdateStaff(id, fullname, email, gender, DOB, phone);
	}
	public String deleteStaff (String id) {
		TestStaffsAPI t = new TestStaffsAPI();
		return t.testDeleteStaff(id);
	}
	
/////////////////////////////////////////////////////
	public List<Products> getProducts(){
		TestProductsAPI t = new TestProductsAPI();
		return t.testGetAllProducts();
	}
	public Products getProduct(String id) {
		TestProductsAPI t = new TestProductsAPI();
		return t.testGetProduct(id);
	}
	public String insertProduct(String name, String categoryID, String unitprice, String description, String status, String createdAt) {
		TestProductsAPI t = new TestProductsAPI();
		return t.testInsertProduct(name, categoryID, unitprice, description, status, createdAt);
	}
	public String updateProduct (String id, String name, String categoryID, String unitprice, String description, String status, String createdAt) {
		TestProductsAPI t = new TestProductsAPI();
		return t.testUpdateProduct(id, name, categoryID, unitprice, description, status, createdAt);
	}
	public String deleteProduct (String id) {
		TestProductsAPI t = new TestProductsAPI();
		return t.testDeleteProduct(id);
	}
	
/////////////////////////////////////////////////////
	public List<Account> getAccounts(){
		TestAccountsAPI t = new TestAccountsAPI();
		return t.testGetAllAccounts();
	}
	public Account getAccount(String id){
		TestAccountsAPI t = new TestAccountsAPI();
		return t.testGetAccount(id);
	}
	public String insertAccount(String username, String password, String role) {
		TestAccountsAPI t = new TestAccountsAPI();
		return t.testInsertAccount(username, password, role);
	}
	public String updateAccount (String username, String password, String newpassword, String cfpassword) {
		TestAccountsAPI t = new TestAccountsAPI();
		return t.testUpdateAccount(username, password, newpassword, cfpassword);
	}
	public String deleteAccount (String id) {
		TestAccountsAPI t = new TestAccountsAPI();
		return t.testDeleteAccount(id);
	}
	
/////////////////////////////////////////////////////
	public List<Tables> getTables() {
		TestTablesAPI t = new TestTablesAPI();
		return t.testGetAllTables();
	}
	public String updateTable (String id, String quantityOfCustomer, String description, String status) {
		TestTablesAPI t = new TestTablesAPI();
		return t.testUpdateTable(id, quantityOfCustomer, description, status);
	}
	
/////////////////////////////////////////////////////
	public List<ProductCategory> getProductCategorys() {
		TestProductCategorysAPI t = new TestProductCategorysAPI();
		return t.testGetAllProductCategorys();
	}
	public String insertProductCategory(String name, String description, String created_at) {
		TestProductCategorysAPI t = new TestProductCategorysAPI();
		return t.testInsertProductCategory(name, description, created_at);
	}
	public String updateProductCategory (String id, String name, String description, String created_at) {
		TestProductCategorysAPI t = new TestProductCategorysAPI();
		return t.testUpdateProductCategory(id, name, description, created_at);
	}
	public String deleteProductCategory (String id) {
		TestProductCategorysAPI t = new TestProductCategorysAPI();
		return t.testDeleteProductCategory(id);
	}
	
/////////////////////////////////////////////////////
	public String insertBill (String staff_id, String customer_id, String table_id, String created_at) {
		TestBillsAPI t = new TestBillsAPI();
		return t.testInsertBills(staff_id, customer_id, table_id, created_at);
	}
	public String insertBillInfo (String product_id, String quantity, String session, String weather, String discount, String description) {
		TestBillsAPI t = new TestBillsAPI();
		return t.testInsertBillsInfo(product_id, quantity, session, weather, discount, description);
	}
	
/////////////////////////////////////////////////////
	public List<Customer> getCustomers() {
		TestCustomersAPI t = new TestCustomersAPI();
		return t.testGetAllCustomers();
	}
	
	public static MySQLConnUtils getInstance() {
		if (instance == null) {
			synchronized (MySQLConnUtils.class) {
				if (instance == null) {
					instance = new MySQLConnUtils();
				}
			}
		}
		return instance;
	}
	

	
	public static void main(String[] args) {
		MySQLConnUtils con = new MySQLConnUtils();
		con.connect();
		//con.getProductCategorys();
		//con.insertBill("9", "2", "2", "2019/04/04/ 11:36:00");
	}

}
