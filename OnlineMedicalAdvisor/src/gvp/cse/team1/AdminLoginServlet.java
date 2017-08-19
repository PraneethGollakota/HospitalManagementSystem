package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gvp.cse.team1.common.DatabaseConnector;
import gvp.cse.team1.common.TableConstants;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try
		{  
			Connection  con= new DatabaseConnector().createDatabaseConnection();			
			PreparedStatement ps=con.prepareStatement(  
			"select * from adminLogin where username='"+username+"' and password='"+password+"'");  
			
			          
			ResultSet rs=ps.executeQuery();  
			if(rs.next())
			{
				Cookie ck=new Cookie("user",username);
				response.addCookie(ck);
				response.sendRedirect("AdminActions.jsp");
			} 
			else
			{
				out.print("You are an invalid user...");
			}
			  
		}
		catch (Exception e2)
		{
			System.out.println(e2);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
