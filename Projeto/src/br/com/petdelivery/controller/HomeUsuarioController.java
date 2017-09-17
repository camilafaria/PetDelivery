package br.com.petdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
