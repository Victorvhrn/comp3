
package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Sexo;
import entidades.Titulo;

/**
 * Servlet implementation class CriarConsumidor
 */
@WebServlet("/CriarConsumidor")
public class CriarConsumidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarConsumidor() {  
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String acao = request.getParameter("acaoCriar");
        
        if(acao.equals("Criar")){
        	criarConsumidor(request, response);
        }else{
        	request.getRequestDispatcher("WEB-INF/CriarConsumidor.jsp").forward(request,response);
        }
	
	}
	
	private void criarConsumidor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nome = (String)request.getAttribute("nome");
        int matricula = (int)request.getAttribute("matricula");
        String anoIngresso = (String)request.getAttribute("anoIngresso") ;
        Sexo sexo = (request.getAttribute("sexo").equals("masculino")) ? Sexo.MASCULINO : Sexo.FEMININO;
        Titulo titulo;
        String cpf = (String) request.getAttribute("cpf");
        if(request.getAttribute("titulo").equals("Especializacao"))
        {
        	titulo = Titulo.ESPECIALIZACAO;
        }
        else if(request.getAttribute("titulo").equals("Mestrado"))
        {
        	titulo = Titulo.MESTRADO;
        }
        else
        {
        	titulo = Titulo.DOUTORADO;
        }
        
        
        try {
        	//RoteiroCriarConsumidor rcc = new RoteiroCriarConsumidor(nome,matricula,anoIngresso,sexo,titulo,cpf)
		} catch (Exception e) {
			//Criar Exception de cpf inválido e outras exceptions de dados invalidos.
			request.setAttribute("erro",e.getMessage());
			request.getRequestDispatcher("WEB-INF/messagePage.jsp").forward(request,response);
		}
	}
}
