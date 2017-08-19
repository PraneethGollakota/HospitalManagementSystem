package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import gvp.cse.team1.common.DatabaseConnector;

/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
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
		String username=request.getParameter("username");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		try
		{
			Connection  con= new DatabaseConnector().createDatabaseConnection();
			Statement st =con.createStatement();
			String sql ="select password from userdata where "
					+ "username='"+username+"' and phone='"+phone+"'"
							+ "and email='"+email+"'";
			//PreparedStatement ps=(PreparedStatement) con.prepareStatement("select password from userdata where"
				//	+ "username=? and phone=?"
					//		+ "and email=?");
			//ps.setString(1, username);
			//ps.setString(2, phone);
			//ps.setString(3, email);
			//ResultSet rs=(ResultSet) ps.executeQuery();
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			if(rs.next())
			{
				out.println("Your password is "+rs.getString(1)+"<br>");
			}
			else
			{
				out.println("Your credentials haven't matched"+"<br>");
				out.println("<a href=\"ForgotPassword.html\">Clickhere</a>");
				//response.sendRedirect("ForgotPassword.html");
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
