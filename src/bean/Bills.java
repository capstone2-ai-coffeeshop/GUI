package bean;

public class Bills {
	private String id;
	private String staffId;
	private String customerId;
	private String tableId;
	private String status;
	private String createAt;

	public Bills() {
		super();
	}

	public Bills(String id, String staffId, String customerId, String tableId, String status, String createAt) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.customerId = customerId;
		this.tableId = tableId;
		this.status = status;
		this.createAt = createAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

}
