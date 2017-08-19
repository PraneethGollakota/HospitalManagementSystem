package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import gvp.cse.team1.common.DatabaseConnector;

/**
 * Servlet implementation class AddDoctorServlet
 */
public class AddDoctorServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String docid=request.getParameter("id");
		String docname=request.getParameter("username");
		String password=request.getParameter("password");
		String docspec=request.getParameter("docspec");
		
		try
		{
			Connection  con= new DatabaseConnector().createDatabaseConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into doclogin values (?,?,?,?)");
			
			ps.setString(1,docid);
			ps.setString(2, docname);
			ps.setString(3, password);
			ps.setString(4, docspec);
			
			int x=ps.executeUpdate();
			if(x>0)
				out.println("Doctor data is successfully updated."+"<br>");

		}
		catch(Exception e)
		{
			out.println(e);
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
