package gym.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gym.bo.Member_bo;
import gym.dao.Gym_dao;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<link rel='stylesheet' href='css/edit.css'>");
		
		String id=request.getParameter("id");
		
		int mid=Integer.parseInt(id);
	      
		Member_bo mb=Gym_dao.getMemberById(mid);
		pw.print("<html>");
	
	
	pw.print("<body style='text-align:center'>");
		
		pw.print("<form action='UpdateController' method='Get'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' id='na' value='"+mb.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name: </td><td><input type='text' name='name' id='na' value='"+mb.getName()+"'/></td></tr>"); 
		pw.print("<tr><td>Email: </td><td><input type='text' name='email' id='na' value='"+mb.getEmail()+"'/></td></tr>"); 
		pw.print("<tr><td>Phone: </td><td><input type='text' name='phone' id='na' value='"+mb.getPhone()+"'/></td></tr>"); 
		pw.print("<tr><td>Birth day: </td><td><input type='text' name='dob' id='na' value='"+mb.getDob()+"'/></td></tr>"); 
		pw.print("<tr><td>Joining date: </td><td><input type='text' name='doj' id='na' value='"+mb.getDoj()+"'/></td></tr>"); 
	    
		pw.print("<tr><td><input type='submit' id='btn' value='Update'/> </td></tr>");
		
		pw.print("</table>");
		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
		
		
	    
	
	}

}
