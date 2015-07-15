package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Sexo;
import mapeadores.DMConsumidor;

public class TestarDMConsumidor {	
	Consumidor c1;
	Consumidor c2;
	Consumidor c3;
	DMConsumidor dm;
	
	@Before
	public void SetUp() throws NomeNotFoundException, CPFInvalidoException, CPFIncompletoException{
		c1 = new Consumidor(0, "Fernando Hendique Bessa Marinho", 2012785148, 2012,Sexo.MASCULINO, null, CPF.fromString("15169573774"));
		c2 = new Consumidor(0,"Victor Hugo do nascimento pereira",2014872821,2012,Sexo.FEMININO,null,CPF.fromString("17663615018"));
		dm = new DMConsumidor();
		
	}
	
	@Test
	public void Testinsert() throws SQLException{
		dm.insert(c1);
		
	}
	
	
	@Test
	public void TestSelectId() throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException{
		dm.selectById(1);
	}
	
	@Test
	public void TestUpdate() throws SQLException{
		dm.update(1, c2);
	}

	@Test
	public void TestSelect() throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException{
		
		dm.selectByCampo("nome", "Fernando Henrique Bessa Marinho");
	}
}
