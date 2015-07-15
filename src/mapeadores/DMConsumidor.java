
package mapeadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import entidades.Aluno;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.Sexo;
import entidades.Titulo;

public class DMConsumidor extends AbstractMapper<Consumidor> {

	@Override
	public void insert(Consumidor consumidor) throws SQLException {
		open();
		String sql 	= "insert into consumidor(nome, matricula,ano_ingresso,sexo,titulo,cpf,curso_id,departamento_id) ";
		sql			+= "values (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, consumidor.getNome());
		stmt.setInt(2, consumidor.getMatricula());
		stmt.setInt(3, consumidor.getAnoIngresso());
		switch (consumidor.getSexo()) {
		case MASCULINO:
			stmt.setString(4, "Masculino");
			break;
		case FEMININO:
			stmt.setString(4,"Feminino");
			break;
		default:
			break;
		}
		switch (consumidor.getTitulo()) {
		case ESPECIALIZACAO:
			stmt.setString(5,"Especializacao");
			break;
		case MESTRADO:
			stmt.setString(5,"Mestrado");
			break;
		case DOUTORADO:
			stmt.setString(5,"Doutorado");
			break;
		default:
			break;
		}
		stmt.setString(6, consumidor.getCpf().toString());
		if(consumidor instanceof Aluno){
			stmt.setInt(7, ((Aluno) consumidor).getCurso().getId());
			stmt.setInt(8, 0); // null
		}else if(consumidor instanceof Funcionario){
			stmt.setInt(7, 0);
			stmt.setInt(8, ((Funcionario) consumidor).getDepartamento().getId());
		}
		stmt.execute();
		close();
	}

	@Override
	public void update(int id, Consumidor consumidor) throws SQLException {
		open();
		String sql = "update consumidor set nome = ?, matricula = ?, ano_ingresso = ?, sexo = ? where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,consumidor.getNome());
		stmt.setInt(2, consumidor.getMatricula());
		stmt.setInt(3, consumidor.getAnoIngresso());
		stmt.setString(4,consumidor.getSexo().getSexo());
		stmt.setInt(5, id);
		stmt.execute();
		close();
	}

	@Override
	public void delete(Consumidor consumidor) {
	}

	@Override
	public Collection<Consumidor> selectAll() throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException {
		open();
		String sql 	= "select cn.*,cs.*,dp.*,dp2.* from consumidor as cn ";
		sql			+= "left join curso as cs on cn.curso_id = cs.id ";
		sql 		+= "left join departamento as dp on cn.departamento_id = dp.id ";
		sql			+= "inner join departamento as dp2 on cs.departamento_id = dp2.id";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Collection<Consumidor> resultado = new ArrayList<Consumidor>();
		while(rs.next()){
			int id = rs.getInt("cn.id");
			String nome = rs.getString("cn.nome");
			int matricula = rs.getInt("cn.matricula");
			int anoIngresso = rs.getInt("cn.ano_ingresso");
			Sexo sexo = null;
			switch (rs.getString("cn.sexo")) {
				case "Masculino":
					sexo = Sexo.MASCULINO;
					break;
				case "Feminino":
					sexo = Sexo.FEMININO;
					break;
				default:
					break;
			}
			Titulo titulo = null;
			switch (rs.getString("cn.titulo")) {
				case "Especialização":
					titulo = Titulo.ESPECIALIZACAO;
					break;
				case "Mestrado":
					titulo = Titulo.MESTRADO;
					break;
				case "Doutorado":
					titulo = Titulo.DOUTORADO;
					break;
				default:
					break;
			}
			CPF cpf = CPF.fromString(rs.getString("cn.cpf"));
			if(rs.getInt("cn.departamento_id") == 0){ //é curso
				Departamento departamento = new Departamento(rs.getInt("dp2.id"), rs.getString("dp2.nome"), rs.getString("dp2.sigla"));
				Curso curso = new Curso(rs.getInt("cs.id"), rs.getString("cs.nome"), rs.getString("cs.sigla"), departamento);
				Aluno aluno = new Aluno(id, nome, matricula, anoIngresso, sexo, titulo, cpf, curso);
				resultado.add(aluno);
			}else if(rs.getInt("cn.curso_id") == 0){ // é departamento
				Departamento departamento = new Departamento(rs.getInt("dp.id"),rs.getString("dp.nome"), rs.getString("dp.sigla"));
				Funcionario funcionario = new Funcionario(id, nome, matricula, anoIngresso, sexo, titulo, cpf, departamento);
				resultado.add(funcionario);
			}
		}
		close();
		return resultado;
	}

