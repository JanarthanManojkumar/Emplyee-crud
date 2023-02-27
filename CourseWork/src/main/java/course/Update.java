package course;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {

	PreparedStatement ps =null;
    Connection con =null;
       ResultSet rs=null;
	
	public void doPost(HttpServletRequest req ,HttpServletResponse res) throws IOException, ServletException
	{
		
		String Name=req.getParameter("Name");
		String NIC=req.getParameter("NIC");
		String Department=req.getParameter("Department");
		String Designation=req.getParameter("Designation");
		String JoinedDate=req.getParameter("DateJoined");
		
		
		

		
		
		if(NIC.isEmpty()==true)
		{
			res.sendRedirect("Interface.jsp");
			
		}

		else 
		{
       try 
       {
    	   
         
           Class.forName("com.mysql.cj.jdbc.Driver");
           con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeedatabase","root","");
           
           PreparedStatement ps=con.prepareStatement("UPDATE employee SET Name = ?, Department = ?, Designation = ?, JoinedDate = ? WHERE NIC = ?");
           ps.setString(1, Name);
           ps.setString(5, NIC);
           ps.setString(2, Department);
           ps.setString(3, Designation);
           ps.setString(4, JoinedDate);
      
           int i=ps.executeUpdate();
           
           if(i>0)
           {
           	
           	res.sendRedirect("Interface.jsp");
           	
           	
           }
           else 
           {
           	
           }
           
       } catch (Exception e) 
       {
           System.out.println(e);
       }
		}
	}
	


}
