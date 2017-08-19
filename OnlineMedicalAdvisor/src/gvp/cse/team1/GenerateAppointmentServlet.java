package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.DriverManager;

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
 * Servlet implementation class GenerateAppointmentServlet
 */
public class GenerateAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateAppointmentServlet() {
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
		out.println("<header class=\"main-header\" role=\"banner\">");
		  out.println("<img src=\"images/6.jpg\" width=\"1400px\" height=\"200px\" alt=\"Banner Image\"/>");
		out.println("</header>");
		
		
		Cookie ck[]=request.getCookies();
		String diseaseId=ck[2].getValue();
		try
		{
			Connection  con= (Connection) new DatabaseConnector().createDatabaseConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from appointment where docid=(select docid from doctor where disid='"+diseaseId+"')");
			
			String username=null;
			String name=null;
			String age=null;
			String gender=null;
			String city=null;
			String date=null;
			String docid=null;
			String docname=null;
			String docSpec=null;
			//Blob image=null;
			
			ResultSet rs=(ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				username=rs.getString(1);
				name=rs.getString(2);
				age=rs.getString(3);
				gender=rs.getString(4);
				city=rs.getString(5);
				date=rs.getString(6);
				docid=rs.getString(7);
				docname=rs.getString(8);
				docSpec=rs.getString(9);
				//image=rs.getBlob(10);
			}
			out.print("<br>");
			out.print("<br>");
			out.print("<br>");
			out.println("<center>");
			out.println("<div class=\"container\">");
			//out.println(image);
			out.println("Name:"+name+"<br>");
			out.print("<br>");
			out.println("Age:"+age+"<br>");
			out.print("<br>");
			out.println("Gender:"+gender+"<br>");
			out.print("<br>");
			out.println("Appointment Date:"+date+"<br>");
			out.print("<br>");
			out.println("DoctorName:"+docname+"<br>");
			out.print("<br>");
			out.println("DoctorSpecialization:"+docSpec+"<br>");
			out.print("<br>");
//			out.print("<center>"+"Name:"+name+"</center>"+"<br>");
//			out.print("<center>"+"Age:"+age+"</center>"+"<br>");
//			out.print("<center>"+"Gender:"+gender+"</center>"+"<br>");
//			out.println("<center>"+"Appointment Date:"+date+"</center>"+"<br>");
//			out.print("<center>"+"DoctorName:"+docname+"</center>"+"<br>");
//			out.print("<center>"+"DoctorSpecialization:"+docSpec+"</center>"+"<br>");
			out.println("</div>");out.println("</center>");
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
