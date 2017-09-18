package br.com.petdelivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petdelivery.jdbc.dao.AutonomoDAO;
import br.com.petdelivery.jdbc.dao.PetshopDAO;
import br.com.petdelivery.jdbc.dao.PrestadorDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Petshop;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Usuario;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String loginForm() {
		return "preLogin/login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpServletRequest request) {
		//Tenta fazer login de usuario
		Usuario usrLogado = new UsuarioDAO().existeUsuario(usuario);		
		if (usrLogado != null) {
			//System.out.println("usuarioLogadoNome=" + usrLogado.getNome());			
			request.getSession().invalidate();
			HttpSession session = request.getSession(true);			
			session.setAttribute("usuarioLogado", usrLogado);
			session.setAttribute("AUTHENTICATED", new Boolean(true));
			//TODO: Alterar o return para a home do posLogin
			return "posLogin/usuario/home";
		}
		
		//Tenta fazer login de prestador
		Prestador prestador = new Prestador();
		prestador.setEmail(usuario.getEmail());
		prestador.setSenha(usuario.getSenha());

		Prestador prestadorLogado = new PrestadorDAO().existePrestador(prestador);
		if (prestadorLogado != null) {
			//Verificar se � autonomo
			Autonomo prestadorAutonomo = new AutonomoDAO().getAutonomo(prestadorLogado);
			if (prestadorAutonomo != null ){
				request.getSession().invalidate();
				HttpSession session = request.getSession(true);					
				session.setAttribute("prestadorAutonomoLogado", prestadorAutonomo);
				session.setAttribute("AUTHENTICATED", new Boolean(true));
				//TODO: Alterar o return para a home do posLogin
				return "posLogin/prestador/home";
			}
			
			//Verificar se � petshop
			Petshop prestadorPetshop = new PetshopDAO().getPetshop(prestadorLogado);
			if (prestadorPetshop != null ){
				request.getSession().invalidate();
				HttpSession session = request.getSession(true);	
				session.setAttribute("prestadorPetshopLogado", prestadorPetshop);
				session.setAttribute("AUTHENTICATED", new Boolean(true));
				//TODO: Alterar o return para a home do posLogin
				return "posLogin/prestador/home";
			}
			//TODO: Alterar o return para a home do posLogin
			return "posLogin/prestador/home";
		}
		return "redirect:login";
	}
}
