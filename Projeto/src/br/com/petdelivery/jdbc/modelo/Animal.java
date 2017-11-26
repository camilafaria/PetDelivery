package br.com.petdelivery.jdbc.modelo;

public class Animal {
	
	private Long id_animal;
	private Long id_raca;
	private Long id_usuario;	
	private String nome;	
	private String genero;
	private String porte;
	private Boolean pedigree;
	private String comportamento;
	private String vacinas;
	private String foto;
	
	public Long getId_animal() {
		return id_animal;
	}
	public void setId_animal(Long id_animal) {
		this.id_animal = id_animal;
	}
	public Long getId_raca() {
		return id_raca;
	}
	public void setId_raca(Long id_raca) {
		this.id_raca = id_raca;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
	public Boolean getPedigree() {
		return pedigree;
	}
	public void setPedigree(Boolean pedigree) {
		this.pedigree = pedigree;
	}
	public String getComportamento() {
		return comportamento;
	}
	public void setComportamento(String comportamento) {
		this.comportamento = comportamento;
	}
	public String getVacinas() {
		return vacinas;
	}
	public void setVacinas(String vacinas) {
		this.vacinas = vacinas;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
