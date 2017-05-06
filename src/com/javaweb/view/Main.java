package com.javaweb.view;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import com.javaweb.DAO.CaloteiroDAO;
import com.javaweb.bean.Caloteiro;

public class Main {
	public static void main(String[] args) {
		int action = Integer.parseInt(JOptionPane.showInputDialog("\nInforme um inteiro de acordo com o índice da ação desejada:"+
				" \n 1. Adicionar um Caloteiro  \n 2. Listar Caloteiros \n 3. Remover caloteiro da lista negra"+
				" \n 4. Atualizar dados de um caloteiro \n 5. Sair"));
		switch(action){
			case 1:
				add();main(args); break;
			case 2:
				list();main(args); break;
			case 3:
				remove();main(args);break;
			case 4:
				update();main(args);break;
			case 5:
				System.out.println("By :)");
				break;
			default:
				System.out.println("Entrada inálida.");
		}
	}
	
	private static void add(){
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(JOptionPane.showInputDialog("Nome"));
		caloteiro.setEmail(JOptionPane.showInputDialog("Email"));
		caloteiro.setDevendo(Integer.parseInt(JOptionPane.showInputDialog("Valor")));
		caloteiro.setData(Calendar.getInstance());
		
		if(CaloteiroDAO.getInstance().add(caloteiro)){
			JOptionPane.showMessageDialog(null, "Caloteiro cadastrado com sucesso!");
		} else{
			JOptionPane.showMessageDialog(null, "Erro ao tentar cadatrar caloteiro!");
		}
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
		if(CaloteiroDAO.getInstance().getCaloteiro(id) != null){
			CaloteiroDAO.getInstance().remove(id);
		} else{
			JOptionPane.showMessageDialog(null, "ID "+ id +" inválido");
		}
	}
	
	private static void update(){
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id"));
		Caloteiro caloteiroOld = CaloteiroDAO.getInstance().getCaloteiro(id);
		if(caloteiroOld != null){
			Caloteiro caloteiro = new Caloteiro();
			
			caloteiro.setNome(JOptionPane.showInputDialog("Novo nome."+
					"\nDeixe o campo vazio para não atualizar dado \nNome antigo: " + caloteiroOld.getNome()));
			caloteiro.setEmail(JOptionPane.showInputDialog("Novo email."+
					"\nDeixe o campo vazio para não atualizar dado \nEmail antigo: " + caloteiroOld.getEmail()));
			try {
				caloteiro.setDevendo(Integer.parseInt(JOptionPane.showInputDialog("Novo valor."+
						"\nDeixe o campo vazio para não atualizar dado \nValor antigo: " + caloteiroOld.getDevendo())));	
			} catch (Exception e) {
				caloteiro.setDevendo(0);
			}
			caloteiro.setData(Calendar.getInstance());
			
			if(caloteiro.getNome().isEmpty()){caloteiro.setNome(caloteiroOld.getNome());}
			if(caloteiro.getEmail().isEmpty()){caloteiro.setEmail(caloteiroOld.getEmail());}
			if(caloteiro.getDevendo() == 0){caloteiro.setDevendo(caloteiroOld.getDevendo());}
			
			if(CaloteiroDAO.getInstance().update(id, caloteiro)){
				JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
			}else{
				JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar dados.");
			}
		}
	}
}
