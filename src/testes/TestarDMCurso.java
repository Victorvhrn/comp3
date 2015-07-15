package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Curso;
import entidades.Departamento;
import mapeadores.DMCurso;


public class TestarDMCurso {
	Curso c1;
	Curso c2;
	Departamento dp1;
	Departamento dp2;
	DMCurso dm;
	
	@Before
	public void setUP() throws NomeNotFoundException, SiglaNotFoundException{
		
		dp1= new Departamento("Departamento de ciência da computação", "DCC");
		dp2= new Departamento("Departamento de Matemática", "DCC");
		c1 = new Curso("Ciência da Computação", "Ccomp", dp1);
		c2 = new Curso("Matemática","MAT",dp2);
		dm = new DMCurso();
	}

@Test
public void TesteInser() throws SQLException{
	
	dm.insert(c1);
}
@Test
public void TesteSelectId() throws SQLException{
	dm.selectById(1);
	
}
@Test
public void TesteUpdate() throws SQLException{
	dm.update(1, c2);
	
}

@Test
public void SelectCampo() throws SQLException{
	dm.selectByCampo("sigla", "DCC");
	
}

}
