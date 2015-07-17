package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controladores.ccu.exceptions.BancoException;
import entidades.Curso;
import entidades.Departamento;
import roteiros.listagem.RoteiroListarCurso;
import roteiros.listagem.RoteiroListarDepartamento;

@WebServlet("/ListarCurso")
public class ListarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acaoListar");
		String mensagem = null;

		if (acao == null) acao = "";
		

		if (acao.equals("Criar")) {
			ArrayList<Departamento> deptos = new ArrayList<Departamento>();
			try {
				deptos = (ArrayList<Departamento>) new RoteiroListarDepartamento().execute();
			} catch (BancoException e1) {
				// TODO Auto-generated catch block
				request.setAttribute("mensagem", e1.getMessage());
			}
			request.setAttribute("departamentos", deptos);
			request.getRequestDispatcher("CriarCurso.jsp").forward(request, response);
			ArrayList<Curso> cursos = null;

			RoteiroListarCurso rlc = new RoteiroListarCurso();

			try {
				cursos = (ArrayList<Curso>) rlc.execute();
				System.out.println(cursos);
			} catch (BancoException e) {

				mensagem = e.getMessage();
			}

			request.setAttribute("mensagem", mensagem);
			request.setAttribute("cursos", cursos);
		} else if (acao.equals("")) {

			ArrayList<Curso> cursos = null;

			RoteiroListarCurso rlc = new RoteiroListarCurso();

			try {
				cursos = (ArrayList<Curso>) rlc.execute();
			} catch (BancoException e) {

				mensagem = e.getMessage();
			}

			request.setAttribute("mensagem", mensagem);
			request.setAttribute("cursos", cursos);

			request.getRequestDispatcher("ListarCurso.jsp").forward(request, response);

		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}