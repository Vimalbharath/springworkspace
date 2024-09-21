package select;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.htc.dbconnect.DBConnection;
import com.htc.entity.Employee;

public class impl implements searchI {

	@Override
	public void updatedb() throws IOException, SQLException {
		// TODO Auto-generated method stub
		DBConnection dbconnect = new DBConnection();
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		 try {
	            
	            String sql = "Select * from emp ";

	  
	            pstmt = con.prepareStatement(sql);
	            
	            //int id = 100;
	            //int id1 = 1;
	            //pstmt.setInt(1, 1);
	            
	            
	           
	            List < Employee > users = new ArrayList < > ();
	            
	                       
	                       ResultSet rs = pstmt.executeQuery();
	                       while (rs.next()) {
	                           double id = rs.getDouble("empid");
	                           String name = rs.getString("Name");
	                           String email = rs.getString("address");
	                           String country = rs.getString("desig");
	                           double salary = rs.getDouble("salary");
	                           users.add(new Employee(id, name, email, country,salary));
	                           System.out.println( users);
	                       }
	                   
	        }
	        catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}

}
