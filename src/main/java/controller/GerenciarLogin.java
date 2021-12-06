package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet implementation class GerenciarLogin
 */
@WebServlet("/GerenciarLogin.do")
public class GerenciarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static HttpServletResponse response;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GerenciarLogin.response = response;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		ArrayList<String> erros = new ArrayList<String>();
		if(login==null || login.trim().isEmpty()) {
			erros.add("Preencha o login");
		}
		if(senha==null || senha.trim().isEmpty()) {
			erros.add("Preencha a senha");
		}
		
		if(erros.size()>0) {
			String campos = "";
			for(String erro: erros) {
				campos = campos + "\\n"+erro;
			}
			exibirMensagem("Preencha os campos(s):"+campos);
		}else {
			
			try {
				
				UsuarioDAO uDAO = new UsuarioDAO();
				Usuario u = new Usuario();
				u = uDAO.getRecuperarUsuario(login);
				if(u.getIdUsuario()>0 && u.getSenha().equals(senha)) {
					HttpSession sessao = request.getSession();
					sessao.setAttribute("ulogado", u);
					response.sendRedirect("atrativos.jsp");
				}else {
					exibirMensagem("Login ou senha inválidos!");
				}
			} catch (Exception e) {
				exibirMensagem("Usuario não encontrado");
			}
		}
		
	}
	
	private static void exibirMensagem(String mensagem) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('"+mensagem+"');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
