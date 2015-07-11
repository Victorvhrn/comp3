package mapeadores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import entidades.Departamento;

public class DMDepartamento extends AbstractMapper {

	@Override
	public void insert(Object elemento) {
		Departamento depto = (Departamento) elemento;
		
		try {
			stmt = connection.prepareStatement("insert into departamento(nome)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected String query(String query) {
		HashMap<String,String>  querys = new HashMap<String,String>();
		querys.put("select all departamentos", "select * from departamento");
		
		String sql = querys.get(query);
		return sql;
	}

	@Override
	public List execute(String query, List params) {
		
		String sql = query(query);
		
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
			
		
		
		return null;
	}

	@Override
	public void update(Object elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object elem) {
		// TODO Auto-generated method stub
		
	}

}
