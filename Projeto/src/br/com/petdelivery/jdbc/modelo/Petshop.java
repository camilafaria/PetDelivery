package br.com.petdelivery.jdbc.modelo;

public class Petshop {
	
	private Long cnpj;
	private String nome;
	private String descricao;
	private byte[] logotipo;
	
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte[] getLogotipo() {
		return logotipo;
	}
	public void setLogotipo(byte[] logotipo) {
		this.logotipo = logotipo;
	}
}
