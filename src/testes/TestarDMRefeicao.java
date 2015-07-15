package testes;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controladores.ccu.exceptions.DescricaoNotFoundException;
import controladores.ccu.exceptions.OpcaoVeganNotFoundException;
import entidades.Refeicao;
import entidades.Turno;
import mapeadores.DMRefeicao;


public class TestarDMRefeicao {
	Refeicao r1;
	Refeicao r2;
	DMRefeicao dm;
	
	@Before
	public void setup() throws DescricaoNotFoundException, OpcaoVeganNotFoundException{
		r1 = new Refeicao( Turno.MANHA, "Café com leite e pão", "Não tem");
		r2= new Refeicao(Turno.NOITE,"Arraoz com ovo","alface");
		dm = new DMRefeicao();
	} 
	
	@Test
	public void TesteInserirRefeicao() throws SQLException{
		dm.insert(r1);
	}
	
	@Test
	public void TesteSelectRefeicaoId() throws SQLException{
		dm.selectById(1);
		
	}
	
	@Test
	public void UpdateRefeicao() throws SQLException{
		dm.update(1, r2);
		
	}
	
	public void SelectCampoRefeicao() throws SQLException{
		dm.selectByCampo("Descrição", "Arroz com ovo");
	}
	
	
	
	
	
}
