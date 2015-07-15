
package mapeadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Refeicao;
import entidades.Sexo;
import entidades.Ticket;
import entidades.Titulo;
import entidades.Turno;

public class DMTicket extends AbstractMapper<Ticket> {

	@Override
	public void insert(Ticket ticket) throws SQLException {
		open();
		String sql = "insert into ticket(pago,consumidor_id,refeicao_id) values(?,?,?)";
		PreparedStatement stmt =  connection.prepareStatement(sql);
		stmt.setBoolean(1, ticket.isPago());
		stmt.setInt(2, ticket.getConsumidor().getId());
		stmt.setInt(3, ticket.getRefeicao().getId());
		stmt.execute();
		close();
	}

	@Override
	public void update(int id, Ticket ticket) throws SQLException {
		open();
		String sql = "update ticket set pago = ? where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setBoolean(1,ticket.isPago());
		stmt.setInt(2, id);
		close();
	}

	@Override
	public void delete(Ticket elemento) {
	}

	@Override
	public Collection<Ticket> selectAll() throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException {
		open();
		String sql = "select t.*,c.*,r.* from ticket as t";
		sql += "inner join consumidor as c on t.consumidor_id = c.id";
		sql += "inner join refeicao as r on t.refeicao_id = r.id";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Ticket> resultado = new ArrayList<Ticket>();
		while(rs.next()){
			int id 				= rs.getInt("t.id");
			boolean pago		= rs.getBoolean("t.pago");
			int idConsumidor	= rs.getInt("c.id");
			String nome			= rs.getString("c.nome");
			int matricula		= rs.getInt("c.matricula");
			int anoIngresso		= rs.getInt("c.ano_ingresso");
			Sexo sexo			= rs.getString("c.sexo") == "M" ? Sexo.MASCULINO : Sexo.FEMININO;
			Titulo titulo;
			switch (rs.getString("c.titulo")) {
			case "Especializa��o":
				titulo = Titulo.ESPECIALIZACAO;
				break;
			case "Mestrado":
				titulo = Titulo.MESTRADO;
				break;
			case "Doutorado":
				titulo = Titulo.DOUTORADO;
				break;
			default:
				throw new SQLException();
			}
			CPF cpf				= CPF.fromString(rs.getString("c.cpf"));
			Consumidor c = new Consumidor(idConsumidor,nome, matricula, anoIngresso, sexo, titulo, cpf);
			int idRefeicao = rs.getInt("r.id");
			String descricao = rs.getString("r.descricao");
			String opcaoVegan = rs.getString("r.opcao_vegan");
			Turno turno;
			switch (rs.getString("r.turno")) {
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
			Refeicao r = new Refeicao(idRefeicao, turno, descricao, opcaoVegan);
			resultado.add(new Ticket(id,pago, c, r));
		}
		close();
		return resultado;
	}

	@Override
	public Ticket selectById(int id) throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException {
		open();
		String sql = "select t.*,c.*,r.* from ticket as t";
		sql += "inner join consumidor as c on t.consumidor_id = c.id";
		sql += "inner join refeicao as r on t.refeicao_id = r.id";
		sql	+= "where t.id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		boolean pago		= rs.getBoolean("t.pago");
		int idConsumidor	= rs.getInt("c.id");
		String nome			= rs.getString("c.nome");
		int matricula		= rs.getInt("c.matricula");
		int anoIngresso		= rs.getInt("c.ano_ingresso");
		Sexo sexo			= rs.getString("c.sexo") == "M" ? Sexo.MASCULINO : Sexo.FEMININO;
		Titulo titulo;
		switch (rs.getString("c.titulo")) {
		case "Especializa��o":
			titulo = Titulo.ESPECIALIZACAO;
			break;
		case "Mestrado":
			titulo = Titulo.MESTRADO;
			break;
		case "Doutorado":
			titulo = Titulo.DOUTORADO;
			break;
		default:
			throw new SQLException();
		}
		CPF cpf				= CPF.fromString(rs.getString("c.cpf"));
		Consumidor c = new Consumidor(idConsumidor,nome, matricula, anoIngresso, sexo, titulo, cpf);
		int idRefeicao = rs.getInt("r.id");
		String descricao = rs.getString("r.descricao");
		String opcaoVegan = rs.getString("r.opcao_vegan");
		Turno turno;
		switch (rs.getString("r.turno")) {
		case "Manh�":
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
		Refeicao r = new Refeicao(idRefeicao, turno, descricao, opcaoVegan);
		Ticket t = new Ticket(id,pago, c, r);
		close();
		return t;
	}

	@Override
	public Collection<Ticket> selectByCampo(String campo, String valor)
			throws SQLException {	
		return null;
	}

}

