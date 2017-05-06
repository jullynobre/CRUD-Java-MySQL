package com.javaweb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		System.out.println("Conexão aberta!");
		
		try {
			connection.close();
			System.out.println("Conexão Fechada!");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
