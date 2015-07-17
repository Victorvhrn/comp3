
package mapeadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import entidades.Curso;
import entidades.Departamento;

public class DMCurso extends AbstractMapper<Curso> {

	@Override
	public void insert(Curso curso) throws SQLException {
		open();
		String sql = "insert into curso(nome,sigla,departamento_id) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, curso.getNome());
		stmt.setString(2, curso.getSigla());
		stmt.setInt(3, curso.getDepartamento().getId());
		stmt.execute();
		close();
	}

	@Override
	public void update(int id, Curso elemento) throws SQLException {
	}

	@Override
	public void delete(Curso elemento) {
		
	}

	@Override
	public Collection<Curso> selectAll() throws SQLException {
		open();
		String sql = "select curso.*,departamento.* from curso ";
		sql += "inner join departamento on curso.departamento_id = departamento.id";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Collection<Curso> result = new ArrayList<Curso>();
		while(rs.next()){
			int id = rs.getInt("curso.id");
			String nome = rs.getString("curso.nome");
			String sigla = rs.getString("curso.sigla");
			int dId = rs.getInt("departamento.id");
			String dNome = rs.getString("departamento.nome");
			String dSigla = rs.getString("departamento.sigla");
			Curso c = new Curso(id,nome,sigla,new Departamento(dId, dNome, dSigla));
			result.add(c);
		}
		close();
		return result;
	}

	@Override
	public Curso selectById(int id) throws SQLException {
		open();
		String sql 	= "select c.*,d.* from curso as c inner join departamento as d ";
		sql			+= "on c.departamento_id = d.id where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Curso result = null;
		while(rs.next()){
			String nome = rs.getString("c.nome");
			String sigla = rs.getString("c.sigla");
			int departamentoId = rs.getInt("d.id");
			String departamentoNome = rs.getString("d.nome");
			String departamentoSigla = rs.getString("d.sigla");
			result = new Curso(id,nome,sigla,new Departamento(departamentoId, departamentoNome, departamentoSigla));
		}
		close();
		return result;
	}

	@Override
	public Collection<Curso> selectByCampo(String campo, String valor)
			throws SQLException {
		open();
		String sql = "select * from curso ";
		sql += "inner join departamento on curso.departamento_id = departamento.id ";
		sql += " where ? = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, "curso."+campo);
		stmt.setString(2,valor);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Curso> result = new ArrayList<Curso>();
		while(rs.next()){
			int id = rs.getInt("c.id");
			String nome = rs.getString("c.nome");
			String sigla = rs.getString("c.sigla");
			int dId = rs.getInt("d.id");
			String dNome = rs.getString("d.nome");
			String dSigla = rs.getString("d.sigla");
			Curso c = new Curso(id,nome,sigla,new Departamento(dId, dNome, dSigla));
			result.add(c);
		}
		close();
		return result;
	}

}
