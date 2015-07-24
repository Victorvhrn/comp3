package testes;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;
import java.util.Collection;

import org.junit.Before;

import entidades.Refeicao;
import roteiros.criacao.RoteiroCriarRefeicao;
import roteiros.listagem.RoteiroListarRefeicao;

public class testeListarRefeicao extends DBTestCase{
	
	private FlatXmlDataSet bancoCarregado;

	@Before
	public void setUp() throws Exception {
		 	System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:file:~/comp3-2" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );	        
	}
	
	public void testListarRefeicao() throws Exception{	
		
		//insere elemento na tabela
		RoteiroCriarRefeicao Refeicao = new RoteiroCriarRefeicao();
		Refeicao.execute("manhã", "teste", "nenhuma");		
		
		RoteiroListarRefeicao ListarRefeicao = new RoteiroListarRefeicao();
		
		Collection<Refeicao> refeicao;
		refeicao = ListarRefeicao.execute(); // executa a listagem.				
		
		assertEquals(false, refeicao.isEmpty());
	}
	
	public void testQuantidadeElementosListadosNaTabela() throws Exception{
		RoteiroCriarRefeicao Refeicao = new RoteiroCriarRefeicao();
		Refeicao.execute("manhã", "teste", "nenhuma");
		
		RoteiroListarRefeicao ListarRefeicao = new RoteiroListarRefeicao();
		
		Collection<Refeicao> refeicao;
		refeicao = ListarRefeicao.execute(); // executa a listagem.		
		
		assertEquals(1, refeicao.size());
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
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("xml/dataset.xml"));
		return bancoCarregado;
	}

}
