package bean;

public class BillItems {
	private String id;
	private String billId;
	private String productId;
	private String quantity;
	private String session;
	private String weather;
	private float discount;
	private String description;

	public BillItems() {
		super();
	}

	public BillItems(String id, String billId, String productId, String quantity, String session, 
			String weather, float discount, String description) {
		super();
		this.id = id;
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
		this.session = session;
		this.weather = weather;
		this.discount = discount;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
