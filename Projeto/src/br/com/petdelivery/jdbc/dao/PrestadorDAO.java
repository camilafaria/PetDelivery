package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class PrestadorDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public PrestadorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/*
	 * Insere o Prestador retornando o id 
	 * 
	 */
	public void insert(Prestador prestador) {
		String sql = "INSERT INTO PRESTADOR " + "(id_prestador,email,senha,somanota,somaqnt)"
				+ " VALUES (?,?,?,?,?)";
		
		try {
			// prepared statement para inserção
			//PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores			
			stmt.setLong(1, prestador.getId_prestador());
			stmt.setString(2, prestador.getEmail());
			stmt.setString(3, prestador.getSenha());
			stmt.setFloat(4, prestador.getSomaNota());
			stmt.setInt(5, prestador.getSomaQnt());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Prestador existePrestador(Prestador prestador) {

		String sql = "SELECT * FROM PRESTADOR WHERE email=? and senha=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, prestador.getEmail());
			stmt.setString(2, prestador.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				//Seta variaveis faltantes
				prestador.setId_prestador(rs.getLong("id_prestador"));
				prestador.setSomaNota(rs.getFloat("somanota"));
				prestador.setSomaQnt(rs.getInt("somaqnt"));
				
				return prestador;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
