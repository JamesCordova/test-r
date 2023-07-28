package clases;
import graphlink.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DistributionRoute {
	private GraphLink grafo;
	public boolean loadFiles(String paths) {
		boolean correcto = false;
		try (BufferedReader br = new BufferedReader(new FileReader(paths))){// Por medio de BufferedReader leemos el Archivo txt.
			grafo = new GraphLink();
            String linea;
             // Divide el texto en palabras, excluyendo cualquier carÃ¡cter que no sea una letra o nÃºmero
               
            while ((linea = br.readLine())!= null){
            	String[] words = linea.split("\\W+");
            	int peso = 0;
            	String partida = "";
            	String destino = "";
                System.out.println("palabras el una linea: "+ words.length);   
            	  for (int i = 0; i< words.length; i++) {
            		  	  if((words[i].charAt(0)> 64 && words[i].charAt(0) < 91 ||
            		  		words[i].charAt(0)> 96 && words[i].charAt(0) < 123) && destino == "")
            		  		  partida = words[i];
            		  	 if((words[i].charAt(0)> 64 && words[i].charAt(0) < 91 ||
                 		  		words[i].charAt(0)> 96 && words[i].charAt(0) < 123)&& partida != "")
                 		  		  destino = words[i];
	            		  if(esNumero(words[i])) {
	            			 peso = Integer.parseInt(words[i]);
	            		  }
                      }
            	  grafo.insertVertex(partida);
            	  grafo.insertVertex(destino);
            	  grafo.insertEdge(partida, destino, peso);
            	  if(partida != "" && destino != "" && peso != 0 && partida != destino)
            		  correcto = true;
            	  
            } 
        } catch (IOException e) {
            e.printStackTrace();
       }
		return correcto;
	}
	//Verifica que peso sea numero
	public boolean esNumero(String s){
		if (s == null || s.equals("")){
			return false;
		}

		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
//	public ResultDistr verifyRoutes() {
//		return result;
//	}

}
