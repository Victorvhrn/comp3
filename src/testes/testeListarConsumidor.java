package testes;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;
import java.util.Collection;

import org.junit.Before;

import entidades.Consumidor;
import roteiros.criacao.RoteiroCriarConsumidor;
import roteiros.listagem.RoteiroListarConsumidor;

public class testeListarConsumidor extends DBTestCase{
	
	private FlatXmlDataSet bancoCarregado;

	@Before
	public void setUp() throws Exception {
		 	System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:file:~/comp3" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
	        
	}
	
	public void testListarFuncionario() throws Exception{	
		
		//insere elemento na tabela
		RoteiroCriarConsumidor Consumidor = new RoteiroCriarConsumidor();
		Consumidor.execute("Teste", 1, 2012, "M", "PHD", "15146485481", 1, 2);
		
		
		RoteiroListarConsumidor ListarConsumidor = new RoteiroListarConsumidor();
		
		Collection<Consumidor> consumidor;
		consumidor = ListarConsumidor.execute(); // executa a listagem.
				
		
		assertEquals(false, consumidor.isEmpty());
	}
	
	public void testQuantidadeElementosListadosNaTabela() throws Exception{
		RoteiroCriarConsumidor Consumidor = new RoteiroCriarConsumidor();
		Consumidor.execute("Teste", 1, 2012, "M", "PHD", "15146485481", 1, 2);
		
		
		RoteiroListarConsumidor ListarConsumidor = new RoteiroListarConsumidor();
		
		Collection<Consumidor> consumidor;
		consumidor = ListarConsumidor.execute(); // executa a listagem.		
		
		assertEquals(1, consumidor.size());
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

	@Override
	protected IDataSet getDataSet() throws Exception {
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("xml/dataset.xml"));
		return bancoCarregado;
	}

}
