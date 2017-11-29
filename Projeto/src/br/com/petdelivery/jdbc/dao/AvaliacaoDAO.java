package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Avaliacao;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class AvaliacaoDAO {

	// Conexão com o banco de dados
	private Connection connection;

	public AvaliacaoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Avaliacao avaliacao) {
		String sql = "INSERT INTO AVALIACAO " + "(id_prestador,cpf,nota)"
				+ " VALUES (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, avaliacao.getId_prestador());
			stmt.setLong(2, avaliacao.getCpf());
			stmt.setInt(3, avaliacao.getNota());			

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Avaliacao avaliacao) {
		String sql = "UPDATE AVALIACAO SET nota=? "
				+ "WHERE id_prestador=? and cpf=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setInt(1, avaliacao.getNota());
			stmt.setLong(2, avaliacao.getId_prestador());
			stmt.setLong(3, avaliacao.getCpf());
			
			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public float getAvaliacao (Long id_usuario) {
		String sql = "SELECT nota FROM AVALIACAO WHERE cpf=?";
		int nota = -1;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, id_usuario);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				nota = rs.getInt("nota");
				stmt.close();
				return nota;
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		System.out.println("Passei por aqui e é -1");
		return -1;
	}
}