package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Servico_Autonomo;

public class Servico_AutonomoDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public Servico_AutonomoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Servico_Autonomo servico_autonomo) {
		String sql = "INSERT INTO SERVICO_AUTONOMO " + "(id_servico,cnpj,preco,condicoes,delivery)"
				+ " VALUES (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, servico_autonomo.getId_servico());
			stmt.setLong(2, servico_autonomo.getCpf());
			stmt.setFloat(3, servico_autonomo.getPreco());
			stmt.setString(4, servico_autonomo.getCondicoes());
			stmt.setBoolean(5,servico_autonomo.getDelivery());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
