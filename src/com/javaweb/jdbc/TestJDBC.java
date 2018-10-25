package com.javaweb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			System.out.println("Conex�o aberta!");


		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		System.out.println("Conex�o Fechada!");
	}
}
