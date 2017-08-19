package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import gvp.cse.team1.common.DatabaseConnector;

/**
 * Servlet implementation class AppointmentServlet
 */
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
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
		String username=ck[0].getValue();
		//Cookie ck1[]=request.getCookies();
		String diseaseId=ck[2].getValue();		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String date=request.getParameter("date");
		
		try
		{
			Connection  con= new DatabaseConnector().createDatabaseConnection();
			Statement st =con.createStatement();
			
			String sql="select disname from disease"
					+ " where disid='"+diseaseId+"'";
			ResultSet rs =(ResultSet) st.executeQuery(sql);
			String diseaseName=null;
			while(rs.next())
			{
				diseaseName=rs.getString(1);
			}
			//out.print(diseaseName+"<br>");
			
			Statement st1 =con.createStatement();
			
			String sql1="select docid,docname,docSpec from "
					+ "doctor where disid='"+diseaseId+"'";
			ResultSet rs1=(ResultSet) st1.executeQuery(sql1);
			int doctorId=0;
			String doctorName=null;
			String doctorSpec=null;
			
			while(rs1.next())
			{
				doctorId=rs1.getInt(1);
				doctorName=rs1.getString(2);
				doctorSpec=rs1.getString(3);
			}
			
			
			Statement st2 =con.createStatement();
			PreparedStatement ps2=(PreparedStatement) con.prepareStatement("insert into appointment values (?,?,?,?,?,?,?,?,?)");
			ps2.setString(1, username);
			ps2.setString(2,name);
			ps2.setString(3, age);
			ps2.setString(4, gender);
			ps2.setString(5,city);
			ps2.setString(6, date);
			ps2.setInt(7,doctorId);
			ps2.setString(8, doctorName);
			ps2.setString(9, doctorSpec);
			
			int rs2=ps2.executeUpdate();
			
			if(rs2>0)
			{
				out.println("<center>"+"Congrats your appointment is booked."+"<br>"+"</center>");
				out.println("<form action=\"generateAppointment\" method=\"post\">");
				out.println("<center>"+"<input type=\"submit\" value=\"Generate report\">"+"</center>");
				out.println("</form>");
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
