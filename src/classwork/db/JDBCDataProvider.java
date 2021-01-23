package classwork.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

public class JDBCDataProvider {
	    private Connection connect = null;
	    private Statement statement = null;
	    private ResultSet resultSet = null;

	    @DataProvider(name="dbData")
	    public Object[][] readDataBase() throws Exception {
	    	String[][] dataArray;
	        try {
	            /* This will load the MySQL driver */
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            /* Setup the connection with the DB */
	            connect = DriverManager.getConnection("jdbc:mysql://localhost/DEMO?user=TRAINING&password=training");

	            /* Statements allow to issue SQL queries to the database */
	            statement = connect.createStatement();
	            /* Result set get the result of the SQL query */
	            resultSet = statement.executeQuery("select * from DEMO.SEARCH");
	            /* Get Number of Rows and Columns*/
	            resultSet.last(); 
	            int rows = resultSet.getRow();
	            System.out.println("No.of Rows:" + rows);
	            int cols = resultSet.getMetaData().getColumnCount();
	            System.out.println("No.of Cols:" + cols);
	            /* Declare size of return values of 2D array*/
	            dataArray = new String[rows][cols];
	            int r = 0;
	            /* Read Result Set into Double Dimension array*/
	            resultSet.beforeFirst(); 
	            while (resultSet.next()) {
	                String stxt = resultSet.getString("searchText");

	                System.out.println("SearchText: " + stxt);
	                dataArray[r][0]=stxt; 
	                r++;
	            }
	            
	    } catch (Exception e) {
	     throw e;
	    } finally {
	      close();
	    }
        /* Return Data*/
        return dataArray;
	
     }
	    
	    /* Close all DB Objects */    
        private void close() {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {

            }
        }
}