	@Override
	public Consumidor selectById(int id) throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException {
		open();
		String sql 	= "select cn.*,cs.*,dp.*,dp2.* from consumidor as cn ";
		sql			+= "left join curso as cs on cn.curso_id = cs.id ";
		sql 		+= "left join departamento as dp on cn.departamento_id = dp.id ";
		sql			+= "inner join departamento as dp2 on cs.departamento_id = dp2.id ";
		sql			+= "where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();
		Consumidor resultado = null;
		while(rs.next()){
			String nome = rs.getString("cn.nome");
			int matricula = rs.getInt("cn.matricula");
			int anoIngresso = rs.getInt("cn.ano_ingresso");
			Sexo sexo = null;
			switch (rs.getString("cn.sexo")) {
				case "Masculino":
					sexo = Sexo.MASCULINO;
					break;
				case "Feminino":
					sexo = Sexo.FEMININO;
					break;
				default:
					break;
			}
			Titulo titulo = null;
			switch (rs.getString("cn.titulo")) {
				case "Especializacao":
					titulo = Titulo.ESPECIALIZACAO;
					break;
				case "Mestrado":
					titulo = Titulo.MESTRADO;
					break;
				case "Doutorado":
					titulo = Titulo.DOUTORADO;
					break;
				default:
					break;
			}
			CPF cpf = CPF.fromString(rs.getString("cn.cpf"));
			if(rs.getInt("cn.departamento_id") == 0){ //é curso
				Departamento departamento = new Departamento(rs.getInt("dp2.id"), rs.getString("dp2.nome"), rs.getString("dp2.sigla"));
				Curso curso = new Curso(rs.getInt("cs.id"), rs.getString("cs.nome"), rs.getString("cs.sigla"), departamento);
				Aluno aluno = new Aluno(id, nome, matricula, anoIngresso, sexo, titulo, cpf, curso);
				resultado = aluno;
			}else if(rs.getInt("cn.curso_id") == 0){ // é departamento
				Departamento departamento = new Departamento(rs.getInt("dp.id"),rs.getString("dp.nome"), rs.getString("dp.sigla"));
				Funcionario funcionario = new Funcionario(id, nome, matricula, anoIngresso, sexo, titulo, cpf, departamento);
				resultado = funcionario;
			}
		}
		close();
		return resultado;
	}

	@Override
	public Collection<Consumidor> selectByCampo(String campo, String valor)
			throws SQLException, CPFInvalidoException, CPFIncompletoException, NomeNotFoundException {
		open();
		String sql 	= "select cn.*,cs.*,dp.*,dp2.* from consumidor as cn ";
		sql			+= "left join curso as cs on cn.curso_id = cs.id ";
		sql 		+= "left join departamento as dp on cn.departamento_id = dp.id ";
		sql			+= "inner join departamento as dp2 on cs.departamento_id = dp2.id ";
		sql			+= "where ? = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,campo);
		stmt.setString(2,valor);
		ResultSet rs = stmt.executeQuery();
		Collection<Consumidor> resultado = new ArrayList<Consumidor>();
		while(rs.next()){
			int id = rs.getInt("cn.id");
			String nome = rs.getString("cn.nome");
			int matricula = rs.getInt("cn.matricula");
			int anoIngresso = rs.getInt("cn.ano_ingresso");
			Sexo sexo = null;
			switch (rs.getString("cn.sexo")) {
				case "Masculino":
					sexo = Sexo.MASCULINO;
					break;
				case "Feminino":
					sexo = Sexo.FEMININO;
					break;
				default:
					break;
			}
			Titulo titulo = null;
			switch (rs.getString("cn.titulo")) {
				case "Especializacao":
					titulo = Titulo.ESPECIALIZACAO;
					break;
				case "Mestrado":
					titulo = Titulo.MESTRADO;
					break;
				case "Doutorado":
					titulo = Titulo.DOUTORADO;
					break;
				default:
					break;
			}
			CPF cpf = CPF.fromString(rs.getString("cn.cpf"));
			if(rs.getInt("cn.departamento_id") == 0){ //é curso
				Departamento departamento = new Departamento(rs.getInt("dp2.id"), rs.getString("dp2.nome"), rs.getString("dp2.sigla"));
				Curso curso = new Curso(rs.getInt("cs.id"), rs.getString("cs.nome"), rs.getString("cs.sigla"), departamento);
				Aluno aluno = new Aluno(id, nome, matricula, anoIngresso, sexo, titulo, cpf, curso);
				resultado.add(aluno);
			}else if(rs.getInt("cn.curso_id") == 0){ // é departamento
				Departamento departamento = new Departamento(rs.getInt("dp.id"),rs.getString("dp.nome"), rs.getString("dp.sigla"));
				Funcionario funcionario = new Funcionario(id, nome, matricula, anoIngresso, sexo, titulo, cpf, departamento);
				resultado.add(funcionario);
			}
		}
		close();
		return resultado;
	}

}

