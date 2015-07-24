package testes;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;

import entidades.Departamento;
import entidades.Ticket;
import roteiros.criacao.RoteiroCriarTicket;
import roteiros.alteracao.RoteiroAlterarTicket;
import mapeadores.AbstractMapper;

public class testeAlterarTicket extends DBTestCase{
	
	protected Connection connection;	
	private FlatXmlDataSet bancoCarregado;

	@Before
	public void setUp() throws Exception {
		 	System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:file:~/comp3-2" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );	        
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
	
	public void close() throws SQLException{
		connection.close();
	}
	
	public void testCriarDepartamento() throws Exception{		
		RoteiroCriarTicket criarTicket = new RoteiroCriarTicket();
		criarTicket.execute(false, 10, 20);
		
		open();
		String sql = "select id from ticket";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(rs.next()){
			result.add( rs.getInt("id"));			
		}
		close();
		
		
		int ultimoId = result.get(result.size() -1); // pega o ultimo elemento do arraylist
		
		
		
		RoteiroAlterarTicket alterarTicket = new RoteiroAlterarTicket();
		alterarTicket.execute(ultimoId, true);
		
		IDataSet dadosSetBanco = getConnection().createDataSet();
		ITable dadosNoBanco = dadosSetBanco.getTable("ticket");
		
		//remove coluna da tabela.
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(dadosNoBanco, new String[]{"id"});
		
		IDataSet dadosSetEsperado = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/alterarTicketDataset.xml"));
		ITable dadosEsperados = dadosSetEsperado.getTable("ticket");
		
		assertEquals(dadosEsperados, filteredTable);
	}
	
	//Antes de executar o teste.
	protected DatabaseOperation getSetUpOperation() throws Exception{
		//RoteiroCriarDepartamento Departamento = new RoteiroCriarDepartamento();
		//Departamento.execute("teste", "T");
		return DatabaseOperation.REFRESH;		
	}
	
	//depois  de executar a operação.
	protected DatabaseOperation getTearDownOperation() throws Exception{
		return DatabaseOperation.DELETE_ALL;	
		//return DatabaseOperation.NONE;
	}
	
	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config){
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());		
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("xml/alterarTicketDataset.xml"));
		return bancoCarregado;
	}

}
