package br.com.petdelivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petdelivery.jdbc.dao.AnimalDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Animal;
import br.com.petdelivery.jdbc.modelo.Usuario;

@Controller
public class HomeUsuarioController {

	// Mapeamento de JSP
	@RequestMapping("home")
	public String index(HttpServletRequest request) {
		return "posLogin/usuario/home";
	}
	
	// Mapeamento de JSP
	@RequestMapping("pets")
	public String pets(HttpServletRequest request) {
		return "posLogin/usuario/meusPets";
	}

	// Mapeamento de JSP
	@RequestMapping("cadastro-pet")
	public String cadastraPets(HttpServletRequest request) {
		return "posLogin/usuario/cadastraPet";
	}

	// Mapeamento de JSP
	@RequestMapping("inserePet")
	public String adicionaPet(Animal animal, HttpSession session) {
		new AnimalDAO().insert(animal);
		session.setAttribute("animalCriado", true);

		return "posLogin/usuario/meusPets";
	}

	@RequestMapping("busca-servico")
	public String buscaFiltroServico() {
		return "posLogin/usuario/buscaFiltroServico";
	}

	// Controllers de tarefa

	/**
	 * Retorna a lista de prestadores baseado no filtro selecionado na busca
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("buscar-servico")
	public String buscarServicos(HttpSession session) {

		return "listarPrestadores";
	}

	@RequestMapping("configConta")
	public String configConta(HttpServletRequest request) {
		return "posLogin/usuario/configConta";
	}

	// Mapeamento de JSP
	@RequestMapping("update-usuario")
	public String updateUsuario(Usuario usuario, HttpSession session) {
		new UsuarioDAO().update(usuario);
		session.setAttribute("usuarioAtualizado", true);

		return "posLogin/usuario/home";
	}
	
	@RequestMapping("visualiza")
	public String visualizaAutonomo(HttpSession session) {
		return "posLogin/usuario/visualizaPerfilAutonomo";
	}

	@RequestMapping("logout")
	public String logoutUsuario(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
}
