package com.javaweb.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/*Singleton Pattern*/
	private static ConnectionFactory instance;
	private ConnectionFactory(){}
	public static ConnectionFactory getInstance(){
		if(instance == null){ instance = new ConnectionFactory(); }
		return instance;
	} 
	
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/crudjavamysql", "root", "1234");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar abrir conexão com o banco: " + e.getMessage());
		} return null;
	}

}