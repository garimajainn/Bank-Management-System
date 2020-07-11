package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Banker;
import com.dao.BankerDao;

public class BankingService {
	
	
	public boolean getBankingService(Banker banker) 
	{
		BankerDao bankerdao = new BankerDao();
		boolean bankerFound = bankerdao.getBanker(banker);
		return bankerFound;
	}
	
	public Integer insertCustomerService(Banker banker) 
	{
		BankerDao bankerdao = new BankerDao();
		int id = bankerdao.insertCustomer(banker);
		return id;
	}
	public static Banker viewCustomerServiceCid(String id) 
	{
		BankerDao bankerdao = new BankerDao();
		Banker banker = bankerdao.searchCustomerByCid(id);
		return banker;
	}
	public static Banker viewCustomerServiceSid(String id) 
	{
		BankerDao bankerdao = new BankerDao();
		Banker banker = bankerdao.searchCustomerBySid(id);
		return banker;
	}

	public int updateCustomerService(Banker banker) {
		BankerDao bankerdao = new BankerDao();
		int cnt = bankerdao.updateCustomer(banker);
		return cnt;
	}

	public int deleteCustomerService(Banker banker) {
		BankerDao bankerdao = new BankerDao();
		int cnt = bankerdao.deleteCustomer(banker);
		return cnt;
	}
	public boolean transferAmount(String id,String sourceAccount,String targetAccount,int amountTransfer) throws SQLException {	
		BankerDao bankerdao = new BankerDao();
		return bankerdao.transferAmount(id,sourceAccount,targetAccount,amountTransfer);
	}
	public static Integer createAccService(Banker banker) {
		BankerDao bankerdao = new BankerDao();
		Integer accid= bankerdao.createAcc(banker);
		return accid ;
	}

	public static Banker viewAccountServiceAid(String accid) {
		BankerDao bankerdao = new BankerDao();
		Banker banker = bankerdao.searchAccountByAid(accid);
		return banker;
	}

	public Banker viewAccountServiceSid(String id) {
		BankerDao bankerdao = new BankerDao();
		Banker banker = bankerdao.searchAccountBySid(id);
		return banker;
	}

	public Banker viewAccountServiceCid(String id) {
		BankerDao bankerdao = new BankerDao();
		Banker banker = bankerdao.searchAccountByCid(id);
		return banker;
	}

	public int deleteAccountService(Banker banker) {
		BankerDao bankerdao = new BankerDao();
		int cnt = bankerdao.deleteAccount(banker);
		return cnt;
	}

	public int depositAmtService(Banker banker) {
		BankerDao bankerdao = new BankerDao();
		int cnt = bankerdao.depositAmount(banker);
		return cnt;
	}

	public int withdrawAmtService(Banker banker) {
		BankerDao bankerdao = new BankerDao();
		int cnt = bankerdao.withdrawAmount(banker);
		return cnt;
	}

	public ArrayList<Banker> viewCstatus() {
		BankerDao bankerdao = new BankerDao();
		return bankerdao.viewCstatus();
	}

	public ArrayList<Banker> viewAstatus() {
		BankerDao bankerdao = new BankerDao();
		return bankerdao.viewAstatus();
	}

}
