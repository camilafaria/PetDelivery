package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Animal;
import br.com.petdelivery.jdbc.modelo.Avaliacao;
import br.com.petdelivery.jdbc.modelo.Comentario;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class ComentarioDAO {

	// Conexão com o banco de dados
	private Connection connection;

	public ComentarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Comentario comentario) {
		String sql = "INSERT INTO COMENTARIO " + "(id_prestador,cpf,comentario)"
				+ " VALUES (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, comentario.getId_prestador());
			stmt.setLong(2, comentario.getCpf());
			stmt.setString(3, comentario.getComentario());			

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Comentario comentario) {
		String sql = "UPDATE COMENTARIO SET comentario=? "
				+ "WHERE id_comentario=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setString(1, comentario.getComentario());
			stmt.setLong(2, comentario.getId_comentario());			
			
			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Comentario comentario) {
		String sql = "DELETE FROM COMENTARIO"
				+ "WHERE id_comentario=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores		
			stmt.setLong(1, comentario.getId_comentario());			
			
			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Comentario> getComentsByIdPrestador(Long id_prestador) {
		String sql = "SELECT * FROM COMENTARIO WHERE id_prestador=?";
		List<Comentario> comentarios = new ArrayList();
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id_prestador);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setId_comentario(rs.getLong("id_comentario"));
				comentario.setId_prestador(rs.getLong("id_prestador"));
				comentario.setCpf(rs.getLong("cpf"));
				comentario.setComentario(rs.getString("comentario"));
							
				comentarios.add(comentario);
			}

			stmt.close();
			
			return comentarios;		

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}