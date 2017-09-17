package br.com.petdelivery.jdbc.teste;

import br.com.petdelivery.jdbc.dao.Raca_AnimalDAO;
import br.com.petdelivery.jdbc.modelo.Raca_Animal;

public class TestaRaca_Animal {
	
	public static void main (String[] args) {
		
		Raca_Animal raca_animal = new Raca_Animal();
		
		raca_animal.setId_raca(1L);
		raca_animal.setId_tipo(1L);
		raca_animal.setNome("Pitbull");
		
		Raca_AnimalDAO raca_animaldao = new Raca_AnimalDAO();
		raca_animaldao.insert(raca_animal);
		
		System.out.println("Raca " + raca_animal.getNome() + " foi adicionado");		
	}

}
