package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Animal;
import br.com.petdelivery.jdbc.modelo.Servico;
import br.com.petdelivery.jdbc.modelo.Servico_Autonomo;

public class Servico_AutonomoDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public Servico_AutonomoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Servico_Autonomo servico_autonomo) {
		String sql = "INSERT INTO SERVICO_AUTONOMO " + "(id_servico,cpf,preco,condicoes,delivery)"
				+ " VALUES (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setLong(1, servico_autonomo.getId_servico());
			stmt.setLong(2, servico_autonomo.getCpf());
			stmt.setDouble(3, servico_autonomo.getPreco());
			stmt.setString(4, servico_autonomo.getCondicoes());
			stmt.setBoolean(5,servico_autonomo.getDelivery());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Servico_Autonomo> getServico (Long cpf) {
		String sql = "SELECT * FROM Servico_Autonomo WHERE cpf=?";
		List<Servico_Autonomo> servicos = new ArrayList();				

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Servico_Autonomo servico = new Servico_Autonomo();
				servico.setId_servicoAutonomo(rs.getLong("id_servicoAutonomo"));
				servico.setId_servico(rs.getLong("id_servico"));
				servico.setCpf(rs.getLong("cpf"));
				servico.setPreco(rs.getDouble("preco"));
				servico.setCondicoes(rs.getString("condicoes"));
				servico.setDelivery(rs.getBoolean("delivery"));
				
				servicos.add(servico);
			}

			stmt.close();
			
			return servicos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean acceptsDelivery (Long cpf, Long id_servico) {
		String sql = "SELECT delivery FROM Servico_Autonomo WHERE cpf=? and id_servico=?";
		int delivery;
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.setLong(1, cpf);
			stmt.setLong(2, id_servico);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				delivery = rs.getInt("delivery");
				stmt.close();				
				if(delivery==0)
					return true;
				else
					return false;
			}		
			
			return false;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
