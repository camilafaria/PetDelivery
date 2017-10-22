package br.com.petdelivery.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.petdelivery.jdbc.ConnectionFactory;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Busca;
import br.com.petdelivery.jdbc.modelo.Prestador;
import br.com.petdelivery.jdbc.modelo.Usuario;

public class PrestadorDAO {
	
	// Conexão com o banco de dados
	private Connection connection;

	public PrestadorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/*
	 * Insere o Prestador retornando o id 
	 * 
	 */
	public void insert(Prestador prestador) {
		String sql = "INSERT INTO PRESTADOR " + "(id_prestador,email,senha,somanota,somaqnt)"
				+ " VALUES (?,?,?,?,?)";
		
		try {
			// prepared statement para inserção
			//PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores			
			stmt.setLong(1, prestador.getId_prestador());
			stmt.setString(2, prestador.getEmail());
			stmt.setString(3, prestador.getSenha());
			stmt.setFloat(4, prestador.getSomaNota());
			stmt.setInt(5, prestador.getSomaQnt());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Prestador existePrestador(Prestador prestador) {

		String sql = "SELECT * FROM PRESTADOR WHERE email=? and senha=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, prestador.getEmail());
			stmt.setString(2, prestador.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				//Seta variaveis faltantes
				prestador.setId_prestador(rs.getLong("id_prestador"));
				prestador.setSomaNota(rs.getFloat("somanota"));
				prestador.setSomaQnt(rs.getInt("somaqnt"));
				
				return prestador;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Busca> buscarPrestador(String [] servicos, int precoDe, int precoAte, String bairro, String delivery, String autonomoOuPetshop){
		//Busca Prestador autonomo
		//TODO: Busca Prestador PetShop
		List<Busca> prestadores = new ArrayList<Busca>();
		
		boolean aplicarFiltro = false;
		
		System.out.println("Autonomo ou Petshop?"+ autonomoOuPetshop);

		// Popula o HashMap
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int count = 0;
		for (int i = 0; i < servicos.length; i++) {
			count++;
			map.put(count, servicos[i]);
		}
		if(precoDe != -1){
			count++;
			map.put(count, ""+precoDe);
		}
		if(precoAte != -1){
			count++;
			map.put(count, ""+precoAte);
		}
		if(bairro != null){
			count++;
			map.put(count, bairro);
		}
		if(delivery != null){
			count++;
			map.put(count, delivery);
		}
		
		//verifica se há filtros a serem aplicados
		if (servicos.length > 0 || precoDe != -1 || precoAte != -1 || bairro != null){
			aplicarFiltro = true;
		}

		// cria SQL de busca
		String sql = "SELECT " +
				"    s_aut.*," +
				"    a.nome," +
				"    a.bairro," +
				"    ( p.somanota / p.somaqnt ) nota " +
				" FROM prestador p " +
				" INNER JOIN (SELECT " +
				"			sa.cpf," +
				"			sa.preco," +
				"			sa.condicoes," +
				"			sa.delivery," +
				"			s.id_servico," +
				"			s.nome servico" +
				"		FROM servico_autonomo sa" +
				"		INNER JOIN servico s" +
				"			ON s.id_servico = sa.id_servico";
		if (aplicarFiltro){
			sql += "		WHERE ";
			for (int i = 0; i < servicos.length; i++) {
				if (i==0){
					sql+=" (s.id_servico = ?";
				}else{
					sql+="  OR s.id_servico = ?";
				}
				if (i==servicos.length-1)
					sql+=")";
			}
			if (precoDe != -1)
				sql += " AND sa.preco >= ?";
			if (precoAte != -1)
				sql += " AND sa.preco <= ?";
			if (delivery != null)
				sql += " AND sa.delivery = ?";
		}
		sql+="	) AS s_aut" +
				"	ON s_aut.cpf = p.id_prestador" +
				" INNER JOIN autonomo a" +
				"	ON p.id_prestador = a.cpf";
		
		if (bairro != null)
			sql+=" WHERE a.bairro = ? ";
		
		//System.out.println("SQL SEARCH Prestador:\n"+sql);
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			// seta os parametros para busca
			for (int i = 0; i <= map.size(); i++) {
				if(map.containsKey(i)){
					//System.out.println("i="+i+" - map:"+map.get(i));
					stmt.setString(i, map.get(i));
				}
			}
			System.out.println("Busca Prestador Autonomo: "+stmt.toString());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Busca resultado = new Busca();
				resultado.setId(rs.getLong("cpf"));
				resultado.setCondicoes(rs.getString("condicoes"));
				resultado.setBairro(rs.getString("bairro"));
				resultado.setDelivery(rs.getBoolean("delivery"));
				resultado.setNome(rs.getString("nome"));
				resultado.setNota(rs.getLong("nota"));
				resultado.setPreco(Double.parseDouble(rs.getString("preco")));
				resultado.setServico(rs.getString("servico"));
				
				prestadores.add(resultado);
			}
			
			return prestadores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getEmailById (Long cpf) {
		String sql = "SELECT email FROM Prestador WHERE id_prestador=?";
		String email = "";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {				
				email = rs.getString("email");
				stmt.close();
				return email;
			}			
			
			return "";
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}

	public String getSenhaById (Long cpf) {
		String sql = "SELECT senha FROM Prestador WHERE id_prestador=?";
		String senha = "";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {				
				senha = rs.getString("senha");
				stmt.close();
				return senha;
			}			
			
			return "";
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
	
	public void update(Prestador prestador) {
		String sql = "UPDATE PRESTADOR SET email=?, senha=?"
				+ "WHERE id_prestador=?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores			
			stmt.setString(1, prestador.getEmail());
			stmt.setString(2, prestador.getSenha());
			stmt.setLong(3, prestador.getId_prestador());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
