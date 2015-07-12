package mapeadores;

import java.sql.SQLException;
import java.util.Collection;

import entidades.Departamento;

public class DMDepartamento extends AbstractMapper<Departamento> {

	public DMDepartamento() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Departamento elemento) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(int id,Departamento elemento) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Departamento elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Departamento> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
