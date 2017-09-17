package br.com.petdelivery.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Usuario;

@WebServlet("/adicionaUsuario")
public class AdicionaUsuarioServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// busca o writer
		PrintWriter out = response.getWriter();

		// buscando os parâmetros no request
		long CPF = Long.parseLong(request.getParameter("CPF"));
		String Nome = request.getParameter("Nome");
		int DDD = Integer.parseInt(request.getParameter("DDD"));
		int Telefone = Integer.parseInt(request.getParameter("Telefone"));
		String Rua = request.getParameter("Rua");
		int Numero = Integer.parseInt(request.getParameter("Numero"));
		String Complemento = request.getParameter("Complemento");
		String Bairro = request.getParameter("Bairro");
		String Email = request.getParameter("Email");
		String Senha = request.getParameter("Senha");
		

		// monta um objeto contato
		Usuario usuario = new Usuario();
		usuario.setCpf(CPF);
		usuario.setNome(Nome);
		usuario.setDdd(DDD);
		usuario.setTelefone(Telefone);
		usuario.setRua(Rua);
		usuario.setNumero(Numero);
		usuario.setComplemento(Complemento);
		usuario.setBairro(Bairro);
		usuario.setEmail(Email);
		usuario.setSenha(Senha);

		// salva o contato
		UsuarioDAO dao = new UsuarioDAO();
		dao.insert(usuario);

		// Retorna mensagem
		RequestDispatcher rd = request.getRequestDispatcher("/usuario-adicionado.jsp");
		rd.forward(request,response);
	}
}
