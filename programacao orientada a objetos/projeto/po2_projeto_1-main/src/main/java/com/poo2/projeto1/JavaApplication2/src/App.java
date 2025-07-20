package com.poo2.projeto1;

import java.util.ArrayList;
import java.util.List;

/**
 * Projeto 1
 * @author Vitor Emanuel 
 */
public class App {
	public static List<String> sampleText() {

		List<String> text = new ArrayList<String>();
		text.add("há, ó gente, ó não");
		text.add("Luar como esse do sertão");
		text.add("Não há, ó gente, ó não");
		text.add("Luar como esse do sertão");
		text.add("Oh que saudade do luar da minha terra");
		text.add("Lá na serra branquejando folhas secas pelo chão");
		text.add("Este luar cá da cidade tão escuro");
		text.add("Não tem aquela saudade do luar lá do sertão");
		text.add("Não há, ó gente, ó não");
		text.add("Luar como esse do sertão");
		text.add("Não há, ó gente, ó não");
		text.add("Luar como esse do sertão");
		return text;
	}
	public static void main(String[] args) {

		try {
			System.out.println("Projeto I: Pré analisador de textos");
			
			// load sample text 
			Input i = new InputText(App.sampleText());
			
			// print text in the screen, could be the OutputCsvFile.java	 
			Output o = new OutputText();
			
			// pre-processing and generate output
			new Processor(i,o);
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Um erro ocorreu");
			e.printStackTrace();
		}
	}
}
