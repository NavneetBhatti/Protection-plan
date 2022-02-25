//package ProtectionPlan.model;
//
//public class claims{
//
//}

package ProtectionPlan.model;

public class claims{

	int id;
	String username;
	int protectionid;
	String claimdate; // should i make this date type?
	String description;
	String issue;
	int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProtectionid() {
		return protectionid;
	}
	public void setProtectionid(int protectionid) {
		this.protectionid = protectionid;
	}
	public String getClaimdate() {
		return claimdate;
	}
	public void setClaimdate(String claimdate) {
		this.claimdate = claimdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public claims() {
		this.id = 0;
		this.username = "";
		this.protectionid = 0;
		this.claimdate = ""; // should i make this date type?
		this.description = "";
		this.issue = "";
		this.status = 0;		
	}
	
	public claims(int id, String username,	int protectionid, String claimdate,
			String description, String issue,int status) {
		this.id = id;
		this.username = username;
		this.protectionid = protectionid;
		this.claimdate = claimdate;
		this.description = description;		
		this.issue = issue;		
		this.status = status;	
	}
	
}
