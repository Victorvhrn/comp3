package mapeadores;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import interfaces.Connector;

public abstract class AbstractMapper<T> {
	
	protected Connection connection;
	
	
	public AbstractMapper() throws SQLException{
		connection = Connector.getConnection();
	}
	
	
	public abstract void insert(T elemento) throws SQLException;
	
	public abstract Collection<T> select(String query,Collection<Object> params);
	
	public abstract void update(T elemento);
	
	public abstract void delete(T elemento);
	
	public void close() throws SQLException{
		connection.close();
	}
	

}
