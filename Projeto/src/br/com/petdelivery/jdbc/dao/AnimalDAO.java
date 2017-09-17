package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Animal;

public class AnimalDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public AnimalDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Animal animal) {
		String sql = "INSERT INTO ANIMAL " + "(ID_Ad_animal,id_raca,genero,porte,pedigree,comportamento,vacinas,foto)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, animal.getId_animal());
			stmt.setLong(2, animal.getId_raca());
			stmt.setString(3, animal.getGenero());
			stmt.setString(4, animal.getPorte());
			stmt.setBoolean(5, animal.getPedigree());
			stmt.setString(6, animal.getComportamento());
			stmt.setString(7, animal.getVacinas());
			stmt.setBytes(8, animal.getFoto());			

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
