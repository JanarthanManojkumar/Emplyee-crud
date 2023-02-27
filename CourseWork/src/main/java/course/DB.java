package course;
import java.sql.Connection;
import java.sql.*;

public class DB {
    
    public static Connection mycon()
    {
      Connection con=null;
        
        try 
        {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");
            
            
        } catch (Exception e) 
        {
            System.out.println(e);
        }
        return con;
        
    }
    
}
