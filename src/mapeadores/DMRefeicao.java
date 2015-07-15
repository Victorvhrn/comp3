
package mapeadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controladores.ccu.exceptions.DescricaoNotFoundException;
import controladores.ccu.exceptions.OpcaoVeganNotFoundException;
import entidades.Refeicao;
import entidades.Turno;

public class DMRefeicao extends AbstractMapper<Refeicao> {

	@Override
	public void insert(Refeicao refeicao) throws SQLException {
		open();
		String sql = "insert into refeicao(turno,descricao,opcao_vegan) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		Turno t;
		switch (refeicao.getTurno()) {
		case MANHA:
			t = Turno.MANHA;
			stmt.setString(1,t.getNome());
			break;
		case TARDE:
			t = Turno.TARDE;
			stmt.setString(1,t.getNome());
			break;
		case NOITE:
			t = Turno.NOITE;
			stmt.setString(1,t.getNome());
			break;
		default:
			break;
		}
		stmt.setString(2, refeicao.getDescricao());
		stmt.setString(3, refeicao.getOpcaoVegan());
		stmt.execute();
		close();
	}

	@Override
	public void update(int id, Refeicao elemento) throws SQLException {
		open();
		String sqlUpdate= "update refeicao set turno = ?, descricao = ?, opcao_vegan= ? where id= ?" ;
		PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
		Turno t = elemento.getTurno();
	    String descricao = elemento.getDescricao();
	    String opcao = elemento.getOpcaoVegan();
		stmt.setString(1,t.getNome());
		stmt.setString(2,descricao);
		stmt.setString(3,opcao);
		stmt.setInt(4, id);
		stmt.execute();
		close();
	}

	

	@Override
	public Collection<Refeicao> selectAll() throws SQLException {
		open();
		String sql = "select * from refeicao";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Collection<Refeicao> resultado = new ArrayList<Refeicao>();
		while(rs.next()){
			int id = rs.getInt("id");
			Turno turno;
			switch (rs.getString("turno")) {
			case "Manha":
				turno = Turno.MANHA;
				break;
			case "Tarde":
				turno = Turno.TARDE;
				break;
			case "Noite":
				turno = Turno.NOITE;
				break;
			default:
				throw new SQLException();
			}
			String descricao = rs.getString("descricao");
			String opcaoVegan = rs.getString("opcao_vegan");
			resultado.add(new Refeicao(id, turno, descricao, opcaoVegan));
		}
		close();
		return resultado;
	}

	@Override
	public Refeicao selectById(int id) throws SQLException {
		open();
		String sql = "select * from refeicao where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Turno turno;
		switch (rs.getString("turno")) {
		case "Manha":
			turno = Turno.MANHA;
			break;
		case "Tarde":
			turno = Turno.TARDE;
			break;
		case "Noite":
			turno = Turno.NOITE;
			break;
		default:
			throw new SQLException();
		}
		String descricao = rs.getString("descricao");
		String opcaoVegan = rs.getString("opcao_vegan");
		close();
		return new Refeicao(id,turno,descricao,opcaoVegan);
	}

	@Override
	public Collection<Refeicao> selectByCampo(String campo, String valor)
			throws SQLException, DescricaoNotFoundException, OpcaoVeganNotFoundException {
		open();
		String sqlColection = "select * from refeicao where ? = ?";
		PreparedStatement stmt = connection.prepareStatement(sqlColection);
		stmt.setString(1, campo);
		stmt.setString(2,valor);
		ResultSet rs = stmt.executeQuery();
		Collection <Refeicao> result = new ArrayList<Refeicao>();
		Turno t = null;
		
		while(rs.next()){
			switch (rs.getString("turno")){
			
			case "Manha":
			   t = Turno.MANHA;
			   break;
			case "Noite":
				t = Turno.NOITE;
				break;
			case "Tarde":
				t = Turno.TARDE;
			 break;
			 
			}
			String descricao = rs.getString("descricao");
			String opcao = rs.getString("opcao_vegan");
			result.add(new Refeicao(t,descricao,opcao));
		}
		close();
		
		
		return result;
	}

	@Override
	public void delete(Refeicao elemento) {
	}

}

