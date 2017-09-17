package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Servico_Petshop;

public class Servico_PetshopDAO {
	
	// Conexão com o banco de dados
		private Connection connection;

		public Servico_PetshopDAO() {
			this.connection = new ConnectionFactory().getConnection();
		}

		public void insert(Servico_Petshop servico_petshop) {
			String sql = "INSER INTO SERVICO_PETSHOP " + "(id_servico,cnpj,id_unidade,preco,condicoes,delivery)"
					+ " VALUES (?,?,?,?,?,?)";

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);

				// seta os valores			
				stmt.setLong(1, servico_petshop.getId_servico());
				stmt.setLong(2, servico_petshop.getCnpj());
				stmt.setLong(3, servico_petshop.getId_unidade());
				stmt.setFloat(4, servico_petshop.getPreco());
				stmt.setString(5, servico_petshop.getCondicoes());
				stmt.setBoolean(6,servico_petshop.getDelivery());
								
				// executa
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

}
