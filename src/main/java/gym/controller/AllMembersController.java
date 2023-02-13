package gym.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gym.bo.Member_bo;
import gym.dao.Gym_dao;

/**
 * Servlet implementation class AllMembersController
 */
@WebServlet("/AllMembersController")
public class AllMembersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public AllMembersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		  pw.print("<link rel='stylesheet' href='css/table.css'>");
		   
		   pw.print("<a href='home.html'>Back</a>");
		   
		   pw.print("<table border='1px' width='100%' table-color:'pink'> ");
		    
		    pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Date Of Joining</th><th> Date Of Birth</th><th>Actions</th><th>Delete</th></tr>");
		
		  List<Member_bo> list= Gym_dao.getAllMember();
		   
		  for(Member_bo mb:list) {
			  
			   pw.print("<tr><td>"+mb.getId()+"</td><td>"+mb.getName()+"</td><td>"+mb.getEmail()+"</td><td>"+mb.getPhone()+"</td><td>"+mb.getDoj()+"</td><td>"+mb.getDob()+"</td><td>"+"<a href='EditServlet2?id="+mb.getId()+"'>edit</a></td><td>"
			   		+ "<a href='DeleteServlet?id="+mb.getId()+" '>delete</a></td></tr>"); 
			  
		  }
		   
		  pw.print("</table>");
	}

		
	}


