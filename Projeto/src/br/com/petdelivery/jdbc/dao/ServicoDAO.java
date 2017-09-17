package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Servico;

public class ServicoDAO {

	// Conexão com o banco de dados
	private Connection connection;

	public ServicoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Servico servico) {
		String sql = "INSERT INTO SERVICO " + "(id_servico,nome)"
				+ " VALUES (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, servico.getId_servico());
			stmt.setString(2, servico.getNome());
			
			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
