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
		//Exemplo:
		String sql = "query de inserir departamento"+elemento.getNome()+elemento.getSigla();
		//connection.execute(sql);
	}

	@Override
	public void update(Departamento elemento) {
		//Exemplo
		String sql = "query de atualizar departamento"+elemento.getId();
		
	}

	@Override
	public void delete(Departamento elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Departamento> select(String filtro, Collection<Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
