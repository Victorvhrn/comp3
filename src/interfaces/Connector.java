package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	private static Connection connector;
	
	public static Connection getConnection() throws SQLException{
		
		if(connector == null){
			
		   return  DriverManager.getConnection(
						"jdbc:h2:file:~/comp3",
						"sa","");
			
		}else{
			return connector;
		}
		
	}
	
	public void close(){
		
		try {
			connector.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
