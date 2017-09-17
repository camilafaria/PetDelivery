package br.com.petdelivery.jdbc.modelo;

public class Servico {
	
	private Long id_servico;
	private String nome;
	
	public Long getId_servico() {
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
