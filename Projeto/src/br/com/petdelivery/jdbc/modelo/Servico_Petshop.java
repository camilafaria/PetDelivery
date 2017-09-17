package br.com.petdelivery.jdbc.modelo;

public class Servico_Petshop {
	
	private Long id_servico;
	private Long cnpj;
	private Long id_unidade;
	private float preco;
	private String condicoes;
	private Boolean delivery;
	
	public Long getId_servico() {
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public Long getId_unidade() {
		return id_unidade;
	}
	public void setId_unidade(Long id_unidade) {
		this.id_unidade = id_unidade;
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
