package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class UsuarioDAO {

	// Conexão com o banco de dados
	private Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Usuario usuario) {
		String sql = "INSERT INTO USUARIO " + "(cpf,nome,ddd,telefone,rua,numero,complemento,bairro,cep,email,senha)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, usuario.getCpf());
			stmt.setString(2, usuario.getNome());
			stmt.setInt(3, usuario.getDdd());
			stmt.setLong(4, usuario.getTelefone());
			stmt.setString(5, usuario.getRua());
			stmt.setInt(6, usuario.getNumero());
			stmt.setString(7, usuario.getComplemento());
			stmt.setString(8, usuario.getBairro());
			stmt.setString(9, usuario.getCep());
			stmt.setString(10, usuario.getEmail());
			stmt.setString(11, usuario.getSenha());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Usuario usuario) {
		String sql = "UPDATE USUARIO SET nome=?, ddd=?, telefone=?, rua=?, numero=?, complemento=?, bairro=?, cep=?, email=?, senha=? "
				+ "WHERE cpf=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getDdd());
			stmt.setLong(3, usuario.getTelefone());
			stmt.setString(4, usuario.getRua());
			stmt.setInt(5, usuario.getNumero());
			stmt.setString(6, usuario.getComplemento());
			stmt.setString(7, usuario.getBairro());
			stmt.setString(8, usuario.getCep());
			stmt.setString(9, usuario.getEmail());
			stmt.setString(10, usuario.getSenha());
			stmt.setLong(11, usuario.getCpf());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getLista() {
		String sql = "SELECT * FROM USUARIO";
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCpf(rs.getLong("cpf"));
				usuario.setNome(rs.getString("nome"));
				usuario.setDdd(rs.getInt("ddd"));
				usuario.setTelefone(rs.getLong("telefone"));
				usuario.setRua(rs.getString("rua"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setComplemento(rs.getString("complemento"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCep(rs.getString("cep"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));

				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return usuarios;
	}

	public List<Usuario> getAllUsuarios() {

		String sql = "SELECT * FROM USUARIO";
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCpf(rs.getLong("cpf"));
				usuario.setNome(rs.getString("nome"));
				usuario.setDdd(rs.getInt("ddd"));
				usuario.setTelefone(rs.getLong("telefone"));
				usuario.setRua(rs.getString("rua"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setComplemento(rs.getString("complemento"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCep(rs.getString("cep"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));

				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return usuarios;
	}

	/**
	 * Retorna Usuario se usuario passado por parametro existir baseado no email e senha
	 * 
	 * @param usr
	 * @return
	 */
	public Usuario existeUsuario(Usuario usuario) {

		String sql = "SELECT * FROM USUARIO WHERE email=? and senha=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				usuario.setCpf(rs.getLong("cpf"));
				usuario.setNome(rs.getString("nome"));
				usuario.setDdd(rs.getInt("ddd"));
				usuario.setTelefone(rs.getLong("telefone"));
				usuario.setRua(rs.getString("rua"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setComplemento(rs.getString("complemento"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCep(rs.getString("cep"));
				//usuario.setEmail(rs.getString("email"));
				//usuario.setSenha(rs.getString("Senha"));
				
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
