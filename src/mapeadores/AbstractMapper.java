package mapeadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;

public abstract class AbstractMapper<T> {
	
	protected Connection connection;
	
	
	public AbstractMapper(){
	}
	
	public void open() throws SQLException{
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SQLException();
		}
		connection = DriverManager.getConnection("jdbc:h2:file:~/comp3","sa","");
	}
	
	public abstract void insert(T elemento) throws SQLException;
	
	public abstract void update(int id,T elemento) throws SQLException;
	
	public abstract void delete(T elemento);
	
	public abstract Collection<T> selectAll() throws SQLException, CPFInvalidoException,
	CPFIncompletoException, NomeNotFoundException;
	
	public abstract T selectById(int id) throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException;
	
	public abstract Collection<T> selectByCampo(String campo, String valor) throws SQLException;
	
	public void close() throws SQLException{
		connection.close();
	}
	

}
