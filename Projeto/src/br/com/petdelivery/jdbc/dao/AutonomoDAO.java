package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class AutonomoDAO {

	// Conexão com o banco de dados
	private Connection connection;

	public AutonomoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Autonomo autonomo) {
		String sql = "INSERT INTO AUTONOMO " + "(cpf,nome,experiencia,ddd,telefone,rua,numero,complemento,bairro,cep,foto)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, autonomo.getCpf());
			stmt.setString(2, autonomo.getNome());
			stmt.setString(3, autonomo.getExperiencia());
			stmt.setInt(4, autonomo.getDdd());
			stmt.setLong(5, autonomo.getTelefone());
			stmt.setString(6, autonomo.getRua());
			stmt.setInt(7, autonomo.getNumero());
			stmt.setString(8, autonomo.getComplemento());
			stmt.setString(9, autonomo.getBairro());
			stmt.setString(10, autonomo.getCep());
			stmt.setString(11, autonomo.getFoto());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Retorna o Autonomo baseado nas informacoes do Prestador (id e senha)
	 * 
	 * @param prestador
	 * @return
	 */
	public Autonomo getAutonomo (Prestador prestador){
		String sql = "SELECT * FROM AUTONOMO WHERE cpf=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, prestador.getId_prestador());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				Autonomo autonomo = new Autonomo();
								
				autonomo.setCpf(rs.getLong("cpf"));
				autonomo.setNome(rs.getString("nome"));
				autonomo.setExperiencia(rs.getString("experiencia"));
				autonomo.setDdd(rs.getInt("ddd"));
				autonomo.setTelefone(rs.getLong("telefone"));
				autonomo.setRua(rs.getString("rua"));
				autonomo.setNumero(rs.getInt("numero"));
				autonomo.setComplemento(rs.getString("complemento"));
				autonomo.setBairro(rs.getString("bairro"));
				autonomo.setCep(rs.getString("cep"));
				autonomo.setFoto(rs.getString("foto"));
				
				return autonomo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void update(Autonomo autonomo) {
		String sql = "UPDATE AUTONOMO SET nome=?, experiencia=?, ddd=?, telefone=?, rua=?, numero=?, complemento=?, cep=?, bairro=?, foto=? "
				+ "WHERE cpf=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setString(1, autonomo.getNome());
			stmt.setString(2, autonomo.getExperiencia());
			stmt.setInt(3, autonomo.getDdd());
			stmt.setLong(4, autonomo.getTelefone());
			stmt.setString(5, autonomo.getRua());
			stmt.setInt(6, autonomo.getNumero());
			stmt.setString(7, autonomo.getComplemento());
			stmt.setString(8, autonomo.getCep());
			stmt.setString(9, autonomo.getBairro());
			stmt.setString(10, autonomo.getFoto());
			stmt.setLong(11, autonomo.getCpf());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getNomeById (Long cpf) {
		String sql = "SELECT nome FROM AUTONOMO WHERE cpf=?";
		String nome = "";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, cpf);
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
