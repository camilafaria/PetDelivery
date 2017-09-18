package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Animal> getAnimalUsuario(Long id_usuario) {
		String sql = "SELECT * FROM ANIMAL WHERE id_usuario=?";
		List<Animal> animais = new ArrayList();				

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, id_usuario);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Animal animal = new Animal();
				animal.setId_animal(rs.getLong("id_animal"));
				animal.setId_usuario(rs.getLong("id_usuario"));
				animal.setId_raca(rs.getLong("id_raca"));
				animal.setNome(rs.getString("nome"));
				animal.setGenero(rs.getString("genero"));
				animal.setPorte(rs.getString("porte"));
				animal.setPedigree(rs.getBoolean("pedigree"));
				animal.setComportamento(rs.getString("comportamento"));
				animal.setVacinas(rs.getString("vacinas"));				
				
				animais.add(animal);
			}

			stmt.close();
			
			return animais;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
