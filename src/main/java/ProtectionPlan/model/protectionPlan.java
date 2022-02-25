package ProtectionPlan.model;

public class protectionPlan {
	private String username;
	private String productname;
	private String serialnumber;
	private String purchasedate;
	private String productid;
	
	public  protectionPlan() {	
	}
	
	public  protectionPlan(String username, String productname, String serialnumber, String purchasedate) {
		super();
		this.username = username;
		this.productname = productname;
		this.serialnumber = serialnumber;
		this.purchasedate = purchasedate;
		//this.productid = productid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String password) {
		this.productname = productname;
	}
	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String cell) {
		this.serialnumber = serialnumber;
	}

	public String getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(String email) {
		this.purchasedate = purchasedate;
	}

//	public String getProductid() {
//		return productid;
//	}
//
//	public void setProductid(String name) {
//		this.productid = productid;
//	}

	

	
	
	@Override
	public String toString() {
		return "users("+"username="+username+", productname="+productname+", serialnumber="+serialnumber+", purchasedate="+purchasedate+")";
	}
	



}


	
	