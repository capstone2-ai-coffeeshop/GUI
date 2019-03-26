package bean;

public class Tables {
	private String id;
	private int quantityOfCustomer;
	private String description;
	private String status;

	public Tables() {
		super();
	}

	public Tables(String id, int quantityOfCustomer, String description, String status) {
		super();
		this.id = id;
		this.quantityOfCustomer = quantityOfCustomer;
		this.description = description;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantityOfCustomer() {
		return quantityOfCustomer;
	}

	public void setQuantityOfCustomer(int quantityOfCustomer) {
		this.quantityOfCustomer = quantityOfCustomer;
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

}
