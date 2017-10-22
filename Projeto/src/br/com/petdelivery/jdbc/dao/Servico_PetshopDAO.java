package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Servico_Autonomo;
import br.com.petdelivery.jdbc.modelo.Servico_Petshop;

public class Servico_PetshopDAO {
	
	// Conexão com o banco de dados
		private Connection connection;

		public Servico_PetshopDAO() {
			this.connection = new ConnectionFactory().getConnection();
		}

		public void insert(Servico_Petshop servico_petshop) {
			String sql = "INSERT INTO SERVICO_PETSHOP " + "(id_servico,cnpj,id_unidade,preco,condicoes,delivery)"
					+ " VALUES (?,?,?,?,?,?)";

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);

				// seta os valores			
				stmt.setLong(1, servico_petshop.getId_servico());
				stmt.setLong(2, servico_petshop.getCnpj());
				stmt.setLong(3, servico_petshop.getId_unidade());
				stmt.setDouble(4, servico_petshop.getPreco());
				stmt.setString(5, servico_petshop.getCondicoes());
				stmt.setBoolean(6,servico_petshop.getDelivery());
								
				// executa
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public List<Servico_Petshop> getServico (Long cnpj) {
			String sql = "SELECT * FROM Servico_Petshop WHERE cnpj=?";
			List<Servico_Petshop> servicos = new ArrayList();				

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);			
				stmt.setLong(1, cnpj);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					Servico_Petshop servico = new Servico_Petshop();
					servico.setId_servicoPetshop(rs.getLong("id_servicoPetshop"));
					servico.setId_servico(rs.getLong("id_servico"));
					servico.setId_unidade(rs.getLong("id_unidade"));
					servico.setCnpj(rs.getLong("cnpj"));
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
}
