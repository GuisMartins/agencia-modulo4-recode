package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;

import db.mySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD {
	
	private static Connection conn = mySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO clientes VALUES(null,? ,? ,? ,? ,? ,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getIdade());
			preparedStatement.setString(4, cliente.getTelefone());
			preparedStatement.setString(5, cliente.getEndereco());
			preparedStatement.setString(6, cliente.getEmail());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Iserção no banco de dados correta");
			
		} catch (SQLException e) {
			
			System.out.println("Iserção no banco de dados incorreta " + e.getMessage());
			
		}
	}
	
	public static void delete(int idCliente) {
		sql= "DELETE FROM clientes WHERE idCliente = ?";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setInt(1, idCliente);
			preparedStatement.executeUpdate(); 
			
			System.out.println("Deletar cliente correto");
			
		} catch (SQLException e) {
			System.out.println("Deletar cliente incorreto" +e.getMessage());
			
		}
	}
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM clientes WHERE nome LIKE '%S%%' OR cpf LIKE'%s%%' ", pesquisa, pesquisa);		
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(resultSet.getInt("idCliente"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setIdade(resultSet.getString("idade"));
				cliente.setEndereco(resultSet.getString("endereco"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setEmail(resultSet.getString("email"));
				
				clientes.add(cliente);
				
			}
			
			System.out.println("Busca clientes correta ");
			return clientes;
			
		} catch (SQLException e) {
			System.out.println("Busca clientes incorreta " + e.getMessage());
			return null;
		}
		
			
	}
	
	public static Cliente findByPk(int idCliente) {
		sql = String.format("SELECT * FROM clientes WHERE idCliente = %d ", idCliente);		
		
		
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				
				
				cliente.setIdCliente(resultSet.getInt("idCliente"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setIdade(resultSet.getString("idade"));
				cliente.setEndereco(resultSet.getString("endereco"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setEmail(resultSet.getString("email"));
				
				
				
			}
			
			System.out.println("Busca cliente por id correta ");
			return cliente;
			
		} catch (SQLException e) {
			System.out.println("Busca cliente por id incorreta " + e.getMessage());
			return null;
		}
				
		
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, cpf=?, idade=?, telefone=?, endereco=?, email=? WHERE idCliente =?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getIdade());
			preparedStatement.setString(4, cliente.getTelefone());
			preparedStatement.setString(5, cliente.getEndereco());
			preparedStatement.setString(6, cliente.getEmail());
			preparedStatement.setInt(7, cliente.getIdCliente());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Atualização no banco de dados correta");
			
		} catch (SQLException e) {
			
			System.out.println("Atualização no banco de dados incorreta " + e.getMessage());
			
		}
	}
}
