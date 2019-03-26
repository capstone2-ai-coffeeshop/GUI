package bean;

public class BillItems {
	private String id;
	private String billId;
	private String productId;
	private String quantity;
	private String session;
	private String time;
	private String weather;
	private String unitPrice;
	private float discount;
	private String description;

	public BillItems() {
		super();
	}

	public BillItems(String id, String billId, String productId, String quantity, String session, String time,
			String weather, String unitPrice, float discount, String description) {
		super();
		this.id = id;
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
		this.session = session;
		this.time = time;
		this.weather = weather;
		this.unitPrice = unitPrice;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
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
