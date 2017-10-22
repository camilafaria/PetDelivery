package br.com.petdelivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petdelivery.jdbc.dao.AnimalDAO;
import br.com.petdelivery.jdbc.dao.AutonomoDAO;
import br.com.petdelivery.jdbc.dao.PrestadorDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Animal;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Busca;
import br.com.petdelivery.jdbc.modelo.Prestador;
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
	
	//Visualiza página do Prestador Autonomo
	@RequestMapping("visualiza-autonomo")
	public String vizualizaAutonomo(HttpServletRequest request, HttpSession session) {
		Prestador prestador = new Prestador();
		prestador.setId_prestador(Long.parseLong(request.getParameter("id")));
		Autonomo autonomo = new AutonomoDAO().getAutonomo(prestador);
		
		session.setAttribute("perfilPrestador", prestador);
		session.setAttribute("perfilPrestadorAutonomo", autonomo);
		
		return "posLogin/usuario/visualizaPerfilAutonomo";
	}

	@RequestMapping("busca-servico")
	public String buscaFiltroServico() {
		return "posLogin/usuario/buscaFiltroServico";
	}

	// Controllers de tarefa

	/**
	 * Retorna a lista de prestadores baseado no filtro selecionado na busca.
	 * Chamado através do mapping busca-servico
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("buscar-servico")
	public String buscarServicos(HttpServletRequest request, HttpSession session) {
		
		//Pega parametros e realizar busca de prestadores com base no filtro.
		String  [] servicos = null;
		int precoDe = -1;
		int precoAte = -1;
		String bairro = null;
		String delivery = null;
		String autonomoOuPetshop = null;
		
		servicos = request.getParameterValues("servico");
		if(!request.getParameter("precoDe").equals(""))
			precoDe = Integer.parseInt(request.getParameter("precoDe"));
		if(!request.getParameter("precoAte").equals(""))
			precoAte = Integer.parseInt(request.getParameter("precoAte"));
		if(!request.getParameter("bairro").equals(""))
			bairro = request.getParameter("bairro");
		if(!request.getParameter("delivery").equals(""))
			delivery = request.getParameter("delivery");
		if(!request.getParameter("autonomoOuPetshop").equals(""))
			autonomoOuPetshop = request.getParameter("autonomoOuPetshop");
	
		//Realiza busca
		List<Busca> resultadoBuscaPrestador = new PrestadorDAO().buscarPrestador(servicos,precoDe,precoAte,bairro,delivery,autonomoOuPetshop);
		
		session.setAttribute("resultadoBuscaPrestador", resultadoBuscaPrestador);
		
		return "posLogin/usuario/resultadoBusca";
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
	
	// Mapeamento de JSP
	@RequestMapping("agenda-servicoAutonomo")
	public String agendaServicoAutonomo(HttpSession session, HttpServletRequest request) {		
		Prestador prestador = new Prestador();
		prestador.setId_prestador(Long.parseLong(request.getParameter("id")));
		Autonomo autonomo = new AutonomoDAO().getAutonomo(prestador);
		
		session.setAttribute("perfilPrestador", prestador);
		session.setAttribute("perfilPrestadorAutonomo", autonomo);
		
		return "posLogin/usuario/agendaServicoAutonomo";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
}