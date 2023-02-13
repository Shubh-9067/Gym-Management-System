package gym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gym.bo.Member_bo;
import gym.bo.gym;

public class Gym_dao {

	public static Connection getConnection() 
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/GymManagement","root","shubhangi");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static int signup(gym gm) {
		int status=0;
		
		try {
			Connection con=Gym_dao.getConnection();
			
			String sql="insert into signup(name,email,phone,password)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, gm.getName());
			ps.setString(2, gm.getEmail());
			ps.setString(3, gm.getPhone());
			ps.setString(4, gm.getPass());
			
			status=ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		return status;
	}
	
	public static boolean userLogin(String email,String pass) {
		boolean status=false;
		
		try {
			Connection con=Gym_dao.getConnection();
			String sql="select * from signup where email=? And password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	
	}
	
	public static int AddMember(Member_bo mb) {
		
		int status=0;
		try {
			Connection con=Gym_dao.getConnection();
			String query="insert into addmember(name,email,phone,dob,doj) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getEmail());
			ps.setString(3, mb.getPhone());
			ps.setString(4,mb.getDob());
			ps.setString(5, mb.getDoj());
			
			status =ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	public static List getAllMember() {
		List list=new ArrayList();
		
		try {
			Connection con=Gym_dao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from addMember");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Member_bo mb=new Member_bo();
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setEmail(rs.getString(3));
				mb.setPhone(rs.getString(4));
				mb.setDob(rs.getString(5));
				mb.setDoj(rs.getString(6));
				
				list.add(mb);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static Member_bo getMemberById(int id) {
		   
			
			 Member_bo mb=new  Member_bo();
			
		
			try {
				Connection con=Gym_dao.getConnection();
				String query="select * from addmember  where id=? ";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setEmail(rs.getString(3));
				mb.setPhone(rs.getString(4));
				mb.setDoj(rs.getString(5));
				mb.setDob(rs.getString(6));
				
				
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return mb;
	}
	
	public static  int Update(Member_bo mb) {
		int status=0;
		
		try {
		Connection con=Gym_dao.getConnection();
		String query="update addmember set name=?,email=?,phone=?,dob=?,doj=? where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		
		
		ps.setString(1, mb.getName());
		ps.setString(2, mb.getEmail());
		ps.setString(3, mb.getPhone());
		ps.setString(4, mb.getDob());
		ps.setString(5, mb.getDoj());
		ps.setInt(6, mb.getId());
		
		status=ps.executeUpdate();
	
	}catch(Exception e) {
		System.out.print(e);
	}
		
		return status;
    }
	
public static int delete(int id) {
		
		int status=0;
		  try {
		
			  Connection con=Gym_dao.getConnection();
			  String query="Delete from addmember where id=?";
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setInt(1, id);
			  status=ps.executeUpdate();
			  
		} catch (Exception e) {
		
			   System.out.println(e);
		}
		
		return status;
		
	}
	
	}
