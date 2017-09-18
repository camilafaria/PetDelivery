package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Servico;

public class HelperDAO {

	// Conexão com o banco de dados
	private Connection connection;

	public HelperDAO() {
			this.connection = new ConnectionFactory().getConnection();
		}

	/**
	 * Retorna lista de todos os bairros cadastrados pelos prestadores
	 * 
	 */
	public List<String> getTodosBairros() {
		String sql = "SELECT DISTINCT bairro FROM (SELECT bairro FROM unidade_petshop UNION ALL SELECT bairro FROM autonomo) as TMP";
		try {
			List<String> bairros = new ArrayList();
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// executa
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				bairros.add(rs.getString("bairro"));
			}
			stmt.close();
			return bairros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
