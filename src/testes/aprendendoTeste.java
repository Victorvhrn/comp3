package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class aprendendoTeste {
		Calculadora calculadora;
		
		@Before
		public void setUp() {
			calculadora = new Calculadora();
		}

		@Test
		public void somaTeste() {
			int resultado = calculadora.soma(5,4);
			assertEquals(9, resultado, 0);
		}
		
		@Test
		public void somaTestePontoFlutuante() {
			double resultado = calculadora.soma(4.3, 2.1);
			// primeiro parametro resultado esperado.
			assertEquals(6.5, resultado, 0);
		}		

}
