package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Petshop;
import br.com.petdelivery.jdbc.modelo.Prestador;

public class PetshopDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public PetshopDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Petshop petshop) {
		String sql = "INSERT INTO PETSHOP " + "(cnpj,nome,descricao,logotipo)"
				+ " VALUES (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, petshop.getCnpj());
			stmt.setString(2, petshop.getNome());
			stmt.setString(3, petshop.getDescricao());
			stmt.setBytes(4, petshop.getLogotipo());			

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Retorna o Petshop baseado nas informacoes do Prestador (id e senha)
	 * 
	 * @param prestador
	 * @return
	 */
	public Petshop getPetshop (Prestador prestador){
		String sql = "SELECT * FROM PETSHOP WHERE cnpj=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, prestador.getId_prestador());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				Petshop autonomo = new Petshop();
			    
				autonomo.setCnpj(rs.getLong("cnpj"));
				autonomo.setNome(rs.getString("nome"));
				autonomo.setDescricao(rs.getString("descricao"));
				autonomo.setLogotipo(rs.getBytes("logotipo"));
				
				return autonomo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(Petshop petshop) {
		String sql = "UPDATE PETSHOP SET nome=?, descricao=?"
				+ "WHERE cnpj=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setString(1, petshop.getNome());
			stmt.setString(2, petshop.getDescricao());
			stmt.setLong(3, petshop.getCnpj());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getNomeById (Long cnpj) {
		String sql = "SELECT nome FROM PETSHOP WHERE cnpj=?";
		String nome = "";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, cnpj);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				nome = rs.getString("nome");
				stmt.close();
				return nome;
			}
			
			return nome;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
