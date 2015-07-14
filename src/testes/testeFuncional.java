package testes;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.DatabaseTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.*;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import entidades.Departamento;
import roteiros.criacao.RoteiroCriarDepartamento;

public class testeFuncional extends DBTestCase{
	
	private static Connection conn;
	private FlatXmlDataSet bancoCarregado;

	@Before
	public void setUp() throws Exception {
		 System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:file:~/comp3" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
	}
	
	

	/*@Test
	public void test() {
		//Departamento departamento = new Departamento(10, "Departamento de computacao", "dcc");
		RoteiroCriarDepartamento rcd = new RoteiroCriarDepartamento();
		rcd.execute("Departamento de computacao", "DCC");	
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select count(*) from departamento where sigla = 'DCC'");
		assertEquals(1, Integer.parseInt(rs.));
		stmt.executeUpdate("delete from departamento");
	}
	
	
	public void testRegistroBanco() throws Exception{
		IDataSet dadosSetBanco = getConnection().createDataSet();
		ITable dadosNoBanco = dadosSetBanco.getTable("departamento");
		
		IDataSet dadosSetEsperado = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/dataset2.xml"));
		ITable dadosEsperados = dadosSetEsperado.getTable("departamento");
		
		Assertion.assertEquals(dadosEsperados, dadosNoBanco);
	}
	
	
	public void testRegistroBanco() throws Exception{
		IDataSet dadosSetBanco = getConnection().createDataSet();
		ITable dadosNoBanco = dadosSetBanco.getTable("departamento");
		
		IDataSet dadosSetEsperado = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/dataset.xml"));
		ITable dadosEsperados = dadosSetEsperado.getTable("departamento");
		
		Assertion.assertEquals(dadosEsperados, dadosNoBanco);
	}
	*/
	public void testQuantidadeRegistroTabela() throws Exception{
		IDataSet dadosSetBanco = getConnection().createDataSet();
		int rowCount = dadosSetBanco.getTable("departamento").getRowCount();
		
		assertEquals(1, rowCount);
	}

	
	
	protected DatabaseOperation getSetUpOperation() throws Exception{
		return DatabaseOperation.REFRESH;		
	}
	
	//depois da operação
	protected DatabaseOperation getTearDownOperation() throws Exception{
		//return DatabaseOperation.DELETE_ALL;	
		return DatabaseOperation.NONE;
	}
	
	//@Override
	//protected void setUpDatabaseConfig(DatabaseConfig config){
	//	config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, value);;		
	//}
	
	



	@Override
	protected IDataSet getDataSet() throws Exception {
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("xml/dataset.xml"));
		return bancoCarregado;
	}

}
