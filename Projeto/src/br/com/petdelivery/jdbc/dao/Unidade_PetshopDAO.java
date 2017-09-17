package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Unidade_Petshop;

public class Unidade_PetshopDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public Unidade_PetshopDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Unidade_Petshop unidade_petshop) {
		String sql = "INSERT INTO UNIDADE_PETSHOP " + "(id_unidade,cnpj,nome,ddd,telefone,rua,numero,complemento,bairro)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, unidade_petshop.getId_unidade());
			stmt.setLong(2, unidade_petshop.getCnpj());
			stmt.setString(3, unidade_petshop.getNome());
			stmt.setInt(4, unidade_petshop.getDdd());
			stmt.setLong(5, unidade_petshop.getTelefone());
			stmt.setString(6, unidade_petshop.getRua());
			stmt.setInt(7, unidade_petshop.getNumero());
			stmt.setString(8, unidade_petshop.getComplemento());
			stmt.setString(9, unidade_petshop.getBairro());			

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

