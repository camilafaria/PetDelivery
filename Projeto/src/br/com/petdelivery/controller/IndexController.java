package br.com.petdelivery.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.petdelivery.jdbc.dao.AutonomoDAO;
import br.com.petdelivery.jdbc.dao.PetshopDAO;
import br.com.petdelivery.jdbc.dao.PrestadorDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Petshop;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Usuario;

@Controller
public class IndexController {

	// Mapeamento de JSP
	@RequestMapping(value = { "/", "index" })
	public String index() {
		return "index";
	}

	@RequestMapping("adiciona-usuario")
	public String registrarUsuario() {
		return "usuario/adiciona";
	}

	@RequestMapping("adiciona-prestador-autonomo")
	public String registrarAutonomo() {
		return "usuario/adiciona-prestador-autonomo";
	}

	@RequestMapping("adiciona-prestador-petshop")
	public String registrarPetshop() {
		return "usuario/adiciona-prestador-petshop";
	}

	@RequestMapping("lista-usuario")
	public String listar() {
		return "usuario/lista";
	}

	// Recebem chamada dos Forms

	/**
	 * Cria um novo usuario e redireciona para o login
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping("insert-usuario")
	public String adicionaUsuario(Usuario usuario, HttpSession session) {
		new UsuarioDAO().insert(usuario);
		// Adiciona o prestador ao session e manda par ao login
		session.setAttribute("usuarioCriado", true);
		return "usuario/login";
	}

	/**
	 * Cria um novo prestador autonomo e redireciona para o login
	 * 
	 * @param prestador
	 * @param autonomo
	 * @param session
	 * @return
	 */
	@RequestMapping("insert-prestador-autonomo")
	public String adicionaUsuarioPrestadorAutonomo(Prestador prestador, Autonomo autonomo, HttpSession session) {
		/*
		 * System.out.println("Prestador");
		 * System.out.println(prestador.getEmail());
		 * System.out.println(prestador.getSenha());
		 * System.out.println("Autonomo");
		 * System.out.println(autonomo.getNome());
		 * System.out.println(autonomo.getExperiencia());
		 */

		// Instancia variaveis de prestador
		prestador.setId_prestador(autonomo.getCpf());
		prestador.setSomaNota(0);
		prestador.setSomaQnt(0);

		// Insere no banco
		new PrestadorDAO().insert(prestador);
		new AutonomoDAO().insert(autonomo);

		System.out.println("Prestador autonomo CPF: " + autonomo.getCpf() + "inser");

		// Adiciona o prestador ao session e manda par ao login
		session.setAttribute("usuarioCriado", true);

		return "usuario/login";
	}

	/**
	 * Cria um novo Petshop e redireciona para o login
	 * 
	 * @param prestador
	 * @param petshop
	 * @param session
	 * @return
	 * @throws ServletException 
	 * @throws IOException 
	 */
	@RequestMapping("insert-prestador-petshop")
	public String adicionaUsuarioPrestadorPetshop(Prestador prestador, Petshop petshop,@RequestParam("logotipo") MultipartFile logotipo, HttpSession session) throws IOException, ServletException {

		// Instancia variaveis de prestador
		prestador.setId_prestador(petshop.getCnpj());
		prestador.setSomaNota(0);
		prestador.setSomaQnt(0);
		
		//Transforma foto em byte
		InputStream inputStream = null; // input stream of the upload file
        
       if (!logotipo.isEmpty()) {
            // obtains input stream of the upload file
            petshop.setLogotipo(logotipo.getBytes());
        }
        
		// Insere no banco
		new PrestadorDAO().insert(prestador);
		new PetshopDAO().insert(petshop);

		// Adiciona o prestador ao session e manda par ao login
		session.setAttribute("usuarioCriado", true);

		// TODO:Adicionar mapeamento para o poslogin
		return "usuario/login";
	}
	
	//Metodos auxiliares
	
}
