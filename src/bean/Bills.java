package bean;

public class Bills {
	private String id;
	private String staffId;
	private String customerId;
	private String tableId;
	private String status;
	private String createAt;
	private double total;

	public Bills() {
		super();
	}

	public Bills(String id, String staffId, String customerId, String tableId, String status, String createAt,
			double total) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.customerId = customerId;
		this.tableId = tableId;
		this.status = status;
		this.createAt = createAt;
		this.total = total;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
