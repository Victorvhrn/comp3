package mapeadores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import entidades.Departamento;
import interfaces.Connector;

public abstract class AbstractMapper<T> {
	
	protected Connection connection;
	
	
	public AbstractMapper() throws SQLException{
		connection = Connector.getConnection();
	}
		
	public abstract void insert(T elemento) throws SQLException;
	
	public abstract void update(int id,T elemento) throws SQLException;
	
	public abstract void delete(T elemento);
	
	public abstract Collection<T> selectAll() throws SQLException;
	
	public abstract Departamento selectById(int id) throws SQLException;
	
	public void close() throws SQLException{
		connection.close();
	}
	

}
