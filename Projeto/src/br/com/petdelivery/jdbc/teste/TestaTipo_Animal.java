package br.com.petdelivery.jdbc.teste;

import br.com.petdelivery.jdbc.dao.Tipo_AnimalDAO;
import br.com.petdelivery.jdbc.modelo.Tipo_Animal;

public class TestaTipo_Animal {
	
	public static void main (String[] args) {
		
		Tipo_Animal tipo_animal = new Tipo_Animal();
		
		tipo_animal.setId_tipo(1L);
		tipo_animal.setNome("Cachorro");
		
		Tipo_AnimalDAO typeanimalDao = new Tipo_AnimalDAO();
		typeanimalDao.insert(tipo_animal);
		
		System.out.println("Tipo de Animal "+ tipo_animal.getNome()+" adicionado.");		
	}
}