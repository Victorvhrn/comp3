
package mapeadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import entidades.Departamento;

public class DMDepartamento extends AbstractMapper<Departamento> {

	@Override
	public void insert(Departamento depto) throws SQLException {
		open();
		String sql = "insert into departamento (nome,sigla) values (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, depto.getNome());
		stmt.setString(2, depto.getSigla());
		stmt.execute();
		close();
	}

	@Override
	public void update(int id,Departamento depto) throws SQLException {
		open();
		String sql = "update departamento set nome = ?, sigla = ? where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, depto.getNome());
		stmt.setString(2, depto.getSigla());
		stmt.setInt(3, id);
		stmt.execute();
		close();
	}

	@Override
	public void delete(Departamento elem) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Departamento> selectAll() throws SQLException {
		open();
		ArrayList<Departamento> result = new ArrayList<Departamento>();
		String sql = "select * from departamento";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String sigla = rs.getString("sigla");
			Departamento depto = new Departamento(id,nome,sigla);
			result.add(depto);
		}
		close();
		return result;
	}

	@Override
	public Departamento selectById(int id) throws SQLException {
		open();
		String sql = "select * from departamento where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Departamento dpto = new Departamento( rs.getInt("id"),
					rs.getString("nome"),rs.getString("sigla"));
		close();
		return dpto;
	}

	@Override
	public Collection<Departamento> selectByCampo(String campo, String valor) throws SQLException {
		open();
		String sql = "select * from departamento where ? = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, campo);
		stmt.setString(2,valor);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Departamento> result = new ArrayList<Departamento>();
		while(rs.next()){
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String sigla = rs.getString("sigla");
			result.add(new Departamento(id,nome,sigla));
		}
		close();
		return result;
	}
}

