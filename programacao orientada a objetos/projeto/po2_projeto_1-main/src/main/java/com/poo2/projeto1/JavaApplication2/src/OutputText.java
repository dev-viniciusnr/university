package com.poo2.projeto1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class OutputText implements Output {
	
	@Override
	public void out(List<String> result)  {
            // print each line on the screen
            File csv = new File ("arquivo.csv");
            try{
                String row = new String(); 
                Scanner reader = new Scanner(csv);
                while(reader.hasNext()){
                    row = reader.nextLine();
                    System.out.println(row);
                }
            }catch(FileNotFoundException e){
               
            }
	}
	
}
