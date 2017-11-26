package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Animal;
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
		
		public String getTipoById(Long tipo_animal) {
			String sql = "SELECT nome FROM TIPO_ANIMAL WHERE id_tipo=?";
			String tipo;				

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);			
				stmt.setLong(1, tipo_animal);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					tipo = rs.getString("nome");
					stmt.close();
					return tipo;
				}
				
				return "";
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public List<Tipo_Animal> getTiposAnimal() {
			String sql = "SELECT * FROM TIPO_ANIMAL";
			List<Tipo_Animal> tipos = new ArrayList();				

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);			
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					Tipo_Animal tipo = new Tipo_Animal();
					tipo.setId_tipo(rs.getLong("id_tipo"));
					tipo.setNome(rs.getString("nome"));
					tipos.add(tipo);
				}

				stmt.close();
				
				return tipos;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
