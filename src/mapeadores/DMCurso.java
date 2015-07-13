package mapeadores;

import java.sql.SQLException;
import java.util.Collection;

import entidades.Curso;

public class DMCurso extends AbstractMapper<Curso> {

	@Override
	public void insert(Curso elemento) throws SQLException {
		
	}

	@Override
	public void update(int id, Curso elemento) throws SQLException {
		
	}

	@Override
	public void delete(Curso elemento) {
		
	}

	@Override
	public Collection<Curso> selectAll() throws SQLException {
		return null;
	}

	@Override
	public Curso selectById(int id) throws SQLException {
		return null;
	}

	@Override
	public Collection<Curso> selectByCampo(String campo, String valor)
			throws SQLException {
		return null;
	}

}
