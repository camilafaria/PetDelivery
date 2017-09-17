package br.com.petdelivery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petdelivery.jdbc.dao.AnimalDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Animal;

@Controller
public class HomeUsuarioController {

	// Mapeamento de JSP
	@RequestMapping("home")
	public String index() {
		return "posLogin/usuario/home";
	}

	// Mapeamento de JSP
	@RequestMapping("pets")
	public String pets() {
		return "posLogin/usuario/meusPets";
	}

	// Mapeamento de JSP
	@RequestMapping("cadastro-pet")
	public String cadastraPets() {
		return "posLogin/usuario/cadastraPet";
	}

	// Mapeamento de JSP
	@RequestMapping("inserePet")
	public String adicionaPet(Animal animal, HttpSession session) {
		new AnimalDAO().insert(animal);
		// Adiciona o prestador ao session e manda par ao login
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
}
