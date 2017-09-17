package br.com.petdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeUsuarioController {

	//Mapeamento de JSP
	@RequestMapping("home")
	public String index() {
		return "posLogin/homeUsuario";
	}
}
