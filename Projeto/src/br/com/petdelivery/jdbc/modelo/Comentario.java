package br.com.petdelivery.jdbc.modelo;

public class Comentario {
	
	private Long id_comentario;
	private Long id_prestador;
	private Long cpf;
	private String comentario;
	
	public Long getId_comentario() {
		return id_comentario;
	}
	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}
	public Long getId_prestador() {
		return id_prestador;
	}
	public void setId_prestador(Long id_prestador) {
		this.id_prestador = id_prestador;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}	
}