package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Banker;
import com.controller.BankingController;
import com.util.DatabaseUtil;

public class BankerDao {
	
	
	
public static  boolean getBanker(Banker banker) {
		
		boolean userFound = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		Statement stmt = null;		
		
		try {		
			con = DatabaseUtil.getConnection();
			ps=con.prepareStatement("Select *from userstore where USERNAME=? and PASSWORD=? ");
			ps.setString(1,banker.getUsername());
			ps.setString(2, banker.getPassword());			
			rs = ps.executeQuery(); 
			
			if(rs!=null && rs.next()) {
				userFound = true;
			}
			else {
				userFound = false;
  			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
				}
			catch (SQLException e) {
				}
		}
		return userFound;		
	}

public static Integer insertCustomer(Banker banker) {

	Integer customerId = null;
	int rowstatus = 0;
	String query = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("insert into CustomerAccount_RBM(Customer_ID,SSN_Id,Customer_Name,Customer_Age,Customer_Address,State,City,Status,Message,Last_updated) values(custIdSeq.nextval,?,?,?,?,?,?,'Active','Customer created successfully',CURRENT_TIMESTAMP)");
		ps.setString(1, banker.getCssnid());
		ps.setString(2, banker.getCustName());
		ps.setInt(3, banker.getCustAge());
		ps.setString(4, banker.getCustAddress());		
		ps.setString(5, banker.getState());
		ps.setString(6, banker.getCity());
		
		rowstatus = ps.executeUpdate(); 
		System.out.println(rowstatus);
		query = "Select MAX(Customer_ID) from CustomerAccount_RBM";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) 
		{
			customerId = (Integer)rs.getInt(1);
			banker.setCid(customerId.toString());
			System.out.println("Customer Id :" +customerId);
		}
		//banker.setCid(customerId.toString());
					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return customerId;		
}
public static Banker searchCustomerByCid(String cid) {
	
	Banker banker = new Banker();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	//Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Select *from CustomerAccount_RBM where Customer_ID=?");
		ps.setString(1, cid);
			
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			banker.setCid(rs.getString(1));
			banker.setCssnid(rs.getString(2));
			banker.setCustName(rs.getString(3));
			banker.setCustAge(rs.getInt(4));
			banker.setCustAddress(rs.getString(5));
		}
		System.out.println(banker.getCid());
		System.out.println(banker.getCustAge());
		System.out.println(banker.getCustAddress());
					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return banker;		
}
public static Banker searchCustomerBySid(String sid) {
	
	Banker banker = new Banker();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	//Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Select *from CustomerAccount_RBM where SSN_Id=?");
		ps.setString(1, sid);
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			banker.setCid(rs.getString(1));
			banker.setCssnid(rs.getString(2));
			banker.setCustName(rs.getString(3));
			banker.setCustAge(rs.getInt(4));
			banker.setCustAddress(rs.getString(5));
		}
						
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return banker;		
}

public static int updateCustomer(Banker banker) {
	
	//Integer customerId = null;
	int rowstatus = 0;
	String query = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Update CustomerAccount_RBM SET Customer_Name=?,Customer_Age=?,Customer_Address=?, Status='Active', Message='Customer updated successfully', Last_updated=CURRENT_TIMESTAMP where SSN_ID=? ");
		ps.setString(1, banker.getCustName());
		ps.setInt(2, banker.getCustAge());
		ps.setString(3, banker.getCustAddress());
		ps.setString(4, banker.getCssnid());		
			
		rowstatus = ps.executeUpdate(); 
		System.out.println(rowstatus);
		/*query = "Select MAX(Customer_ID) from CustomerAccount_RBM";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) 
		{
			customerId = (Integer)rs.getInt(1);
			System.out.println("Customer Id :" +customerId);
		}
		//banker.setCid(customerId.toString());*/
					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return rowstatus;
}

public int deleteCustomer(Banker banker) {
	int rowstatus = 0;
	String query = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement(" Update CustomerAccount_RBM SET Status='Inactive', Message='Customer deleted successfully', Last_updated=CURRENT_TIMESTAMP where SSN_ID=?  ");
		ps.setString(1, banker.getCssnid());		
			
		rowstatus = ps.executeUpdate(); 
		System.out.println(rowstatus);
		/*query = "Select MAX(Customer_ID) from CustomerAccount_RBM";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) 
		{
			customerId = (Integer)rs.getInt(1);
			System.out.println("Customer Id :" +customerId);
		}
		//banker.setCid(customerId.toString());*/
					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return rowstatus;
}

