package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Servico_Autonomo;
import br.com.petdelivery.jdbc.modelo.Unidade_Petshop;

public class Unidade_PetshopDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public Unidade_PetshopDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Unidade_Petshop unidade_petshop) {
		String sql = "INSERT INTO UNIDADE_PETSHOP " + "(cnpj,nome,ddd,telefone,rua,numero,complemento,bairro,cep)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, unidade_petshop.getCnpj());
			stmt.setString(2, unidade_petshop.getNome());
			stmt.setInt(3, unidade_petshop.getDdd());
			stmt.setLong(4, unidade_petshop.getTelefone());
			stmt.setString(5, unidade_petshop.getRua());
			stmt.setInt(6, unidade_petshop.getNumero());
			stmt.setString(7, unidade_petshop.getComplemento());
			stmt.setString(8, unidade_petshop.getBairro());
			stmt.setString(9, unidade_petshop.getCep());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Unidade_Petshop> getUnidadesByCNPJ (Long cnpj) {
		String sql = "SELECT * FROM Unidade_Petshop WHERE cnpj=?";
		List<Unidade_Petshop> unidades = new ArrayList();
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, cnpj);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Unidade_Petshop unidade = new Unidade_Petshop();
				unidade.setId_unidade(rs.getLong("id_unidade"));
				unidade.setCnpj(rs.getLong("cnpj"));
				unidade.setNome(rs.getString("nome"));
				unidade.setDdd(rs.getInt("ddd"));
				unidade.setTelefone(rs.getLong("telefone"));
				unidade.setRua(rs.getString("rua"));
				unidade.setNumero(rs.getInt("numero"));
				unidade.setComplemento(rs.getString("complemento"));
				unidade.setBairro(rs.getString("bairro"));
				unidade.setCep(rs.getString("cep"));
				
				unidades.add(unidade);
			}

			stmt.close();
			
			return unidades;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getUnidadeById (Long id_unidade) {
		String sql = "SELECT nome FROM Unidade_Petshop WHERE id_unidade=?";
		String unidade;				

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, id_unidade);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				unidade = rs.getString("nome");
				stmt.close();
				return unidade;
			}
			
			return "";
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

}

