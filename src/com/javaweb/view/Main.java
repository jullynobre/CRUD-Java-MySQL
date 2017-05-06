package com.javaweb.view;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import com.javaweb.DAO.CaloteiroDAO;
import com.javaweb.bean.Caloteiro;

public class Main {
	private static Caloteiro caloteiro = new Caloteiro();
	
	public static void main(String[] args) {
		int action = Integer.parseInt(JOptionPane.showInputDialog("\nInforme um inteiro de acordo com o índice da ação desejada: \n 1. Adicionar um Caloteiro  \n 2. Listar Caloteiros \n 3. Remover caloteiro da lista negra \n 4. Sair"));
		switch(action){
			case 1:
				add();main(args); break;
			case 2:
				list();main(args); break;
			case 3:
				remove();main(args);break;
			case 4:
				System.out.println("By :)");
				break;
			default:
				System.out.println("Entrada inálida.");
		}
	}
	
	private static void add(){
		caloteiro.setNome(JOptionPane.showInputDialog("Nome"));
		caloteiro.setEmail(JOptionPane.showInputDialog("Email"));
		caloteiro.setDevendo(Integer.parseInt(JOptionPane.showInputDialog("Valor")));
		caloteiro.setData(Calendar.getInstance());
		
		CaloteiroDAO.getInstance().add(caloteiro);
	}
	
	private static void list(){
		ArrayList<Caloteiro> caloteiros = CaloteiroDAO.getInstance().getList();
		String list = "";
		if(caloteiros.size() == 0){list = "Nenhum caloteiro na lista negra!";}
		for (Caloteiro caloteiro : caloteiros) {
			list += "\n\n" + caloteiro.getId()+ "\nNome: " + caloteiro.getNome()+ "\nEmail: " 
					+ caloteiro.getEmail() + "\nDívida: R$" + caloteiro.getDevendo()+ "\nData da dívida: " + caloteiro.getData().getTime();
		}
		JOptionPane.showMessageDialog(null, list);
		
	}
	
	private static void remove(){
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id"));
		CaloteiroDAO.getInstance().remove(id);
	}
}
