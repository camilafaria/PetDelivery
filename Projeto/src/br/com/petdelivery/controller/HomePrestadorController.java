package br.com.petdelivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.petdelivery.jdbc.dao.Agenda_ServicoDAO;
import br.com.petdelivery.jdbc.dao.AnimalDAO;
import br.com.petdelivery.jdbc.dao.AutonomoDAO;
import br.com.petdelivery.jdbc.dao.PetshopDAO;
import br.com.petdelivery.jdbc.dao.PrestadorDAO;
import br.com.petdelivery.jdbc.dao.ServicoDAO;
import br.com.petdelivery.jdbc.dao.Servico_AutonomoDAO;
import br.com.petdelivery.jdbc.dao.Servico_PetshopDAO;
import br.com.petdelivery.jdbc.dao.Unidade_PetshopDAO;
import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Agenda_Servico;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Petshop;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Servico_Autonomo;
import br.com.petdelivery.jdbc.modelo.Servico_Petshop;
import br.com.petdelivery.jdbc.modelo.Unidade_Petshop;
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
	
	@RequestMapping("minhasUnidades")
	public String unidadesPetshop(HttpSession session) {
		return "posLogin/prestador/petshop/minhasUnidades";	
	}
	
	@RequestMapping("cadastraUnidade")
	public String cadastroUnidadePetshop(HttpSession session) {
		return "posLogin/prestador/petshop/cadastraUnidade";
	}
	
	@RequestMapping("cadastro-unidade")
	public String insertUnidade(Unidade_Petshop unidade, HttpSession session) {
		new Unidade_PetshopDAO().insert(unidade);
		return "posLogin/prestador/petshop/minhasUnidades";
	}
	
	@RequestMapping("cadastroServico")
	public String cadastroServico(HttpSession session) {				
		return "posLogin/prestador/petshop/meusServicos";
	}
	
	@RequestMapping("cadastro-servico-petshop")
	public String cadastroServicoPetshop(HttpSession session) {				
		return "posLogin/prestador/petshop/cadastraServicoPetshop";
	}
		
	@RequestMapping("cadastroServicoPetshop")
	public String insertServico(Servico_Petshop servico, HttpSession session) {
		new Servico_PetshopDAO().insert(servico);		
		return "posLogin/prestador/petshop/meusServicos";	
	}	
	
	@RequestMapping("configContaPetshop")
	public String configuraContaPetshop(HttpSession session) {
		return "posLogin/prestador/petshop/configConta";	
	}
	
	@RequestMapping("update-petshop")
	public String atualizarPetshop(Petshop petshop, HttpSession session, HttpServletRequest request) {
		new PetshopDAO().update(petshop);
		
		Prestador prestador = new Prestador();
		prestador.setId_prestador(Long.parseLong(request.getParameter("cnpj")));
		prestador.setEmail(request.getParameter("email"));
		prestador.setSenha(request.getParameter("senha"));		
		new PrestadorDAO().update(prestador);
		
		session.setAttribute("prestadorAtualizado", true);
		
		return "posLogin/prestador/petshop/home"; 
	}
	
	@RequestMapping("agenda")
	public String visualizaAgendaAutonomo(HttpSession session) {
		return "posLogin/prestador/autonomo/agenda";	
	}
	
	@RequestMapping("populaAgenda")
	public @ResponseBody String populaAgendaAutonomo(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		List<Agenda_Servico> agendamentos = new ArrayList();
		agendamentos = new Agenda_ServicoDAO().getAgendamentosPrestador(Long.parseLong(request.getParameter("cpf")));
		
		List<Map<String, Object>> setAgendamentos = new ArrayList<Map<String, Object>>();		
		for (Agenda_Servico agendamento : agendamentos) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", agendamento.getId_agendamento());
			map.put("title", new ServicoDAO().getServicoById(agendamento.getId_servico()) + " " + new AnimalDAO().getAnimalById(agendamento.getId_animal()));
			map.put("start", agendamento.getDataInicio() + " " + agendamento.getHoraInicio());
			map.put("end", agendamento.getDataFim() + " " + agendamento.getHoraFim());
			map.put("url", "visualiza-servico?id=" + agendamento.getId_agendamento());
			map.put("backgroundColor", agendamento.getStatus().compareTo("a confirmar") == 0 ? "#ff4d4d" : "#009999");
			map.put("editable", "false");
			setAgendamentos.add(map);
		}
		
		JSONArray json = new JSONArray();
		json.put(setAgendamentos);
		try {
		    System.err.println(json.toString(2));		    
		} catch (JSONException e) {
		    e.printStackTrace();
		}
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    String jsonString = json.toString();		
	    return jsonString.substring(1, jsonString.length()-1);			
	}
	
	@RequestMapping("visualiza-servico")
	public String visualizaServicoAutonomo (HttpServletRequest request, HttpSession session) {
		Agenda_Servico agendamento = new Agenda_Servico();
		agendamento = new Agenda_ServicoDAO().getAgendamentosByID(Long.parseLong(request.getParameter("id")));
		session.setAttribute("servicoSelecionado", agendamento);
		
		return "posLogin/prestador/autonomo/visualizaServico";
	}
	
	@RequestMapping("updateStatus")
	public String updateStatusServicoAutonomo (HttpServletRequest request, HttpSession session) {
		String status = request.getParameter("status");
		if ( status.compareTo("cancelado") == 0 )
			new Agenda_ServicoDAO().updateStatus(status, request.getParameter("obsPrestador"), Long.parseLong(request.getParameter("id")));
			//new Agenda_ServicoDAO().delete(Long.parseLong(request.getParameter("obsPrestador")));
		else
			new Agenda_ServicoDAO().updateStatus(status, request.getParameter("obsPrestador"), Long.parseLong(request.getParameter("id")));				
		
		return "redirect: agenda";
	}
	
	@RequestMapping("editaServicoAutonomo")
	public String redirecionaEdicaoServico (HttpServletRequest request, HttpSession session) {		
		Servico_Autonomo servico = new Servico_AutonomoDAO().getServicoById(Long.parseLong(request.getParameter("id")));
		session.setAttribute("servicoSelecionado", servico);
		return "posLogin/prestador/autonomo/editaServico";
	}
	
	@RequestMapping("confirmaEdicaoServicoAutonomo")
	public String editaServicoAutonomo (Servico_Autonomo servico, HttpServletRequest request, HttpSession session) {		
		new Servico_AutonomoDAO().update(servico);
		session.setAttribute("servicoAtualizado", servico);
		return "redirect:servicosAutonomo";
	}
	
	@RequestMapping("confirmaExclusaoServicoAutonomo")
	public String excluiServicoAutonomo (HttpServletRequest request, HttpSession session) {		
		new Agenda_ServicoDAO().deleteServicoServico(Long.parseLong(request.getParameter("id")));
		new Servico_AutonomoDAO().delete(Long.parseLong(request.getParameter("id")));		
		return "redirect:servicosAutonomo";
	}
	
}
