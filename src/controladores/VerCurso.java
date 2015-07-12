package controladores;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.ccu.exceptions.CursoNotFoundException;
import entidades.Curso;

@WebServlet("/VerCurso")
public class VerCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoVer");
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Voltar":
				request.getRequestDispatcher("ListarCurso").forward(request,response);
				break;
			default:
				CursoVO cursoAntigo;
				try {
					cursoAntigo = GerirCurso.buscarCurso(request.getSession(),request.getParameter("sigla"));
					request.setAttribute("curso antigo",cursoAntigo);
					request.getRequestDispatcher("WEB-INF/VerCurso.jsp").forward(request,response);
				} catch (CursoNotFoundException e) {
					request.setAttribute("erro", "Curso não existe!");
					request.getRequestDispatcher("WEB-INF/VerCurso.jsp").forward(request,response);
				}				
		}
	}
}