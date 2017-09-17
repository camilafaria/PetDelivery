package br.com.petdelivery.jdbc.teste;

import br.com.petdelivery.jdbc.dao.UsuarioDAO;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class TestaUsuario {

	public static void main(String[] args) {
		
		insert();

	}
	
	public static void insert(){
		Usuario user = new Usuario();
		Long a = Long.parseLong("401308292899");
		user.setCpf(a);
		user.setNome("Francisca Silva");
		user.setDdd(11);
		user.setTelefone(123456789);
		user.setRua("Rua 1");
		user.setNumero(2);
		user.setComplemento("Casa 2");
		user.setBairro("Ré");
		user.setEmail("fansilva@hotmail.com");
		user.setSenha("fran123");
		
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.insert(user);
		
		System.out.println("Usuário "+ user.getNome()+" adicionado.");
	}

}