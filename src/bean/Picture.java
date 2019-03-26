package bean;

public class Picture {
	private String id;
	private String picture;
	private String customerId;

	public Picture() {
		super();
	}

	public Picture(String id, String picture, String customerId) {
		super();
		this.id = id;
		this.picture = picture;
		this.customerId = customerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
