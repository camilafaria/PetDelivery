package br.com.petdelivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petdelivery.jdbc.dao.AnimalDAO;
import br.com.petdelivery.jdbc.dao.AutonomoDAO;
import br.com.petdelivery.jdbc.dao.PrestadorDAO;
import br.com.petdelivery.jdbc.dao.Servico_AutonomoDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Servico_Autonomo;
import br.com.petdelivery.jdbc.modelo.Usuario;

@Controller
public class HomePrestadorController {

	// Mapeamento de JSP
	@RequestMapping("homeAutonomo")
	public String indexAutonomo(HttpServletRequest request) {
		return "posLogin/prestador/autonomo/home";
	}
	
	@RequestMapping("homePrestador")
	public String indexPetshop(HttpServletRequest request, HttpSession session) {
		return "posLogin/prestador/petshop/home";
	}

	@RequestMapping("cadastro-servico-autonomo")
	public String cadastraServicoAutonomo(HttpSession session) {
		return "posLogin/prestador/autonomo/cadastraServicoAutonomo";	
	}
	
	@RequestMapping("cadastro-servico-petshop")
	public String cadastraServicoPetshop(HttpSession session) {
		return "posLogin/prestador/petshop/cadastraServicoPetshop";	
	}	
	
	@RequestMapping("servicosAutonomo")
	public String servicoAutonomo(HttpSession session) {
		return "posLogin/prestador/autonomo/meusServicos";	
	}
	
	@RequestMapping("insereServicoAutonomo")
	public String adicionaServicoAutonomo(Servico_Autonomo servico, HttpSession session) {
		new Servico_AutonomoDAO().insert(servico);			
		session.setAttribute("servicoCadastrado", true);
		return "posLogin/prestador/autonomo/meusServicos";
	}
	
	@RequestMapping("configContaAutonomo")
	public String configuraContaAutonomo(HttpSession session) {
		return "posLogin/prestador/autonomo/configConta";	
	}
	
	@RequestMapping("update-autonomo")
	public String atualizarAutonomo(Autonomo autonomo, HttpSession session, HttpServletRequest request) {
		new AutonomoDAO().update(autonomo);
		
		Prestador prestador = new Prestador();
		prestador.setId_prestador(Long.parseLong(request.getParameter("cpf")));
		prestador.setEmail(request.getParameter("email"));
		prestador.setSenha(request.getParameter("senha"));		
		new PrestadorDAO().update(prestador);
		
		session.setAttribute("usuarioAtualizado", true);
		
		return "posLogin/prestador/autonomo/home"; 
	}
}
