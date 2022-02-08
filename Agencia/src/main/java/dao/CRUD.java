package dao;

import java.util.List;

import model.Cliente;

public interface CRUD {
	
	public static void create(Cliente cliente) {};
	public static void delete(int idCliente) {};
	public static List<Cliente> find(String pesquisa){return null;}
	public static Cliente findByPk(int idCliente) {return null;}
	public static void update(Cliente cliente) {}
	
};
