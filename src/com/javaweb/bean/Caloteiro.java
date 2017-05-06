package com.javaweb.bean;

import java.util.Calendar;

public class Caloteiro {
	private int id;
	private String nome;
	private String email;
	private int devendo;
	private Calendar dataDivida;
	
	/*Getters and Setters*/	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDevendo() {
		return devendo;
	}
	public void setDevendo(int devendo) {
		this.devendo = devendo;
	}
	public Calendar getData() {
		return dataDivida;
	}
	public void setData(Calendar date) {
		this.dataDivida = date;
	}
	
	
}
