
package roteiros.criacao;

import java.sql.SQLException;
import java.util.Collection;

import controladores.ccu.exceptions.BancoException;
import controladores.ccu.exceptions.CPFAlreadyExistsException;
import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;
import controladores.ccu.exceptions.NomeNotFoundException;
import mapeadores.DMConsumidor;
import mapeadores.DMCurso;
import mapeadores.DMDepartamento;
import entidades.Aluno;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.Sexo;
import entidades.Titulo;

public class RoteiroCriarConsumidor {
	public void execute(String nome, int matricula, int anoIngresso, String sexo,
						String titulo,String cpf, int cursoId,int departamentoId) throws BancoException, CPFInvalidoException, CPFIncompletoException, CPFAlreadyExistsException, NomeNotFoundException{
			Sexo sex = (sexo.equals("Masculino")) ? Sexo.MASCULINO : Sexo.FEMININO;
			Titulo t = null;
			switch (titulo) {
			case "Especializacao":
				t = Titulo.ESPECIALIZACAO;
				break;
			case "Mestrado":
				t = Titulo.MESTRADO;
				break;
			case "Doutorado":
				t = Titulo.DOUTORADO;
				break;
			default:
				break;
			}
			DMConsumidor dmC = new DMConsumidor();
			try {
				Collection<Consumidor> temp = dmC.selectByCampo("cpf", cpf);
				if(!temp.isEmpty())
					throw new CPFAlreadyExistsException(cpf);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
				throw new BancoException();
			}
			if(cursoId > 0){
				DMCurso dmCurso = new DMCurso();
				try {
					Curso curso = dmCurso.selectById(cursoId);
					Aluno aluno = new Aluno(nome, matricula, anoIngresso, sex, t, CPF.fromString(cpf), curso);
					dmC.insert(aluno);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					throw new BancoException();
				}
			}else if(departamentoId > 0){
				DMDepartamento dmD = new DMDepartamento();
				try {
					Departamento departamento = dmD.selectById(departamentoId);
					Funcionario funcionario = new Funcionario(nome, matricula, anoIngresso, sex, t, CPF.fromString(cpf), departamento);
					dmC.insert(funcionario);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					throw new BancoException();
				}
			}
	}
}
