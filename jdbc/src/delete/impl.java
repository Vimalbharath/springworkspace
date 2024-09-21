package delete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.htc.dbconnect.DBConnection;

public class impl implements searchI {

	@Override
	public void updatedb() throws IOException, SQLException {
		// TODO Auto-generated method stub
		DBConnection dbconnect = new DBConnection();
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = null;
		 try {
	            
	            String sql = "delete from emp WHERE empId = ?";

	  
	            pstmt = con.prepareStatement(sql);
	            
	            //int id = 100;
	            //int id1 = 1;
	            pstmt.setInt(1, 3);
	            
	            
	      
	            
	            
	                       
	                       int rowAffected = pstmt.executeUpdate();
	                       System.out.println(String.format("Row affected %d", rowAffected));
	                       
	        }
	        catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}

}
