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
@WebServlet("/Search")

public class search extends HttpServlet{
	
	PreparedStatement ps =null;
    Connection con =null;
       ResultSet rs=null;
	
	public void doPost(HttpServletRequest req ,HttpServletResponse res) throws IOException, ServletException
	{
		
		
		PrintWriter out =res.getWriter();
		res.setContentType("text/html");
		out.print("Works");
		out.print("<table border='1'><tr><th>Name</th><th>NIC</th><th>Department</th><th>Designation</th><th>JoinedDat</th></tr>");
		
		try {
         
           Class.forName("com.mysql.cj.jdbc.Driver");
           con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeedatabase","root","");
           
           PreparedStatement ps=con.prepareStatement("SELECT * FROM employee");
          
      
           rs=ps.executeQuery();
           
           while(rs.next())
           {
        	   out.print("<tr><td>");
        	   out.println(rs.getString(1));
        	   out.print("</td>");
        	   
        	   out.print("<td>");
        	   out.print(rs.getString(2));
        	   out.print("</td>");
        	   
        	   out.print("<td>");
        	   out.print(rs.getString(3));
        	   out.print("</td>");
        	   
        	   out.print("<td>");
        	   out.print(rs.getString(4));
        	   out.print("</td>");
        	   
        	   out.print("<td>");
        	   out.print(rs.getString(5));
        	   out.print("</td>");
        	   
        	   
        	   
        	   
           }
           
           
           
       } catch (Exception e) 
       {
           System.out.println(e);
       }
		}
	}


