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
import entidades.Refeicao;
import entidades.Sexo;
import entidades.Ticket;
import entidades.Turno;
import mapeadores.DMTicket;

public class TestarDMTiket {
     Ticket t1;
     Ticket t2;
     Consumidor c1;
     Consumidor c2;
     Refeicao r1;
     Refeicao r2;
     DMTicket dm;

     
     @Before
     public void setUp() throws NomeNotFoundException, CPFInvalidoException, CPFIncompletoException{
    	 c1 = new Consumidor("Fernando Bessa", 2012785148, 2012, Sexo.MASCULINO,null, CPF.fromString("13122527235"));
    	 r1 = new Refeicao(0,Turno.NOITE,"Arroz com ovo","vagem");
    	 t1 = new Ticket(false, c1, r1);
    	 c2 = new Consumidor("Carlos Eduardo",201349824,2013,Sexo.MASCULINO,null,CPF.fromString("68331642406"));
    	 r2 = new Refeicao(0,Turno.MANHA,"Pão com queijo",null);
    	 t2 = new Ticket(false,c2,r2);
    	 dm = new  DMTicket();
     }
     
    @Test
     public void testarinsert() throws SQLException{
    	dm.insert(t1);
     }
     
    @Test 
     public void testarupdate() throws SQLException{
    	 dm.update(1, t2);
     }
    @Test
     public void testarselect() throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException{
    	 dm.selectById(1);
    	 
     }
    
     
}
