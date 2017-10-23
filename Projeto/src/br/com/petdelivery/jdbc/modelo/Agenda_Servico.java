package br.com.petdelivery.jdbc.modelo;

import java.sql.Date;
import java.sql.Time;

public class Agenda_Servico {
	
	private Long id_agendamento;
	private Long id_usuario;
	private Long id_prestador;
	private Long id_servico;
	private Long id_animal;
	private Date dataInicio;
	private Date dataFim;
	private String horaInicio;	
	private String horaFim;
	private String observacao;
	private boolean delivery;
	
	public boolean isDelivery() {
		return delivery;
	}
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
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
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
}