public Integer createAcc(Banker banker) {
	Integer accid = null;
	int rowstatus = 0;
	String query = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Update CustomerAccount_RBM SET Status='Active',Account_ID=accseq.nextval,Account_Type=?,Balance=?,Acc_Status='Active', Message='Account created successfully', Last_updated=CURRENT_TIMESTAMP where Customer_ID=?");
		ps.setString(1, banker.getAcctype());
		ps.setInt(2, banker.getBalance());
		ps.setString(3, banker.getCid());
						
		rowstatus = ps.executeUpdate(); 
		System.out.println(rowstatus);
		query = "Select MAX(Account_ID) from CustomerAccount_RBM";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) 
		{
			accid =rs.getInt(1);
			//banker.setCid(customerId.toString());
			System.out.println("Account :" +accid);
		}
							
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return accid;		
}

public Banker searchAccountByAid(String accid) {
	
	Banker banker = new Banker();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	//Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Select *from CustomerAccount_RBM where Account_ID=? ");
		ps.setString(1, accid);
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			banker.setCid(rs.getString(1));
			banker.setCssnid(rs.getString(2));
			banker.setCustName(rs.getString(3));
			banker.setAccid(rs.getString(8));
			banker.setAcctype(rs.getString(9));
			banker.setBalance(rs.getInt(13));
		}
		System.out.println(banker.getAccid());
						
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return banker;		
}

public Banker searchAccountBySid(String sid) {
	
	Banker banker = new Banker();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	//Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Select *from CustomerAccount_RBM where SSN_Id=?");
		ps.setString(1, sid);
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			banker.setCid(rs.getString(1));
			banker.setCssnid(rs.getString(2));
			banker.setCustName(rs.getString(3));
			banker.setAccid(rs.getString(8));
			banker.setAcctype(rs.getString(9));
			banker.setBalance(rs.getInt(13));
		}
		System.out.println(banker.getAccid());				
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return banker;		
}


public Banker searchAccountByCid(String cid) {
	Banker banker = new Banker();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	//Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Select *from CustomerAccount_RBM where SSN_Id=?");
		ps.setString(1, cid);
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			banker.setCid(rs.getString(1));
			banker.setCssnid(rs.getString(2));
			banker.setCustName(rs.getString(3));
			banker.setAccid(rs.getString(8));
			banker.setAcctype(rs.getString(9));
			banker.setBalance(rs.getInt(13));
		}
						
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return banker;		
}

public int deleteAccount(Banker banker) { 
	int rowstatus = 0;
	String query = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement(" Update CustomerAccount_RBM SET Account_ID='0',Status='Active', Message='Account deleted successfully',Acc_Status='Inactive',Balance='0' Last_updated=CURRENT_TIMESTAMP where SSN_ID=?  ");
		ps.setString(1, banker.getCssnid());		
		rowstatus = ps.executeUpdate(); 
		System.out.println(rowstatus);
		/*query = "Select MAX(Customer_ID) from CustomerAccount_RBM";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) 
		{
			customerId = (Integer)rs.getInt(1);
			System.out.println("Customer Id :" +customerId);
		}
		//banker.setCid(customerId.toString());*/
					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return rowstatus;
}

public int depositAmount(Banker banker) {
	
	int rowstatus = 0;
	String query = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement(" Update CustomerAccount_RBM SET  Status='Active',Message='Account updated successfully',Acc_Status='Active',Balance=?, Last_updated=CURRENT_TIMESTAMP where SSN_ID=?  ");
		ps.setInt(1, banker.getBalance());
		ps.setString(2, banker.getCssnid());		
			
		rowstatus = ps.executeUpdate(); 
		System.out.println(rowstatus);
		/*query = "Select MAX(Customer_ID) from CustomerAccount_RBM";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) 
		{
			customerId = (Integer)rs.getInt(1);
			System.out.println("Customer Id :" +customerId);
		}
		//banker.setCid(customerId.toString());*/
					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return rowstatus;
	
}
public int withdrawAmount(Banker banker) {
	
	int rowstatus = 0;
	String query = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement(" Update CustomerAccount_RBM SET  Message='Account updated successfully',Acc_Status='Active',Balance=?,  Last_updated=CURRENT_TIMESTAMP where SSN_ID=?  ");
		ps.setInt(1, banker.getBalance());
		ps.setString(2, banker.getCssnid());		
			
		rowstatus = ps.executeUpdate(); 
		System.out.println(rowstatus);
		/*query = "Select MAX(Customer_ID) from CustomerAccount_RBM";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()) 
		{
			customerId = (Integer)rs.getInt(1);
			System.out.println("Customer Id :" +customerId);
		}
		//banker.setCid(customerId.toString());*/
					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
	return rowstatus;
	
}

