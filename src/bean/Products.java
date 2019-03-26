package bean;

public class Products {
	private String id;
	private String name;
	private String categoryId;
	private double unitPrice;
	private String description;
	private String status;
	private String createdAt;

	public Products() {
		super();
	}

	public Products(String id, String name, String categoryId, double unitPrice, String description, String status,
			String createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.unitPrice = unitPrice;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
