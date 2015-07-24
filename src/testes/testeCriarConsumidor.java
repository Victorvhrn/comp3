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
import roteiros.criacao.RoteiroCriarConsumidor;
import roteiros.criacao.RoteiroCriarCurso;
import roteiros.criacao.RoteiroCriarDepartamento;

public class testeCriarConsumidor extends DBTestCase{
	
	protected Connection connection;
	private FlatXmlDataSet bancoCarregado;

	@Before
	public void setUp() throws Exception {
		 	System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:file:~/comp3-2" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
	        
	}
	
	public void testCriarDepartamento() throws Exception{	
		
		RoteiroCriarDepartamento Departamento = new RoteiroCriarDepartamento();
		Departamento.execute("teste", "T");
		
		open();
		String sql = "select id from departamento";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(rs.next()){
			result.add( rs.getInt("id"));			
		}
		close();
		
		
		int ultimoIdDepartamento = result.get(result.size() -1);
		
		
		RoteiroCriarCurso Curso = new RoteiroCriarCurso();
		Curso.execute("ciencia da computacao", "cc", ultimoIdDepartamento);
		
		open();
		sql = "select id from curso";
		stmt = connection.prepareStatement(sql);
		rs = stmt.executeQuery();
		result = new ArrayList<Integer>();
		while(rs.next()){
			result.add( rs.getInt("id"));			
		}
		close();
		
		int ultimoIdCurso = result.get(result.size() -1);
		
		
		RoteiroCriarConsumidor Consumidor = new RoteiroCriarConsumidor();
		Consumidor.execute("Teste", 1, 2012, "M", "Especializacao", "15146485481", ultimoIdCurso, ultimoIdDepartamento);
		
		IDataSet dadosSetBanco = getConnection().createDataSet();
		ITable dadosNoBanco = dadosSetBanco.getTable("consumidor");
		
		//remove coluna da tabela.
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(dadosNoBanco, new String[]{"id", "departamento_id", "curso_id"});
		
		IDataSet dadosSetEsperado = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/datasetCriarConsumidor.xml"));
		ITable dadosEsperados = dadosSetEsperado.getTable("consumidor");
		
		Assertion.assertEquals(dadosEsperados, filteredTable);
	}
	
	public void testQuantidadeRegistroTabela() throws Exception{
		RoteiroCriarConsumidor Consumidor = new RoteiroCriarConsumidor();
		Consumidor.execute("Teste", 1, 2012, "M", "PHD", "15146485481", 1, 2);
		
		IDataSet dadosSetBanco = getConnection().createDataSet();
		int rowCount = dadosSetBanco.getTable("consumidor").getRowCount();
		
		assertEquals(1, rowCount);
	}

	
	//Antes de executar o teste.
	protected DatabaseOperation getSetUpOperation() throws Exception{
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
	
	
	public void open() throws SQLException{
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SQLException();
		}
		connection = DriverManager.getConnection("jdbc:h2:file:~/comp3-2","sa","");
	}
	
	public void close() throws SQLException{
		connection.close();
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("xml/datasetCriarConsumidor.xml"));
		return bancoCarregado;
	}

}
