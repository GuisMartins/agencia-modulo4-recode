package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mySqlConnection {

	private static final String url ="jdbc:mysql://localhost:3306/agencia";
	private static final String usuario = "root";
	private static final String senha = "N92c00r41@"; 
	
	public static Connection createConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado");
			
		} catch(ClassNotFoundException e){
			
			System.out.println("Drier não encontrado " + e.getMessage());
		}
		
		try {
			Connection conn = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado no banco de dados");
			return conn;
		} catch (SQLException e) {
			System.out.println("Baco de dados não encontrado "+ e.getMessage());
			return null;
		}
	}
}
