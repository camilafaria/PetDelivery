package br.com.petdelivery.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
		return "preLogin/adiciona-usuario";
	}

	@RequestMapping("adiciona-prestador-autonomo")
	public String registrarAutonomo() {
		return "preLogin/adiciona-prestador-autonomo";
	}

	@RequestMapping("adiciona-prestador-petshop")
	public String registrarPetshop() {
		return "preLogin/adiciona-prestador-petshop";
	}

	@RequestMapping("lista-usuario")
	public String listar() {
		return "preLogin/lista";
	}

	// Recebem chamada dos Forms

	/**
	 * Cria um novo usuario e redireciona para o login
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/insert-usuario", method = RequestMethod.POST)
	public String adicionaUsuario(Usuario usuario, HttpSession session, @RequestParam CommonsMultipartFile file) {

		// String path = session.getServletContext().getRealPath("/fotos");
		String path = HelperController.getProperty("fotos.dir");
		new File(path).mkdirs();
		String filename = "";
		// Get file extension
		if (!file.isEmpty()){
			String extension = new StringBuilder().append(file.getOriginalFilename()).reverse().toString();
			extension = extension.substring(0, extension.indexOf("."));
			extension = new StringBuilder().append(extension).reverse().toString();

			filename = "" + usuario.getCpf() + "." + extension;
			System.out.println("Saving image on "+ path + " " + filename);
			try {
				byte barr[] = file.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		usuario.setFoto(filename);
		new UsuarioDAO().insert(usuario);
		// Adiciona o prestador ao session e manda par ao login
		session.setAttribute("usuarioCriado", true);
		return "preLogin/login";
	}

	@RequestMapping(value = "/getImage")
	@ResponseBody
	public byte[] getImage(HttpServletRequest request) throws IOException {
		String rpath = HelperController.getProperty("fotos.dir");
		String imageId = request.getParameter("foto");
		rpath = rpath + "\\" + imageId; // whatever path you used for storing the
										// file
		System.out.println("rpath="+rpath);
		Path path = Paths.get(rpath);
		byte[] data = Files.readAllBytes(path);
		return data;
	}
	
	@RequestMapping("500")
	public String adicionaUsuario(HttpSession session) {
		return "500";
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
	public String adicionaUsuarioPrestadorAutonomo(Prestador prestador, Autonomo autonomo, HttpSession session, @RequestParam CommonsMultipartFile file) {

		// String path = session.getServletContext().getRealPath("/fotos");
		String path = HelperController.getProperty("fotos.dir");
		new File(path).mkdirs();
		String filename = "";
		// Get file extension
		if (!file.isEmpty()){
			String extension = new StringBuilder().append(file.getOriginalFilename()).reverse().toString();
			extension = extension.substring(0, extension.indexOf("."));
			extension = new StringBuilder().append(extension).reverse().toString();
			
			filename = "" + autonomo.getCpf() + "." + extension;
			System.out.println("Saving image on "+ path + " " + filename);
			try {
				byte barr[] = file.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		autonomo.setFoto(filename);		
		prestador.setId_prestador(autonomo.getCpf());
		prestador.setSomaNota(0);
		prestador.setSomaQnt(0);
		prestador.setTipo(0);

		// Insere no banco
		new PrestadorDAO().insert(prestador);
		new AutonomoDAO().insert(autonomo);

		System.out.println("Prestador autonomo CPF: " + autonomo.getCpf() + "inser");

		// Adiciona o prestador ao session e manda par ao login
		session.setAttribute("usuarioCriado", true);

		return "preLogin/login";
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
	public String adicionaUsuarioPrestadorPetshop(Prestador prestador, Petshop petshop, HttpSession session) {

		// Instancia variaveis de prestador
		prestador.setId_prestador(petshop.getCnpj());
		prestador.setSomaNota(0);
		prestador.setSomaQnt(0);
		prestador.setTipo(1);

		/*
		 * //Transforma foto em byte InputStream inputStream = null; // input
		 * stream of the upload file
		 * 
		 * if (!logotipo.isEmpty()) { // obtains input stream of the upload file
		 * petshop.setLogotipo(logotipo.getBytes()); }
		 */

		// Insere no banco
		new PrestadorDAO().insert(prestador);
		new PetshopDAO().insert(petshop);

		// Adiciona o prestador ao session e manda par ao login
		session.setAttribute("usuarioCriado", true);

		// TODO:Adicionar mapeamento para o poslogin
		return "preLogin/login";
	}

	// Metodos auxiliares

}
