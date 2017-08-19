package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import gvp.cse.team1.common.DatabaseConnector;

/**
 * Servlet implementation class CheckAppointmentsServlet
 */
public class CheckAppointmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAppointmentsServlet() {
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
		String dateAppointment=request.getParameter("date");
		
		
		try
		{
			Connection  con= (Connection) new DatabaseConnector().createDatabaseConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from appointment where docname='"+user+"' and date='"+dateAppointment+"'");
			
			String username=null;
			String name=null;
			String age=null;
			String gender=null;
			String city=null;
			String date=null;
			String docid=null;
			String docname=null;
			String docSpec=null;
			
			ResultSet rs=(ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				out.println("<center>"+"Name:"+rs.getString(2)+"  Age:"+rs.getString(3)+"  gender:"+rs.getString(4)+"  city:"+rs.getString(5)+"</center>"+"<br>");
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
