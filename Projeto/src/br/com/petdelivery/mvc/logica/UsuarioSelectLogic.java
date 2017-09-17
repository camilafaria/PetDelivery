package br.com.petdelivery.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class UsuarioSelectLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// Monta a lista de contatos
		List<Usuario> usuarios = new UsuarioDAO().getAllUsuarios();

		// Guarda a lista no request
		req.setAttribute("usuarios", usuarios);

		return "lista-contatos.jsp";
	}

}
