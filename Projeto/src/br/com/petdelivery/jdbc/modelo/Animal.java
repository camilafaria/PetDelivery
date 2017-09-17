package br.com.petdelivery.jdbc.modelo;

public class Animal {
	
	private Long id_animal;
	private Long id_raca;
	private String genero;
	private String porte;
	private Boolean pedigree;
	private String comportamento;
	private String vacinas;
	private byte[] foto;
	
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
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}
