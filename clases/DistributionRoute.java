package Trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DistributionRoute {
	private Trie trie;
	public boolean loadFiles(String paths) {
		try (BufferedReader br = new BufferedReader(new FileReader(paths))){// Por medio de BufferedReader leemos el Archivo txt.
			trie = new Trie();
            String linea;
             // Divide el texto en palabras, excluyendo cualquier carácter que no sea una letra o número
               
            while ((linea = br.readLine())!= null){
            	String[] words = linea.split("\\W+");
                System.out.println("palabras el una linea: "+ words.length);   
            	  for (int i = 0; i< words.length; i++) {
                      trie.insert((words[i]));
                      }
            } 
        } catch (IOException e) {
            e.printStackTrace();
       }
		return false;
	}
	
//	public ResultDistr verifyRoutes() {
//		return result;
//	}

}
