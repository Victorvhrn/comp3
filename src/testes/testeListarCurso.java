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

import entidades.Curso;
import roteiros.criacao.RoteiroCriarCurso;
import roteiros.listagem.RoteiroListarCurso;

public class testeListarCurso extends DBTestCase{
	
	private FlatXmlDataSet bancoCarregado;

	@Before
	public void setUp() throws Exception {
		 	System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:file:~/comp3" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
	        
	}
	
	public void testListarCurso() throws Exception{	
		
		//insere elemento na tabela
		RoteiroCriarCurso Curso = new RoteiroCriarCurso();
		Curso.execute("Ciencia da computacao", "cc", 1);
		
		
		RoteiroListarCurso ListarCurso = new RoteiroListarCurso();
		
		Collection<Curso> curso;
		curso = ListarCurso.execute(); // executa a listagem.
				
		
		assertEquals(false, curso.isEmpty());
	}
	
	public void testQuantidadeElementosListadosNaTabela() throws Exception{
		RoteiroCriarCurso Curso = new RoteiroCriarCurso();
		Curso.execute("Ciencia da computacao", "cc", 1);
		
		
		RoteiroListarCurso ListarCurso = new RoteiroListarCurso();
		
		Collection<Curso> curso;
		curso = ListarCurso.execute(); // executa a listagem.		
		
		assertEquals(1, curso.size());
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
