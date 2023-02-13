package gym.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gym.bo.Member_bo;
import gym.dao.Gym_dao;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String  email=request.getParameter("email");
		String  phone=request.getParameter("phone");
		String doj=request.getParameter("doj");
		String dob=request.getParameter("dob");
		
	//	pw.print(name+" "+email+" "+phone+" "+doj+" "+dob);
		Member_bo mb=new Member_bo(name,email,phone,doj,dob);
		
		int status=Gym_dao.AddMember(mb);
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
			
		//	pw.print("Your data has been succefully added");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("AddMember.html");
			rd.include(request, response);
			//pw.print("Something went wrong");
		}
	}

}
