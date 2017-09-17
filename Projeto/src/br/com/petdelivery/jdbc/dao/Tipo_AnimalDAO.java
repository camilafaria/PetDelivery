package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Tipo_Animal;

public class Tipo_AnimalDAO {
	
	// Conexão com o banco de dados
		private Connection connection;

		public Tipo_AnimalDAO() {
			this.connection = new ConnectionFactory().getConnection();
		}

		public void insert(Tipo_Animal tipo_animal) {
			String sql = "INSERT INTO TIPO_ANIMAL " + "(id_tipo,nome)"
					+ " VALUES (?,?)";

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);

				// seta os valores			
				stmt.setLong(1, tipo_animal.getId_tipo());
				stmt.setString(2, tipo_animal.getNome());
				
				// executa
				stmt.execute();
				stmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
