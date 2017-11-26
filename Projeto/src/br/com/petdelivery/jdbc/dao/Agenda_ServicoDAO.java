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
			String sql = "INSERT INTO Agenda_Servico " + "(id_usuario,id_prestador,id_servico,id_animal,dataInicio,dataFim,horaInicio,horaFim,obsCliente,obsPrestador,delivery,status)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
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
				stmt.setString(9, agendamento.getObsCliente());
				stmt.setString(10, null);
				stmt.setBoolean(11, agendamento.isDelivery());
				stmt.setString(12, "a confirmar");
				
				// executa
				System.out.println("Agenda_ServicoDAO.insert:\n"+stmt.toString());
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void delete (Long id_agendamento) {
			String sql = "DELETE FROM AGENDA_SERVICO WHERE id_agendamento=?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);				
				stmt.setLong(1, id_agendamento);
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
					agendamento.setObsCliente(rs.getString("obsCliente"));
					agendamento.setObsPrestador(rs.getString("obsPrestador"));
					agendamento.setDelivery(rs.getBoolean("delivery"));
					agendamento.setStatus(rs.getString("status"));	
					
					agendamentos.add(agendamento);
				}
				
				stmt.close();
				return agendamentos;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public List<Agenda_Servico> getAgendamentosPrestador (Long id_prestador) {
			String sql = "SELECT * FROM Agenda_Servico WHERE id_prestador=? AND status NOT IN ('cancelado')";	
			List<Agenda_Servico> agendamentos = new ArrayList();				

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);			
				stmt.setLong(1, id_prestador);
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
					agendamento.setObsCliente(rs.getString("obsCliente"));
					agendamento.setObsPrestador(rs.getString("obsPrestador"));
					agendamento.setDelivery(rs.getBoolean("delivery"));
					agendamento.setStatus(rs.getString("status"));
					
					agendamentos.add(agendamento);
				}
				
				stmt.close();
				return agendamentos;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public Agenda_Servico getAgendamentosByID (Long id_agendamento) {
			String sql = "SELECT * FROM Agenda_Servico WHERE id_agendamento=?";	
			Agenda_Servico agendamento = new Agenda_Servico();

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);			
				stmt.setLong(1, id_agendamento);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {				
					agendamento.setId_agendamento(rs.getLong("id_agendamento"));
					agendamento.setId_usuario(rs.getLong("id_usuario"));
					agendamento.setId_servico(rs.getLong("id_servico"));
					agendamento.setId_animal(rs.getLong("id_animal"));
					agendamento.setId_prestador(rs.getLong("id_prestador"));
					agendamento.setDataInicio(rs.getDate("dataInicio"));
					agendamento.setDataFim(rs.getDate("dataFim"));
					agendamento.setHoraInicio(rs.getString("horaInicio"));
					agendamento.setHoraFim(rs.getString("horaFim"));
					agendamento.setObsCliente(rs.getString("obsCliente"));
					agendamento.setObsPrestador(rs.getString("obsPrestador"));
					agendamento.setDelivery(rs.getBoolean("delivery"));
					agendamento.setStatus(rs.getString("status"));
					
					stmt.close();					
					return agendamento;
				}
				
			return agendamento;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void updateServicoByUsuario(Agenda_Servico agendamento) {					
			String sql = "UPDATE AGENDA_SERVICO SET id_servico=?, id_animal=?, dataInicio=?, dataFim=?, horaInicio=?, horaFim=?, obsCliente=?, delivery=?"
					+ "WHERE id_agendamento=?";			
			
			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);

				// seta os valores				
				stmt.setLong(1, agendamento.getId_servico());
				stmt.setLong(2, agendamento.getId_animal());
				stmt.setDate(3, agendamento.getDataInicio());
				stmt.setDate(4, agendamento.getDataFim());
				stmt.setString(5, agendamento.getHoraInicio());
				stmt.setString(6, agendamento.getHoraFim());
				stmt.setString(7, agendamento.getObsCliente());				
				stmt.setBoolean(8, agendamento.isDelivery());
				stmt.setLong(9, agendamento.getId_agendamento());
				
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void updateStatus (String status, String obsPrestador, Long id_agendamento) {
			String sql = "UPDATE AGENDA_SERVICO SET status=?, obsPrestador=? WHERE id_agendamento=?";
			
			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);

				// seta os valores				
				stmt.setString(1, status);
				stmt.setString(2, obsPrestador);
				stmt.setLong(3, id_agendamento);
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
		}
		
		public String getStatus (Long id_agendamento) {
			String sql = "SELECT status FROM AGENDA_SERVICO WHERE id_agendamento=?";
			String status = "";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);			
				stmt.setLong(1, id_agendamento);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					status = rs.getString("id_agendamento");
					stmt.close();
					return status;				
				}
				return status;				
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
		}
		
}
