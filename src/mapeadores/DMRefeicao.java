package mapeadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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
	}

	@Override
	public void delete(Refeicao elemento) {

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
			case "Manhã":
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
		ResultSet rs = stmt.executeQuery();
		Turno turno;
		switch (rs.getString("turno")) {
		case "Manhã":
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
			throws SQLException {
		return null;
	}

}
