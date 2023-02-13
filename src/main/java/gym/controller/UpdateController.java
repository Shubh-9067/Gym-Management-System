package gym.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gym.bo.Member_bo;
import gym.dao.Gym_dao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String dob=request.getParameter("dob");
		String doj=request.getParameter("doj");
		
		Member_bo mb=new Member_bo();
	   mb.setId(id);
	   mb.setName(name);  
	   mb.setEmail(email);
	   mb.setPhone(phone);
	   mb.setDob(dob);
	   mb.setDoj(doj);
		
		
			int status=Gym_dao.Update(mb);
		
			if(status>0) {
				RequestDispatcher rd=request.getRequestDispatcher("AllMembersController");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("EditServlet2");
				rd.include(request, response);
			}
		
	}

}
