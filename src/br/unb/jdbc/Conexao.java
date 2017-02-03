package br.unb.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			// Força o carregamento do Driver
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javaweb", "root", "password");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Sem conectar!\n" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Falha na Conexão!\n" + e.getMessage());
					e.printStackTrace();
		}
		return con;
	}
}