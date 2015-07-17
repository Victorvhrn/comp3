package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.ccu.exceptions.BancoException;
import entidades.Refeicao;
import roteiros.listagem.RoteiroListarRefeicao;

/**
 * Servlet implementation class ListarRefeicoes
 */
@WebServlet("/ListarRefeicao")
public class ListarRefeicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String acao = (String) request.getParameter("acaoListar");
    	String mensagem = null;
    	
    	
    	
    	if(acao == null) acao = "";
    	
    	
    	
    	
    	if(acao.equals("Criar")){
    		request.getRequestDispatcher("CriarRefeicao.jsp").forward(request, response);
    	}else if(acao.equals("Alterar")){
    		request.getRequestDispatcher("AlterarRefeicao.jsp").forward(request, response);
    	}else if (acao == ""){
    		RoteiroListarRefeicao rlr = new RoteiroListarRefeicao();
    		ArrayList<Refeicao> refeicoes = null;
			try {
				refeicoes = (ArrayList<Refeicao>) rlr.execute();
			} catch (BancoException e) {
				// TODO Auto-generated catch block
				request.setAttribute("mensagem", e.getMessage());
			}
    		request.setAttribute("refeicoes", refeicoes);
    		request.getRequestDispatcher("ListarRefeicao.jsp").forward(request, response);
    	}else{
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	}
    }

}
