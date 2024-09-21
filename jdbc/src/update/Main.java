package update;


 


import java.io.IOException;

// Java Program to Update contents in a table

 

import java.sql.*;

import com.htc.dao.EmployeeDAO;
import com.htc.dao.EmployeeDAOImpl;
public class Main {

 

    public static void main(String[] args) throws IOException, SQLException
    {
    	
      searchI empdao = new impl ();
		
		empdao.updatedb();
    }
    }
