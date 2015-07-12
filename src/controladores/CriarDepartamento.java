package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiros.criacao.RoteiroCriarDepartamento;

@WebServlet("/CriarDepartamento")
public class CriarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		
		
		String nome = arg0.getParameter("nome");
		String sigla = arg0.getParameter("sigla");
		String mensagem=null;
		
		RoteiroCriarDepartamento rcd = new RoteiroCriarDepartamento();
		
		try {
			
			rcd.execute(nome, sigla);
			
		} catch (Exception e) {
			
			mensagem = e.getMessage();
			
		}
		
		arg0.setAttribute("mensagem",mensagem);
		arg0.setAttribute("acaoListar","Atualizar");
		RequestDispatcher rd = arg0.getRequestDispatcher("ListarDepartamento");
		rd.forward(arg0, arg1);
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	

}