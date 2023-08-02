package clases;
import graphlink.*;

public class DistributionRoute {
	private GraphLink grafo;
	public boolean loadFiles(String paths) {
		boolean correcto = false;
		try (BufferedReader br = new BufferedReader(new FileReader(paths))){// Por medio de BufferedReader leemos el Archivo txt.
			grafo = new GraphLink();
            String linea;
             // Divide el texto en palabras, excluyendo cualquier carÃ¡cter que no sea una letra o numero
               
            while ((linea = br.readLine())!= null){
            	String[] words = linea.split(",");
            	int peso = 0;
            	int partida = 0;
            	String destino = "";
                System.out.println("palabras el una linea: "+ words.length);   
            	 	  
               partida =Integer.parseInt(words[0]);
               destino = words[1];	
	           peso = Integer.parseInt(words[2]);
	            	        
               grafo.insertVertex(partida);
               grafo.insertVertex(destino);
               grafo.insertEdge(partida, destino, peso);
               correcto = true;
            	  
            } 
        } catch (IOException e) {
            e.printStackTrace();
       }
		return correcto;
	}
//	public ResultDistr verifyRoutes() {
//		return result;
//	}
