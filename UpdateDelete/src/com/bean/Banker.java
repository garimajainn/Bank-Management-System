package com.bean;

public class Banker {
	
	private String username;
	private String password;
	
	private String cssnid;
	private String cid;
	private String custName;
	private int custAge;
	private String custAddress;
	private String state;
	private String city;
	
	private String accid;
	private String acctype;
	private int amt;
	private int balance;
	
	private String status;
	private String accstatus;
	private String message;
	private String lastupd;
	
		
	
	
	/*public Banker(String cssnid, String cid, int accid) {
		super();
		this.cssnid = cssnid;
		this.cid = cid;
		this.accid = accid;
	}*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCssnid() {
		return cssnid;
	}
	public void setCssnid(String cssnid) {
		this.cssnid = cssnid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	/*public Banker(String username, String password, String cssnid, String cid, String custName, int custAge,
			String custAddress, String state, String city) {
		super();
		this.username = username;
		this.password = password;
		this.cssnid = cssnid;
		this.cid = cid;
		this.custName = custName;
		this.custAge = custAge;
		this.custAddress = custAddress;
		this.state = state;
		this.city = city;
	}*/
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastupd() {
		return lastupd;
	}
	public void setLastupd(String lastupd) {
		this.lastupd = lastupd;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccstatus() {
		return accstatus;
	}
	public void setAccstatus(String accstatus) {
		this.accstatus = accstatus;
	}
		
}
