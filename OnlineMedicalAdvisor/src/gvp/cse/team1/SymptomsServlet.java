package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gvp.cse.team1.common.DatabaseConnector;


/**
 * Servlet implementation class SymptomsServlet
 */
@WebServlet("/symptoms")
public class SymptomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SymptomsServlet() {
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
		out.println("<header class=\"main-header\" role=\"banner\">");
		  out.println("<img src=\"images/6.jpg\" width=\"1400px\" height=\"200px\" alt=\"Banner Image\"/>");
		out.println("</header>");
		
		String abdomnalpain=request.getParameter("abdomnal pain");
		String bloodinstool=request.getParameter("blood in stool");
		String breathshortness=request.getParameter("breath shortness");
		String chestpain=request.getParameter("chest pain");
		String chills=request.getParameter("chills");
		String cold=request.getParameter("cold");
		String cough=request.getParameter("cough");
		String diarrhoea=request.getParameter("diarrhoea");
		String depression=request.getParameter("depression");
		String fastheartrate=request.getParameter("fast heart rate");
		String fever=request.getParameter("fever");
		String headache=request.getParameter("headache");
		String hyperactive=request.getParameter("hyper active");
		String infection=request.getParameter("infection");
		String itching=request.getParameter("itching");
		String mouthinfection=request.getParameter("mouth infection");
		String pain=request.getParameter("pain");
		String painbehindeyes=request.getParameter("pain behind eyes");
		String rash=request.getParameter("rash");
		String throatirritation=request.getParameter("throat irritation");
		String toileturgency=request.getParameter("toilet urgency");
		String urinaryproblem=request.getParameter("urinary problem");
		String visionproblem=request.getParameter("visionproblem");
		String vomitings=request.getParameter("vomitings");
		String yelloweyes=request.getParameter("yellow eyes");
		
		if(abdomnalpain==null)
			abdomnalpain="null";
		if(bloodinstool==null)
			bloodinstool="null";
		if(breathshortness==null)
			breathshortness="null";
		if(chestpain==null)
			chestpain="null";
		if(chills==null)
			chills="null";
		if(cold==null)
			cold="null";
		if(cough==null)
			cough="null";
		if(diarrhoea==null)
			diarrhoea="null";
		if(depression==null)
			depression="null";
		if(fastheartrate==null)
			fastheartrate="null";
		if(fever==null)
			fever="null";
		if(headache==null)
			headache="null";
		if(hyperactive==null)
			hyperactive="null";
		if(infection==null)
			infection="null";
		if(itching==null)
			itching="null";
		if(mouthinfection==null)
			mouthinfection="null";
		if(pain==null)
			pain="null";
		if(painbehindeyes==null)
			painbehindeyes="null";
		if(rash==null)
			rash="null";
		if(throatirritation==null)
			throatirritation="null";
		if(toileturgency==null)
			toileturgency="null";
		if(urinaryproblem==null)
			urinaryproblem="null";
		if(visionproblem==null)
			visionproblem="null";
		if(vomitings==null)
			vomitings="null";
		if(yelloweyes==null)
			yelloweyes="null";
		
		//out.println(cold);
		//out.println(yelloweyes);
		
		try
		{
			Connection  con= new DatabaseConnector().createDatabaseConnection();
			Statement st =con.createStatement();
			String sql = "select disid,disname from disease where "
					+ "abdomnalpain='"+abdomnalpain+"' and bloodinstool='"+bloodinstool+"' and breathshortness='"+breathshortness+"'"
					+ "and chestpain='"+chestpain+"' and chills='"+chills+"'"
					+ "and cold='"+cold+"' and cough='"+cough+"' and diarrhoea='"+diarrhoea+"' and depression='"+depression+"'"
					+ "and fastheartrate='"+fastheartrate+"' and fever='"+fever+"' and headache='"+headache+"'"
					+ "and hyperactive='"+hyperactive+"' and infection='"+infection+"' and itching='"+itching+"'"
					+ "and mouthinfection='"+mouthinfection+"' and pain='"+pain+"' and painbehindeyes='"+painbehindeyes+"'"
					+ "and rash='"+rash+"' and throatirritation='"+throatirritation+"' and toileturgency='"+toileturgency+"' "
					+ "and urinaryproblem='"+urinaryproblem+"' and visionproblem='"+visionproblem+"'"
					+ "and vomitings='"+vomitings+"' and yelloweyes='"+yelloweyes+"'";
			ResultSet rs =st.executeQuery(sql);
			
			Cookie ck[]=request.getCookies();
			String username=ck[0].getValue();
			
			
			
			out.println(username+"<br>");
			String diseaseName=null;
			String test[]=new String[10];
			String diseaseId=null;
			int iterator=0;
			
			//ResultSet rs=ps.executeQuery();
			//out.println(rs.getString(2));
			if(rs.next())
			{
				diseaseName=rs.getString(2);
				diseaseId=rs.getString(1);
				out.println("<center>"+"Expected Disease Name:"+diseaseName+"<br>"+"</center>");
				iterator++;
			}
			else
			{
				out.println("<center>"+"You should consult a doctor for better prescription"+"<br>"+"</center>");
				out.println("<center>"+"(or)"+"<br>"+"</center>");
			//	out.println("<center>"+"We will notify to your authorized email with the Prescription from a doctor soon."+"<br>"+"</center>");
			}
			
			PreparedStatement ps3=con.prepareStatement("select testname from tests where testid in"
					+ "(select testid from testreport where disid='"+diseaseId+"')");
			ResultSet rs3=ps3.executeQuery();
			out.println("<center>"+"The suggested test by the doctor before appointment are:"+"<br>"+"</center>");
			while(rs3.next())
			{
				out.println("<center>"+rs3.getString(1)+"<br>"+"</center>");
			}
			
//			PreparedStatement ps1=con.prepareStatement("select mediname from medicines where medid in "
//					+ "(select medid from prescription where disid='"+diseaseId+"')");
//			ResultSet rs1=ps1.executeQuery();
//			String medicineName;
//			if(diseaseName!=null)
//			{
//				out.println("<center>"+"The suggested medicines for your disease are:"+"<br>"+"</center>");
//				while(rs1.next())
//				{
//					out.println("<center>"+rs1.getString(1)+","+"<br>"+"</center>");
//				}
//			}
			
			PreparedStatement ps2=con.prepareStatement("insert into report values (?,?)");
			ps2.setString(1, username);
			ps2.setString(2, diseaseName);
			
			
			
			int rs2=ps2.executeUpdate();
			
			
			Cookie ck1=new Cookie("diseaseId",diseaseId);
			response.addCookie(ck1);
			
//			int doctorId=0;
//			PreparedStatement ps4=con.prepareStatement("select docid,docname,docSpec "
//					+ "from doctor where disid='"+diseaseId+"'");
//			
//			ResultSet rs4=ps4.executeQuery();
//			out.println("<center>"+"Our appointment is scheduled 2 days from now"+"<br>"+"</center>");
//			if(rs4.next())
//			{
//				doctorId=rs4.getInt(1);
//				out.println("<center>"+"Our Doctor's name is: "+rs4.getString(2)+" with Specialization in "+rs4.getString(3)+"<br>"+"</center>");
//			}
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("<br>");
		out.println("<br>");
		out.println("<center>"+"<a href=\"RegisterAppointment.jsp\">Click Here</a>"+" for Doctor's Appointment"+"</center>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
