package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gvp.cse.team1.common.DatabaseConnector;

/**
 * Servlet implementation class reportServelt
 */
public class reportServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportServelt() {
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
		Cookie ck[]=request.getCookies();
		String user=ck[0].getValue();
		
		out.println(user+"<br>");
		
		try
		{
			Connection  con= new DatabaseConnector().createDatabaseConnection();
			PreparedStatement ps=con.prepareStatement("select * from report where username='"+user+"'");
			
			
			ResultSet rs=ps.executeQuery();
			out.println("<center>"+"The disease report of the "+user+" till now is:"+"<br>"+"</center>");
			out.println("<br>");
			out.println("<br>");
			int iter=0;
			while(rs.next())
			{
				iter++;
				out.print("<center>"+"Your Prescription - "+iter+" is "+rs.getString(2)+"<br>"+"</center>");
			}
			
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
