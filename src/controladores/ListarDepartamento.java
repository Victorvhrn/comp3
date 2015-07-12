package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controladores.ccu.exceptions.BancoException;
import entidades.Departamento;
import mapeadores.DMDepartamento;
import roteiros.listagem.RoteiroListarDepartamento;

@WebServlet("/ListarDepartamento")
public class ListarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);

		ArrayList<Departamento> dps;
		RoteiroListarDepartamento rtd;
		RequestDispatcher rd = arg0.getRequestDispatcher("ListarDepartamento.jsp");
		
		rtd = new RoteiroListarDepartamento();
		
		String acao = arg0.getParameter("acaoListar");
		
		if(acao ==null) acao ="";

	
		if(acao.equals("Atualizar")){	
			dps =null;
			String mensagem1;
			try{
				dps = (ArrayList<Departamento>) rtd.execute();
			}catch (BancoException e){
				mensagem1 = e.getMessage();
				arg0.setAttribute("mensagem",mensagem1);
			}
			
			arg0.setAttribute("departamentos",dps);
			rd.forward(arg0, arg1);
		
		}else if(acao.equals("Criar")){
			RequestDispatcher rd1 = arg0.getRequestDispatcher("CriarDepartamento.jsp");
			rd1.forward(arg0, arg1);
		}else if(acao.equals("")){

				dps =null;
				String mensagem2;
				try{
					dps = (ArrayList<Departamento>) rtd.execute();
				}catch (BancoException e){
					mensagem2 = e.getMessage();
					arg0.setAttribute("mensagem",mensagem2);
				}
				
				arg0.setAttribute("departamentos",dps);
				rd.forward(arg0, arg1);	
		}
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
