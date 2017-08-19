package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gvp.cse.team1.common.DatabaseConnector;
import gvp.cse.team1.common.TableConstants;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		out.println(username);
		String password = request.getParameter("password");
		
		
		try
		{  
			Connection  con= new DatabaseConnector().createDatabaseConnection();			
			PreparedStatement ps=con.prepareStatement(  
			"select * from "+TableConstants.USER_TABLE+" where username='"+username+"' and password='"+password+"'");  
			
			//ps.setString(1,username);
			//ps.setString(2,password);  
			          
			ResultSet rs=ps.executeQuery();  
			if(rs.next())
			{
				out.println(request.getParameter("username"));
				//out.print("You are logged in successfully...");
				Cookie ck=new Cookie("user",username);
				response.addCookie(ck);
				response.sendRedirect("SymptomsDummy.jsp");
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
