package br.com.petdelivery.jdbc.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.dao.Raca_AnimalDAO;

public class TestaRaca_Animal {
	
	public static void main (String[] args) {
		
		/*Raca_Animal raca_animal = new Raca_Animal();
		
		raca_animal.setId_raca(1L);
		raca_animal.setId_tipo(1L);
		raca_animal.setNome("Pitbull");
		
		Raca_AnimalDAO raca_animaldao = new Raca_AnimalDAO();
		raca_animaldao.insert(raca_animal);*/		
		
		List<String> racas = new ArrayList();
		Raca_AnimalDAO raca_animaldao = new Raca_AnimalDAO();
		
		racas = raca_animaldao.selectRacaByTipo(1L);
		
		for (int i = 0; i < racas.size(); i++) {
			String raca = racas.get(i);
			System.out.println("Raca " + raca + " foi adicionado");
		}				
	}

}