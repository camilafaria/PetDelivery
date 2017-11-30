package br.com.petdelivery.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.petdelivery.jdbc.dao.Agenda_ServicoDAO;
import br.com.petdelivery.jdbc.dao.AnimalDAO;
import br.com.petdelivery.jdbc.dao.AvaliacaoDAO;
import br.com.petdelivery.jdbc.dao.ComentarioDAO;
import br.com.petdelivery.jdbc.dao.AutonomoDAO;
import br.com.petdelivery.jdbc.dao.PrestadorDAO;
import br.com.petdelivery.jdbc.dao.ServicoDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Agenda_Servico;
import br.com.petdelivery.jdbc.modelo.Animal;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Avaliacao;
import br.com.petdelivery.jdbc.modelo.Busca;
import br.com.petdelivery.jdbc.modelo.Comentario;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Usuario;

@Controller
public class HomeUsuarioController {

	// Mapeamento de JSP
	@RequestMapping("test")
	public String test(HttpServletRequest request) {
		return "test";
	}

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
	@RequestMapping(value = "/inserePet", method = RequestMethod.POST)
	public String adicionaPet(Animal animal, HttpSession session, @RequestParam CommonsMultipartFile file) {
		// Tratativa de foto
		String path = HelperController.getProperty("fotos.dir");
		new File(path).mkdirs();
		String filename = "";
		// Get file extension
		if (!file.isEmpty()) {
			String extension = new StringBuilder().append(file.getOriginalFilename()).reverse().toString();
			extension = extension.substring(0, extension.indexOf("."));
			extension = new StringBuilder().append(extension).reverse().toString();

			filename = "" + animal.getId_usuario() + "_" + animal.getNome() + "." + extension;
			System.out.println("Adicionando imagem do animal " + path + " " + filename);
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

		animal.setFoto(filename);

		new AnimalDAO().insert(animal);
		session.setAttribute("animalCriado", true);

		return "redirect:pets";
	}

	// Visualiza página do Prestador Autonomo
	@RequestMapping("visualiza-autonomo")
	public String vizualizaAutonomo(HttpServletRequest request, HttpSession session) {
		Prestador prestador = new Prestador();
		prestador = new PrestadorDAO().getPrestadorbyId(Long.parseLong(request.getParameter("id")));
		// corrige nota caso seja 0
		double nota = 0;

		if (prestador.getSomaNota() == 0) {
			nota = 0;
		} else {
			nota = prestador.getSomaNota() / prestador.getSomaQnt();
		}
		Autonomo autonomo = new AutonomoDAO().getAutonomo(prestador);
		DecimalFormat formatter = new DecimalFormat("#.00");
		String notaAjustada = formatter.format(nota);

		session.setAttribute("perfilPrestador", prestador);
		session.setAttribute("perfilPrestador_nota", notaAjustada);
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

		// Pega parametros e realizar busca de prestadores com base no filtro.
		String[] servicos = null;
		int precoDe = -1;
		int precoAte = -1;
		String bairro = null;
		String delivery = null;
		String autonomoOuPetshop = null;

		servicos = request.getParameterValues("servico");
		if (!request.getParameter("precoDe").equals(""))
			precoDe = Integer.parseInt(request.getParameter("precoDe"));
		if (!request.getParameter("precoAte").equals(""))
			precoAte = Integer.parseInt(request.getParameter("precoAte"));
		if (!request.getParameter("bairro").equals(""))
			bairro = request.getParameter("bairro");
		if (!request.getParameter("delivery").equals(""))
			delivery = request.getParameter("delivery");
		if (!request.getParameter("autonomoOuPetshop").equals(""))
			autonomoOuPetshop = request.getParameter("autonomoOuPetshop");

		// Realiza busca
		List<Busca> resultadoBuscaPrestador = new PrestadorDAO().buscarPrestador(servicos, precoDe, precoAte, bairro,
				delivery, autonomoOuPetshop);

		session.setAttribute("resultadoBuscaPrestador", resultadoBuscaPrestador);

		return "posLogin/usuario/resultadoBusca";
	}

	@RequestMapping("avaliar-PrestadorAutonomo")
	public String avaliarPrestadorAutonomo(HttpServletRequest request, HttpSession session) {
		// System.out.println("Prestador CPF="+request.getParameter("id"));		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId_prestador(Long.parseLong(request.getParameter("id_prestador")));
		avaliacao.setCpf(Long.parseLong(request.getParameter("id_usuario")));
		avaliacao.setNota(Integer.parseInt(request.getParameter("nota")));		
		new AvaliacaoDAO().insert(avaliacao);		

		Prestador prestador = new PrestadorDAO().buscaPrestadorById(Long.parseLong(request.getParameter("id_prestador")));
		new PrestadorDAO().atribuiNovaNota(prestador, Integer.parseInt(request.getParameter("nota")));

		return "posLogin/usuario/visualizaPerfilAutonomo";
	}

	@RequestMapping("editarAvaliacao-PrestadorAutonomo")
	public String updateAvaliacaoPrestadorAutonomo(HttpServletRequest request, HttpSession session) {
		// System.out.println("Prestador CPF="+request.getParameter("id"));		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId_prestador(Long.parseLong(request.getParameter("id_prestador")));
		avaliacao.setCpf(Long.parseLong(request.getParameter("id_usuario")));
		avaliacao.setNota(Integer.parseInt(request.getParameter("nota")));	
		new AvaliacaoDAO().update(avaliacao);

		Prestador prestador = new PrestadorDAO().buscaPrestadorById(Long.parseLong(request.getParameter("id_prestador")));
		new PrestadorDAO().atribuiNovaNota(prestador, Integer.parseInt(request.getParameter("nota")));

		return "posLogin/usuario/visualizaPerfilAutonomo";
	}

	@RequestMapping("insereComentario")
	public String insertComentario(HttpServletRequest request, HttpSession session) {
		// System.out.println("Prestador CPF="+request.getParameter("id"));		
		Comentario comentario = new Comentario();
		comentario.setId_prestador(Long.parseLong(request.getParameter("id_prestador")));
		comentario.setCpf(Long.parseLong(request.getParameter("id_usuario")));
		comentario.setComentario(request.getParameter("comentario"));		

		new ComentarioDAO().insert(comentario);		
		return "posLogin/usuario/visualizaPerfilAutonomo";
	}

	@RequestMapping("configConta")
	public String configConta(HttpServletRequest request) {
		return "posLogin/usuario/configConta";
	}

	// Mapeamento de JSP
	@RequestMapping(value = "update-usuario", method = RequestMethod.POST)
	public String updateUsuario(Usuario usuario, HttpSession session, @RequestParam CommonsMultipartFile file) {
		String path = HelperController.getProperty("fotos.dir");
		new File(path).mkdirs();
		String filename = "";
		// Get file extension
		if (!file.isEmpty()) {
			String extension = new StringBuilder().append(file.getOriginalFilename()).reverse().toString();
			extension = extension.substring(0, extension.indexOf("."));
			extension = new StringBuilder().append(extension).reverse().toString();

			filename = "" + usuario.getCpf() + "." + extension;
			System.out.println("Updating image on " + path + " " + filename);
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
		session.setAttribute("id_servico", request.getParameter("servico"));

		return "posLogin/usuario/agendaServicoAutonomo";
	}

	// Mapeamento de JSP
	@RequestMapping("agendaServico")
	public String confirmaAgendamento(Agenda_Servico agendamento, HttpSession session, HttpServletRequest request) {
		new Agenda_ServicoDAO().insert(agendamento);
		session.setAttribute("agendamentoCadastrado", true);

		return "redirect:home";
	}

	@RequestMapping("visualizaServico")
	public String visualizaAgendamento(HttpSession session, HttpServletRequest request) {
		Agenda_Servico servico = new Agenda_ServicoDAO()
				.getAgendamentosByID(Long.parseLong(request.getParameter("id")));
		session.setAttribute("servicoSelecionado", servico);

		return "posLogin/usuario/visualizaServico";
	}

	@RequestMapping("cancelaServico")
	public String cancelaAgendamento(HttpSession session, HttpServletRequest request) {
		new Agenda_ServicoDAO().delete(Long.parseLong(request.getParameter("id")));
		return "posLogin/usuario/home";
	}

	@RequestMapping("editaServico")
	public String redirecionaEdicaoServico(HttpServletRequest request, HttpSession session) {
		Agenda_Servico agendamento = new Agenda_ServicoDAO()
				.getAgendamentosByID(Long.parseLong((request.getParameter("id"))));
		session.setAttribute("servicoSelecionado", agendamento);
		return "posLogin/usuario/editaServico";
	}

	@RequestMapping("confirmaEdicaoServico")
	public String editaServico (Agenda_Servico agendamento, HttpServletRequest request, HttpSession session) {		
		new Agenda_ServicoDAO().updateStatus("a confirmar", agendamento.getObsPrestador(), agendamento.getId_agendamento());
		new Agenda_ServicoDAO().updateServicoByUsuario(agendamento);

		session.setAttribute("servicoAtualizado", true);
		return "posLogin/usuario/home";
	}

	@RequestMapping("editaPet")
	public String redirecionaEdicaoPet (HttpServletRequest request, HttpSession session) {
		Animal animal = new AnimalDAO().getAnimalRealById(Long.parseLong((request.getParameter("id"))));		
		session.setAttribute("animalSelecionado", animal);
		return "posLogin/usuario/editaPet";
	}

	@RequestMapping(value = "confirmaEdicaoPet", method = RequestMethod.POST)
	public String editaPet (Animal animal, HttpServletRequest request, HttpSession session, 
			@RequestParam CommonsMultipartFile file) {
		// Tratativa de foto
		String path = HelperController.getProperty("fotos.dir");
		new File(path).mkdirs();
		String filename = "";
		// Get file extension
		if (!file.isEmpty()) {
			String extension = new StringBuilder().append(file.getOriginalFilename()).reverse().toString();
			extension = extension.substring(0, extension.indexOf("."));
			extension = new StringBuilder().append(extension).reverse().toString();

			filename = "" + animal.getId_usuario() + "_" + animal.getNome() + "." + extension;
			System.out.println("Adicionando imagem do animal " + path + " " + filename);
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

		animal.setFoto(filename);
		new AnimalDAO().update(animal);		
		session.setAttribute("animalAtualizado", animal);
		return "posLogin/usuario/meusPets";
	}

	@RequestMapping("confirmaExclusaoPet")
	public String excluiPet (HttpServletRequest request, HttpSession session) {
		new Agenda_ServicoDAO().deleteServicoPet(Long.parseLong((request.getParameter("id"))));
		new AnimalDAO().delete(Long.parseLong((request.getParameter("id"))));		
		return "posLogin/usuario/meusPets";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
}