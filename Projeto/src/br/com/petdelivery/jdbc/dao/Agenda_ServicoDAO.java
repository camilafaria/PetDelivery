package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Agenda_Servico;

public class Agenda_ServicoDAO {
	
	// Conexão com o banco de dados
		private Connection connection;

		public Agenda_ServicoDAO() {
			this.connection = new ConnectionFactory().getConnection();
		}

		public void insert(Agenda_Servico agendamento) {					
			String sql = "INSERT INTO Agenda_Servico " + "(id_usuario,id_prestador,id_servico,id_animal,dataInicio,dataFim,horaInicio,horaFim,observacao)"
							+ " VALUES (?,?,?,?,?,?,?,?,?)";
			
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
				stmt.setTime(7, agendamento.getHoraInicio());
				stmt.setTime(8, agendamento.getHoraFim());
				stmt.setString(9, agendamento.getObservacao());
				
				// executa
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

}
