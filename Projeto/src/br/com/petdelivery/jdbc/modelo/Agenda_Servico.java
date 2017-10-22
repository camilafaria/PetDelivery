package br.com.petdelivery.jdbc.modelo;

import java.sql.Date;

public class Agenda_Servico {
	
	private Long id_agendamento;
	private Long id_usuario;
	private Long id_prestador;
	private Long id_servico;
	private Long id_animal;
	private Date datahora;
	private String observacao;
	
	public Long getId_agendamento() {
		return id_agendamento;
	}
	public void setId_agendamento(Long id_agendamento) {
		this.id_agendamento = id_agendamento;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Long getId_prestador() {
		return id_prestador;
	}
	public void setId_prestador(Long id_prestador) {
		this.id_prestador = id_prestador;
	}
	public Long getId_servico() {
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}
	public Long getId_animal() {
		return id_animal;
	}
	public void setId_animal(Long id_animal) {
		this.id_animal = id_animal;
	}
	public Date getDatahora() {
		return datahora;
	}
	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
