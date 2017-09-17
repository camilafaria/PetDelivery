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
		String sql = "INSERT INTO ANIMAL " + "(id_raca,id_usuario,nome,genero,porte,pedigree,comportamento,vacinas,foto)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores	
			System.out.println("TESTE " + animal.getGenero());
			stmt.setLong(1, animal.getId_raca());
			stmt.setLong(2, animal.getId_usuario());
			stmt.setString(3, animal.getNome());
			stmt.setString(4, animal.getGenero());
			stmt.setString(5, animal.getPorte());
			stmt.setBoolean(6, animal.getPedigree());
			stmt.setString(7, animal.getComportamento());
			stmt.setString(8, animal.getVacinas());
			stmt.setBytes(9, animal.getFoto());		

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
