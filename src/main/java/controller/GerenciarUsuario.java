package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet implementation class GerenciarUsuario
 */
@WebServlet("/GerenciarUsuario.do")
public class GerenciarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		String idUsuario = request.getParameter("idUsuario");
		
		String mensagem = "";
		
		try {
			Usuario u = new Usuario();
			UsuarioDAO uDAO = new UsuarioDAO();
			if(acao.equals("alterar")) {
				u = uDAO.getCarregaPorID(Integer.parseInt(idUsuario));
				if(u.getIdUsuario()>0) {
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_usuario.jsp");
					request.setAttribute("usuario", u);
					disp.forward(request, response);
				}else {
					mensagem = "Usuario não encontrado";
				}
			}
			if(acao.equals("deletar")) {
				u.setIdUsuario(Integer.parseInt(idUsuario));
				if(uDAO.deletar(u)) {
					mensagem = "Excluido com sucesso!";
				}else {
					mensagem = "Erro ao excluir usuário";
				}
			}
				
		} catch (Exception e) {
			mensagem = "Erro ao executar!" + e;
		}
		out.println("<script type='text/javascript'>");
		out.println("alert('"+mensagem+"');");
		out.println("location.href='atrativos.jsp';");
		out.println("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String idUsuario = request.getParameter("idUsuario");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
    	String senha = request.getParameter("senha");
    	String telefone = request.getParameter("telefone");
    	String dataNascimento = request.getParameter("data_nascimento");
    	String idade = request.getParameter("idade");
    	String sexo = request.getParameter("sexo");
    	
    	Usuario u = new Usuario();
    	
    	String mensagem = "";
    	
    	if(!idUsuario.isEmpty()) {
    		u.setIdUsuario(Integer.parseInt(idUsuario));
    	}
    	if(nome.equals("")||login.equals("")||senha.equals("")||telefone.equals("")||dataNascimento.equals("")||idade.equals("")||sexo.equals("")) {
    		mensagem = "Campos obrigatórios devem ser preenchidos";
    	}else {
    		u.setNome(nome);
			u.setLogin(login);
			u.setSenha(senha);
			u.setTelefone(telefone);
			u.setDataNascimento(dataNascimento);
			u.setIdade(idade);
			u.setSexo(sexo);
			try {
				UsuarioDAO uDAO = new UsuarioDAO();
				
				if(uDAO.gravar(u)) {
					mensagem = "Gravado com sucesso!";
				}else {
					mensagem = "Erro ao gravar usuario!";
				}
			} catch (Exception e) {
				mensagem = "Erro ao executar!" + e;
			}
    	}
    		
    	
    	out.println("<script type='text/javascript'>");
		out.println("alert('"+mensagem+"');");
		out.println("location.href='atrativos.jsp';");
		out.println("</script>");
	}

}
