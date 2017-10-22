package br.com.petdelivery.jdbc.modelo;

public class Prestador {
	
	private Long id_prestador;
	private String email;
	private String senha;
	private float somaNota;
	private int somaQnt;
	
	private Autonomo autonomo;
	private Petshop petshop;
	
	public Long getId_prestador() {
		return id_prestador;
	}
	public void setId_prestador(Long id_prestador) {
		this.id_prestador = id_prestador;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public float getSomaNota() {
		return somaNota;
	}
	public void setSomaNota(float somaNota) {
		this.somaNota = somaNota;
	}
	public int getSomaQnt() {
		return somaQnt;
	}
	public void setSomaQnt(int somaQnt) {
		this.somaQnt = somaQnt;
	}
	public Autonomo getAutonomo() {
		return autonomo;
	}
	public void setAutonomo(Autonomo autonomo) {
		this.autonomo = autonomo;
	}
	public Petshop getPetshop() {
		return petshop;
	}
	public void setPetshop(Petshop petshop) {
		this.petshop = petshop;
	}
	
}
