package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Departamento;
import mapeadores.DMDepartamento;


public class TestarDMDepartamento {
	Departamento dp1;
	Departamento dp ;
	Departamento dp2;
	DMDepartamento dm;
	ArrayList<Departamento> list;
	
	
	
	@Before
	public void setUp() throws NomeNotFoundException, SiglaNotFoundException {
		dp = new Departamento ("Fernando Bessa ", "FB");
		dm = new DMDepartamento();
		dp1 = new Departamento("Fernando Henrique", "FB");
		
		
		
	}
	
	@Test
	public void TestarInserDepartament() throws SQLException{
	    dm.insert(dp);
		
	}
	
	@Test
	public void TestarSelectDepartamentoId() throws SQLException{
		
		dp2 = dm.selectById(1);
	}
	
	@Test
	public void TestarUpdateDepartamento() throws SQLException{
		dm.update(1, dp1);
	}
	
	@Test
	public void TestarSelectDepartamentoCampo() throws SQLException{
		
		list =(ArrayList<Departamento>)dm.selectByCampo("sigla", "FB");
		
		
	}
	
	@Test
	public void TestarGetDepartamento(){
		String resultado = dp1.getNome();
		String esperado = "Fernando Henrique";
	assertEquals(esperado,resultado);	
	
		
		
	}
	
	

}
