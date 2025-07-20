package com.poo2.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * 
 * @author Vitor Emanuel
 *
 */
public class InputText implements Input {
	private List<String> data;

	public InputText(List<String> data) {
		this.data =data;
	}
	public InputText() {

		data = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o texto abaixo, para continuar digite 0 em nova linha");
		while (sc.hasNextLine() ) {
			String line = sc.nextLine();
			if(line.equals("0")) {
				break;
			}
			data.add(line);
			
		
		}
		sc.close();
	}

	@Override
	public List<String> getData() {
		// TODO Auto-generated method stub
		return data;
	}
}
