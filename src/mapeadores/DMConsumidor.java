
package mapeadores;

import java.sql.SQLException;
import java.util.Collection;

import entidades.Consumidor;

public class DMConsumidor extends AbstractMapper<Consumidor> {

	@Override
	public void insert(Consumidor elemento) throws SQLException {
	}

	@Override
	public void update(int id, Consumidor elemento) throws SQLException {
		
		
	}

	@Override
	public void delete(Consumidor elemento) {
		
		
	}

	@Override
	public Collection<Consumidor> selectAll() throws SQLException {
		
		return null;
	}

	@Override
	public Consumidor selectById(int id) throws SQLException {
		
		return null;
	}

	@Override
	public Collection<Consumidor> selectByCampo(String campo, String valor)
			throws SQLException {
		
		return null;
	}

}

