package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Raca_Animal;

public class Raca_AnimalDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public Raca_AnimalDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Raca_Animal raca_animal) {
		String sql = "INSERT INTO RACA_ANIMAL " + "(id_raca,id_tipo,nome)"
				+ " VALUES (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, raca_animal.getId_raca());
			stmt.setLong(2, raca_animal.getId_tipo());
			stmt.setString(3, raca_animal.getNome());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
