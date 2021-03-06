package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Raca_Animal;

public class Raca_AnimalDAO {
	
	// Conex�o com o banco de dados
	private Connection connection;

	public Raca_AnimalDAO() {
		this.connection = new ConnectionFactory().getConnection();		
	}

	public void insert(Raca_Animal raca_animal) {
		String sql = "INSERT INTO RACA_ANIMAL " + "(id_raca,id_tipo,nome)"
				+ " VALUES (?,?,?)";

		try {
			// prepared statement para inser��o
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
	
	public List<Raca_Animal> getRacasByTipo(Long tipo_animal) {
		String sql = "SELECT * FROM RACA_ANIMAL WHERE id_tipo=?";
		List<Raca_Animal> racas = new ArrayList();				

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, tipo_animal);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Raca_Animal raca = new Raca_Animal();
				raca.setId_raca(rs.getLong("id_raca"));
				raca.setId_tipo(rs.getLong("id_tipo"));
				raca.setNome(rs.getString("nome"));
				
				racas.add(raca);
			}

			stmt.close();
			
			return racas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getRacaById(Long raca_animal) {
		String sql = "SELECT nome FROM RACA_ANIMAL WHERE id_raca=?";
		String raca;				

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, raca_animal);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				raca = rs.getString("nome");
				stmt.close();
				return raca;
			}
			
			return "";
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Long getTipoByRaca(Long raca_animal) {
		String sql = "SELECT id_tipo FROM RACA_ANIMAL WHERE id_raca=?";
		Long id_tipo;				

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, raca_animal);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				id_tipo = rs.getLong("id_tipo");
				stmt.close();				
				return id_tipo;
			}
			
			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
