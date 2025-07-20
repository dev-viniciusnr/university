package com.poo2.projeto1;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * 
 * 
 * @author Vitor Emanuel 
 *
 */
public class InputFile implements Input {

	private List<String> data;

	public InputFile(String filename) throws FileNotFoundException {
		this.load(filename);
	}
	
	// load filename content
	private void load(String filename) throws FileNotFoundException{
		
		
		//
	}
	@Override
	public List<String> getData(){
		
		return data;
	}
	
	
}
