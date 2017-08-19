package gvp.cse.team1;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gvp.cse.team1.common.DatabaseConnector;
import gvp.cse.team1.common.TableConstants;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");   
		
		try
		{  
			Connection  con= new DatabaseConnector().createDatabaseConnection();			
			PreparedStatement ps=con.prepareStatement(  
			"insert into "+TableConstants.USER_TABLE+" values(?,?,?,?,?)");  
			
			ps.setString(1,username); 
			ps.setString(2, name);
			ps.setString(3,password);   
			ps.setString(4,phone);
			ps.setString(5,email);
			          
			int i=ps.executeUpdate();  
			if(i>0)
			{
				response.sendRedirect("Login.html");
				//out.print("You are successfully registered...");
			}         
		}
		catch (Exception e2)
		{
			out.println(e2);
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
