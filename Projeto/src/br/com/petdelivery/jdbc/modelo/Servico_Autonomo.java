package br.com.petdelivery.jdbc.modelo;

public class Servico_Autonomo {	
	private Long id_servicoAutonomo;
	private Long id_servico;
	private Long cpf;
	private double preco;
	private String condicoes;
	private Boolean delivery;
	
	public Long getId_servicoAutonomo() {
		return id_servicoAutonomo;
	}
	public void setId_servicoAutonomo(Long id_servicoAutonomo) {
		this.id_servicoAutonomo = id_servicoAutonomo;
	}
	public Long getId_servico() {
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCondicoes() {
		return condicoes;
	}
	public void setCondicoes(String condicoes) {
		this.condicoes = condicoes;
	}
	public Boolean getDelivery() {
		return delivery;
	}
	public void setDelivery(Boolean delivery) {
		this.delivery = delivery;
	}
}
