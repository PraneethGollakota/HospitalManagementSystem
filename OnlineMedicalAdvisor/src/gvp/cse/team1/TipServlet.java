package gvp.cse.team1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TipServlet
 */
public class TipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipServlet() {
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
		String str[]={"Copy your kitty: Learn to do stretching exercises when you wake up. It boosts circulation and digestion, and eases back pain.","Don’t skip breakfast. Studies show that eating a proper breakfast is one of the most positive things you can do if you are trying to lose weight. Breakfast skippers tend to gain weight. A balanced breakfast includes fresh fruit or fruit juice, a high-fibre breakfast cereal, low-fat milk or yoghurt, wholewheat toast, and a boiled egg.","Brush up on hygiene. Many people don't know how to brush their teeth properly. Improper brushing can cause as much damage to the teeth and gums as not brushing at all. Lots of people don’t brush for long enough, don’t floss and don’t see a dentist regularly. Hold your toothbrush in the same way that would hold a pencil, and brush for at least two minutes.","Neurobics for your mind. Get your brain fizzing with energy. American researchers coined the term ‘neurobics’ for tasks which activate the brain's own biochemical pathways and to bring new pathways online that can help to strengthen or preserve brain circuits.","Get what you give! Always giving and never taking? This is the short road to compassion fatigue. Give to yourself and receive from others, otherwise you’ll get to a point where you have nothing left to give. And hey, if you can’t receive from others, how can you expect them to receive from you?"};
		int i;
		Random r=new Random();
		int index = r.nextInt(str.length);
		out.println("<center>"+"<h2>"+"Tip Of The Day"+"</h2>"+"</center>");
		out.println("<br>");
		out.println("<br>");
		out.println("<center>"+str[index]+"</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