public ArrayList<Banker> viewCstatus() {

	ArrayList<Banker> blist = new ArrayList<Banker>();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	//Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Select *from CustomerAccount_RBM ");
		
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			Banker banker = new Banker();
			banker.setCid(rs.getString(1));
			banker.setCssnid(rs.getString(2));
			banker.setCustName(rs.getString(3));
			banker.setStatus(rs.getString(10));
			banker.setMessage(rs.getString(11));
			banker.setLastupd(rs.getString(14));
			//banker.setAccid(rs.getInt(8));
			//banker.setAcctype(rs.getString(9));
			//banker.setBalance(rs.getInt(14));
			blist.add(banker);
		}
						
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
			
	return blist;
}

public ArrayList<Banker> viewAstatus() {
	
	ArrayList<Banker> blist = new ArrayList<Banker>();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	//Statement stmt = null;		
	
	try {		
		con = DatabaseUtil.getConnection();
		ps=con.prepareStatement("Select *from CustomerAccount_RBM ");
		
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			Banker banker = new Banker();
			banker.setCid(rs.getString(1));
			banker.setCssnid(rs.getString(2));
			banker.setAccid(rs.getString(8));
			banker.setAcctype(rs.getString(9));
			banker.setMessage(rs.getString(11));
			banker.setAccstatus(rs.getString(12));
			banker.setLastupd(rs.getString(14));
			
			
			//banker.setAccid(rs.getInt(8));
			//banker.setAcctype(rs.getString(9));
			//banker.setBalance(rs.getInt(14));
			blist.add(banker);
		}
						
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			}
		catch (SQLException e) {
			}
	}
			
	return blist;
}





public boolean transferAmount(String id,String sourceAccount,String targetAccount,int amountTransfer) throws SQLException {
	//Banker banker = new Banker();
	
	Connection con = null;
	con = DatabaseUtil.getConnection();
	int var=0;
	int var2=0;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	ResultSet rs1 =  null;
	ResultSet rs2 =  null;
	ResultSet rs3 =  null;
	ResultSet rs4 =  null;
	boolean flag=false;

	con = DatabaseUtil.getConnection();
	
	//Account account=new Account();
	ps1=con.prepareStatement("select Balance from CustomerAccount_RBM where SSN_ID=? and Account_Type=?");
	ps1.setInt(1,Integer.parseInt(id));
	ps1.setString(2,targetAccount);
	rs1=ps1.executeQuery();
	
	while (rs1.next()) {
	      var = rs1.getInt(1);
	      
	      if (rs1.wasNull()) {
	        System.out.println("id is null");
	      }
	}
	
	int targetAmount=var+amountTransfer;
	System.out.println("target amount "+targetAmount);
	//System.out.println("very good");
	ps2=con.prepareStatement("select Balance from CustomerAccount_RBM where SSN_ID=? and Account_Type=?");
	ps2.setInt(1,Integer.parseInt(id));
	ps2.setString(2,sourceAccount);
	rs2=ps2.executeQuery();
	
	while (rs2.next()) {
	      var2 = rs2.getInt(1);
	      //System.out.println("id=" + var);
	      if (rs2.wasNull()) {
	        System.out.println("name is null");
	      }
	}
	
	int sourceAmount=var2-amountTransfer;
	System.out.println("source amount"+ sourceAmount);
	if(sourceAmount<0 ) {
		System.out.println("Unable to tranfer");
	}else {
		flag=true;
		ps3=con.prepareStatement("update CustomerAccount_RBM set Balance=? where Account_Type=?");
		ps3.setInt(1,sourceAmount);
		ps3.setString(2,sourceAccount);
		//System.out.println("hey");
		rs3=ps3.executeQuery();
		
		ps4=con.prepareStatement("update CustomerAccount_RBM set Balance=? where Account_Type=?");
		ps4.setInt(1,targetAmount);
		ps4.setString(2,targetAccount);
		rs4=ps4.executeQuery();
		//System.out.println("Transfer Dao1");
	}
	DatabaseUtil.closeConnection(con);
	DatabaseUtil.closeStatement(ps1);
	DatabaseUtil.closeStatement(ps2);
	DatabaseUtil.closeStatement(ps3);
	DatabaseUtil.closeStatement(ps4);
	return flag;
}


}
