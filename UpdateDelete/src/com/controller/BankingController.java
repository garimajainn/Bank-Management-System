package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Banker;
import com.dao.BankerDao;
import com.service.BankingService;

/**
 * Servlet implementation class BankingController
 */
@WebServlet("/BankingController")
public class BankingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankingService service = new BankingService();
		Banker banker = new Banker();
		String source = request.getParameter("source");
		
		if(source.equals("cstatus"))
		{
			try {
				ArrayList<Banker> blist = service.viewCstatus();
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/custStatus.jsp");
				request.setAttribute("list", blist);
				rd.forward(request, response);	
			}							
			 catch (Exception e) {
				e.printStackTrace();
				}	
		}
		
		else if(source.equals("astatus"))
		{
			try {
				ArrayList<Banker> blist = service.viewAstatus();
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/accStatus.jsp");
				request.setAttribute("list", blist);
				rd.forward(request, response);	
			}							
			 catch (Exception e) {
				e.printStackTrace();
				}	
		}
		else if(source.equals("logout")) 
		{
			HttpSession session = request.getSession();
			session.getAttribute("uname");
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		}
		
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banker banker  = new Banker();
		BankingService service = new BankingService();
		String source = request.getParameter("source");
		if(source.equals("login")) 
		{		
			String uname = request.getParameter("username");
			String pw =request.getParameter("password");
			
			banker.setUsername(uname);
			banker.setPassword(pw);
			
			boolean userFound = service.getBankingService(banker);
			if(userFound==true) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
				request.setAttribute("uname", uname);
				PrintWriter out = response.getWriter();
				out.println("<font color=green>Success</font>");
				rd.forward(request, response);
			}
			else 
			{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
				PrintWriter out = response.getWriter();
				
				out.println("<font color=red>Invalid Credentials...Please check your Username or Password</font>");
				rd.include(request, response);
				
			}
			
		}
		else if(source.equals("createCust")) 
		{
			HttpSession session = request.getSession();
			session.getAttribute("uname");
			String cssnid = request.getParameter("ssnid");
			String cname = request.getParameter("custname");
			String age = request.getParameter("age");
			String add = request.getParameter("address");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			
			banker.setCssnid(cssnid);
			banker.setCustName(cname);
			banker.setCustAge(Integer.parseInt(age));
			banker.setCustAddress(add);
			banker.setState(state);
			banker.setCity(city);
			banker.setStatus("Active");
			banker.setMessage("Customer created successfully");
			try {
				Integer customerId = service.insertCustomerService(banker);
				if (customerId != null) {
					request.setAttribute("customerId", customerId);
					System.out.println("Customer Created :"+customerId);
					//banker.setCid(customerId.toString());
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/createCust.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*else
			{
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Customer Creation Failed !!! ....Try Again </font>");
			}*/
		}
		
		else if(source.equals("searchCust")) 
		{
			String vssnid = request.getParameter("vssnid");
			String vcid = request.getParameter("vcid");
						
			if(vssnid != null) {			
				
					banker.setCssnid(vssnid);
					banker = service.viewCustomerServiceSid(vssnid);
					//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewCust.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				//}			
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			}
			else if(vcid != null)
			{				
				banker.setCid(vcid);
				banker = service.viewCustomerServiceCid(vcid);
				//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewCust.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				//	}
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			}
		}
		else if(source.equals("searchCustupd")) 
		{
			String vssnid = request.getParameter("vssnid");
			String vcid = request.getParameter("vcid");
						
			if(vssnid != null) {			
				
					banker.setCssnid(vssnid);
					banker = service.viewCustomerServiceSid(vssnid);
					//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateCust.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				//}			
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			}
			else if(vcid != null)
			{				
				banker.setCid(vcid);
				banker = service.viewCustomerServiceCid(vcid);
				//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateCust.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				//	}
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			}
		}
		else if(source.equals("searchCustdel")) 
		{
			String vssnid = request.getParameter("vssnid");
			String vcid = request.getParameter("vcid");
						
			if(vssnid != null) {			
				
					banker.setCssnid(vssnid);
					banker = service.viewCustomerServiceSid(vssnid);
					//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteCust.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				//}			
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			}
			else if(vcid != null)
			{				
				banker.setCid(vcid);
				banker = service.viewCustomerServiceCid(vcid);
				//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewCust.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				//	}
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			}
		}
		
		else if(source.equals("updateCust")) 
		{
			String cssnid = request.getParameter("ssnid");
			String cid = request.getParameter("cid");
			String cname = request.getParameter("custname");
			String age = request.getParameter("age");
			String add = request.getParameter("address");
			///String state = request.getParameter("state");
			//String city = request.getParameter("city");
			
			banker.setCssnid(cssnid);
			banker.setCid(cid);
			banker.setCustName(cname);
			banker.setCustAge(Integer.parseInt(age));
			banker.setCustAddress(add);
			banker.setStatus("Active");
			banker.setMessage("Customer updated successfully");
			//banker.setState(state);
			//banker.setCity(city);
			//try {
				int count = service.updateCustomerService(banker);
				if (count>0) {
					/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateCust.jsp");
					request.setAttribute("cnt", count);
					//banker.setCid(customerId.toString());
					rd.forward(request, response);	*/
				
					PrintWriter out = response.getWriter();
					out.println("<font color=green>Customer Updated successfully ....</font>");
					out.println(banker.getStatus());
					out.println(banker.getLastupd());
				}
			//} catch (Exception e) {
			//	e.printStackTrace();
		//	}
			/*else
			{
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Customer Creation Failed !!! ....Try Again </font>");
			}*/
		
		}
		
		else if(source.equals("deleteCust")) 
		{
			String cssnid = request.getParameter("ssnid");
			String cid = request.getParameter("cid");
			String cname = request.getParameter("custname");
			String age = request.getParameter("age");
			String add = request.getParameter("address");
			///String state = request.getParameter("state");
			//String city = request.getParameter("city");
			
			banker.setCssnid(cssnid);
			banker.setCid(cid);
			banker.setCustName(cname);
			banker.setCustAge(Integer.parseInt(age));
			banker.setCustAddress(add);
			banker.setStatus("Inactive");
			banker.setMessage("Customer deleted successfully");
			//banker.setState(state);
			//banker.setCity(city);
			//try {
				int count = service.deleteCustomerService(banker);
				if (count>0) {
					/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteCust.jsp");
					request.setAttribute("cnt", count);
					//banker.setCid(customerId.toString());
					rd.forward(request, response);*/
					PrintWriter out = response.getWriter();
					out.println("<font color=green>Customer Deleted successfully ....</font>");
				}
			//} catch (Exception e) {
			//	e.printStackTrace();
		//	}
			/*else
			{
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Customer Creation Failed !!! ....Try Again </font>");
			}*/
		}
		
		else if(source.equals("createAcc")) 
		{
			String cid = request.getParameter("cid");
			String ssnid = request.getParameter("ssnid");
			String acctype = request.getParameter("acctype");
			int amt = Integer.parseInt(request.getParameter("amt"));
						
			banker.setCid(cid);
			banker.setCssnid(ssnid);
			banker.setAcctype(acctype);
			banker.setBalance(amt);
			
			banker.setStatus("Active");
			banker.setMessage("Customer created successfully");
			
			try {
				Integer accid = service.createAccService(banker);
				if (accid != null) {
					request.setAttribute("accid", accid);
					//banker.setCid(customerId.toString());
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/createAcc.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//try {
				/*int count = service.createAccService(banker);
				if (count>0) {
					/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/createCustomer.jsp");
					request.setAttribute("banker", banker);
					//banker.setCid(customerId.toString());
					rd.forward(request, response);	
					banker.setStatus("Active");
					banker.setMessage("Account created successfully");
					PrintWriter out = response.getWriter();
					out.println("<font color=green>Account created  ....</font>");
					out.println(banker.getStatus());
					out.println(banker.getMessage());*/
				}
		
		else if(source.equals("searchAcc")) 
		{
			String cssnid = request.getParameter("vssnid");
			String cid = request.getParameter("vcid");
			String accid = request.getParameter("accid");
				
			if(cssnid != null) {			
					banker = service.viewAccountServiceSid(cssnid);
					
					//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewAcc.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				}			
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			
			/*else if(vcid != null)
			{				
				banker.setCid(vcid);
				banker = service.viewAccountServiceCid(vcid);
				
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteAcc.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
							
			}	*/
			
			if(accid != null) {			
				banker.setAccid((accid));
				banker = service.viewAccountServiceAid((accid));
				//if(banker != null) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteAcc.jsp");
				request.setAttribute("banker", banker);
				rd.forward(request, response);
			}			
			
		
			}
		else if(source.equals("searchAccdel")) 
		{
			String cssnid = request.getParameter("vssnid");
			String cid = request.getParameter("vcid");
			String accid = request.getParameter("accid");
				
			if(cssnid != null) {			
					banker = service.viewAccountServiceSid(cssnid);
					
					//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteAcc.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				}			
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}
				
			
			/*else if(vcid != null)
			{				
				banker.setCid(vcid);
				banker = service.viewAccountServiceCid(vcid);
				
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteAcc.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
							
			}	*/
			
			else if(accid != null) {			
				//banker.setAccid(Integer.parseInt(accid));
				banker = service.viewAccountServiceAid((accid));
				//if(banker != null) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteAcc.jsp");
				request.setAttribute("banker", banker);
				rd.forward(request, response);
			}			
	}
		
		else if(source.equals("searchDeposit")) 
		{
			String cssnid = request.getParameter("vssnid");
			String cid = request.getParameter("vcid");
			String accid = request.getParameter("accid");
				
			if(cssnid != null) {			
					banker = service.viewAccountServiceSid(cssnid);
					
					//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/deposit.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				}			
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			
			/*else if(vcid != null)
			{				
				banker.setCid(vcid);
				banker = service.viewAccountServiceCid(vcid);
				
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteAcc.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
							
			}	*/
			
			if(accid != null) {			
				banker.setAccid((accid));
				banker = service.viewAccountServiceAid((accid));
				//if(banker != null) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/deposit.jsp");
				request.setAttribute("banker", banker);
				rd.forward(request, response);
			}			
			
		
			}	
		else if(source.equals("searchWithdraw")) 
		{
			String cssnid = request.getParameter("vssnid");
			String cid = request.getParameter("vcid");
			String accid = request.getParameter("accid");
				
			if(cssnid != null) {			
					banker = service.viewAccountServiceSid(cssnid);
					
					//if(banker != null) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/withdraw.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
				}			
				/*else {
					PrintWriter out = response.getWriter();
					out.println("<font color=red>Customer does not exist !!! ....Try Again </font>");
				}*/
				
			
			/*else if(vcid != null)
			{				
				banker.setCid(vcid);
				banker = service.viewAccountServiceCid(vcid);
				
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteAcc.jsp");
					request.setAttribute("banker", banker);
					rd.forward(request, response);
							
			}	*/
			
			if(accid != null) {			
				banker.setAccid((accid));
				banker = service.viewAccountServiceAid((accid));
				//if(banker != null) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/withdraw.jsp");
				request.setAttribute("banker", banker);
				rd.forward(request, response);
			}			
			
		
			}			
	
		else if(source.equals("deleteAcc")) 
		{
			String cssnid = request.getParameter("ssnid");
			String cid = request.getParameter("cid");
			String accid = request.getParameter("accid") ;
			String acctype = request.getParameter("acctype");
			String cname = request.getParameter("custname");
			String balance = request.getParameter("amt");
			
			///String state = request.getParameter("state");
			//String city = request.getParameter("city");
			
			banker.setCssnid(cssnid);
			banker.setCid(cid);
			banker.setAccid((accid));
			banker.setAcctype(acctype);
			banker.setCustName(cname);
			banker.setBalance(Integer.parseInt(balance));
			banker.setStatus("Active");
			banker.setMessage("Account deleted successfully");
			//banker.setState(state);
			//banker.setCity(city);
			//try {
				int count = service.deleteAccountService(banker);
				if (count>0) {
					/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/createCustomer.jsp");
					request.setAttribute("banker", banker);
					//banker.setCid(customerId.toString());
					rd.forward(request, response);	*/
					PrintWriter out = response.getWriter();
					out.println("<font color=green>Customer Deleted  ....</font>");
				}
			//} catch (Exception e) {
			//	e.printStackTrace();
		//	}
			/*else
			{
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Customer Creation Failed !!! ....Try Again </font>");
			}*/
		}
		else if(source.equals("deposit")) 
		{
			String cssnid = request.getParameter("ssnid");
			String cid = request.getParameter("cid");
			String accid = request.getParameter("accid") ;
			String acctype = request.getParameter("acctype");
			String balance = request.getParameter("balance");
			String amt = request.getParameter("amt");
			
			banker.setCssnid(cssnid);
			banker.setCid(cid);
			banker.setAccid((accid));
			banker.setAcctype(acctype);
			banker.setBalance((Integer.parseInt(balance))+(Integer.parseInt(amt)));
			banker.setStatus("Active");
			banker.setMessage("Deposited successfully");
			
			int count = service.depositAmtService(banker);
			if (count>0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/deposit.jsp");
				request.setAttribute("banker", banker);
				//banker.setCid(customerId.toString());
				rd.forward(request, response);	
				}
			/*else {
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Customer Deleted  ....</font>");
			}*/
		}
		else if(source.equals("withdraw")) 
		{
			String cssnid = request.getParameter("ssnid");
			String cid = request.getParameter("cid");
			String accid = request.getParameter("accid") ;
			String acctype = request.getParameter("acctype");
			String balance = request.getParameter("balance");
			String amt = request.getParameter("amt");
			
			banker.setCssnid(cssnid);
			banker.setCid(cid);
			banker.setAccid((accid));
			banker.setAcctype(acctype);
			banker.setBalance((Integer.parseInt(balance))-(Integer.parseInt(amt)));
			banker.setStatus("Active");
			banker.setMessage("Withdrawn successfully");
			System.out.println(banker.getBalance());
			int count = service.withdrawAmtService(banker);
			if (count>0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/withdraw.jsp");
				request.setAttribute("banker", banker);
				//banker.setCid(customerId.toString());
				rd.forward(request, response);	
				}
			/*else {
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Customer Deleted  ....</font>");
			}*/
		}
		else if(source.equals("transfer")) 
		{
			String cssnid = request.getParameter("ssnid");
			String cid = request.getParameter("cid");
			String accid = request.getParameter("accid") ;
			String acctype = request.getParameter("acctype");
			String balance = request.getParameter("balance");
			String amt = request.getParameter("amt");
			
			banker.setCssnid(cssnid);
			banker.setCid(cid);
			banker.setAccid((accid));
			banker.setAcctype(acctype);
			banker.setBalance((Integer.parseInt(balance))+(Integer.parseInt(amt)));
			banker.setStatus("Active");
			banker.setMessage("Deposited successfully");
			
			int count = service.depositAmtService(banker);
			if (count>0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/deposit.jsp");
				request.setAttribute("banker", banker);
				//banker.setCid(customerId.toString());
				rd.forward(request, response);	
				}
			/*else {
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Customer Deleted  ....</font>");
			}*/
		}else if(source.equals("transfer1")) {
			System.out.println("Transfer Controller");
			String id = request.getParameter("id");
			String sourceAccount = request.getParameter("source-account");
			String targetAccount = request.getParameter("target-account");
			int amountTransfer=Integer.parseInt(request.getParameter("tranfer-amt"));
			boolean flag;
			try {
				flag = service.transferAmount(id,sourceAccount,targetAccount,amountTransfer);
				System.out.println("Transfer Controller1");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Customer Detail</title>");
			out.println("</head>");
			out.println("<body>");
			if(flag) {
				out.println("Amount transfer SuccessFully");	
			}
			else {
				out.println("Transfer failed");
			}
			out.println("</body>");
			out.println("</html>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
}

			
		
			
		



