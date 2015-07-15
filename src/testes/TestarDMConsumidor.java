package testes;

import static org.junit.Assert.*;

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
		
	}
	

}
