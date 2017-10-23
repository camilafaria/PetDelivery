package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Agenda_Servico;

public class Agenda_ServicoDAO {
	
	// Conexão com o banco de dados
		private Connection connection;

		public Agenda_ServicoDAO() {
			this.connection = new ConnectionFactory().getConnection();
		}

		public void insert(Agenda_Servico agendamento) {					
			String sql = "INSERT INTO Agenda_Servico " + "(id_usuario,id_prestador,id_servico,id_animal,dataInicio,dataFim,horaInicio,horaFim,observacao,delivery)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);

				// seta os valores				
				stmt.setLong(1, agendamento.getId_usuario());
				stmt.setLong(2, agendamento.getId_prestador());
				stmt.setLong(3, agendamento.getId_servico());
				stmt.setLong(4, agendamento.getId_animal());
				stmt.setDate(5, agendamento.getDataInicio());
				stmt.setDate(6, agendamento.getDataFim());
				stmt.setString(7, agendamento.getHoraInicio());
				stmt.setString(8, agendamento.getHoraFim());
				stmt.setString(9, agendamento.getObservacao());
				stmt.setBoolean(10, agendamento.isDelivery());
				
				// executa
				System.out.println("Agenda_ServicoDAO.insert:\n"+stmt.toString());
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public List<Agenda_Servico> getAgendamentos (Long cpfUsuario) {
			String sql = "SELECT * FROM Agenda_Servico WHERE id_usuario=? and dataInicio >= (SELECT CURDATE());";	
			List<Agenda_Servico> agendamentos = new ArrayList();				

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);			
				stmt.setLong(1, cpfUsuario);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					Agenda_Servico agendamento = new Agenda_Servico();
					agendamento.setId_agendamento(rs.getLong("id_agendamento"));
					agendamento.setId_usuario(rs.getLong("id_usuario"));
					agendamento.setId_servico(rs.getLong("id_servico"));
					agendamento.setId_animal(rs.getLong("id_animal"));
					agendamento.setId_prestador(rs.getLong("id_prestador"));
					agendamento.setDataInicio(rs.getDate("dataInicio"));
					agendamento.setDataFim(rs.getDate("dataFim"));
					agendamento.setHoraInicio(rs.getString("horaInicio"));
					agendamento.setHoraFim(rs.getString("horaFim"));
					agendamento.setObservacao(rs.getString("observacao"));
					agendamento.setDelivery(rs.getBoolean("delivery"));				
					
					agendamentos.add(agendamento);
				}
				
				stmt.close();
				return agendamentos;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
