package course;

import java.io.IOException;
import course.DB;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add")

public class add extends HttpServlet{
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
		
		if(Name.isEmpty()==true || NIC.isEmpty()==true || Department.isEmpty()==true || Designation.isEmpty()==true || JoinedDate.isEmpty()==true)
		{
			res.sendRedirect("Interface.jsp");
			
		}

		else {
        try 
        {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeedatabase","root","");
            
            PreparedStatement ps=con.prepareStatement("INSERT INTO `employee` values(?,?,?,?,?)");
            ps.setString(1, Name);
            ps.setString(2, NIC);
            ps.setString(3, Department);
            ps.setString(4, Designation);
            ps.setString(5, JoinedDate);
            
            int i=ps.executeUpdate();
            
            if(i>0)
            {
            	
            	res.sendRedirect("Interface.jsp");
            	
            	
            }
            
        } catch (Exception e) 
        {
            System.out.println(e);
        }
		}
		
  
		
	}
  
}


