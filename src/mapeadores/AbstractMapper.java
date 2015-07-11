package mapeadores;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import interfaces.Connector;

public abstract class AbstractMapper<T> {
	
	protected Connection connection;
	protected PreparedStatement stmt;
	
	
	public AbstractMapper() throws SQLException{
		
		connection = Connector.getConnection();
		
	}
	
	
	public abstract void insert(T elemento);
	
	protected abstract String query(String query);
	
	public abstract List<T> execute(String query,List<Object> params);
	
	public abstract void update(T elem);
	
	public abstract void delete(T elem);
	
	
	public void close(){
		
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:h2:file:~/comp3",
				"sa","");
		
		connection.prepareStatement("create table teste(id int, nome varchar(255));").execute();
		
		connection.close();
	}
	

}
