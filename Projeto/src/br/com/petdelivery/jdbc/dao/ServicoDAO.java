package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Servico;
import br.com.petdelivery.jdbc.modelo.Servico_Autonomo;

public class ServicoDAO {

	// Conexão com o banco de dados
	private Connection connection;

	public ServicoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Servico servico) {
		String sql = "INSERT INTO SERVICO " + "(id_servico,nome)" + " VALUES (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, servico.getId_servico());
			stmt.setString(2, servico.getNome());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Servico> getLista() {
		String sql = "SELECT * FROM servico";

		try {
			List<Servico> listaServicos = new ArrayList();
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// executa
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Servico servico = new Servico();
				servico.setId_servico(rs.getLong("id_servico"));
				servico.setNome(rs.getString("nome"));
				listaServicos.add(servico);
			}
			stmt.close();
			return listaServicos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getServicoById (Long id_servico){
		String sql = "SELECT nome FROM Servico WHERE id_servico=?";
		String nome = "";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id_servico);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {				
				nome = rs.getString("nome");	
				stmt.close();
				return nome;
			}
			
			return "";
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}	
}
