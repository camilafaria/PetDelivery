package br.com.petdelivery.jdbc.modelo;

public class Servico_Autonomo {
	
	private Long id_servico;
	private Long cpf;
	private float preco;
	private String condicoes;
	private Boolean delivery;
	
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
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
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
