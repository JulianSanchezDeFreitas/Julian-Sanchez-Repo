package ej8DocumentosYEstadisticas;

import java.util.List;
/*
 * La clase document tenia 2 errores en el metodo calculateAvg, el primero es que si la lista estaba vacia podia dividir por cero
 * el 2do es que el codigo que ahora esta reemplazdo en la linea 20 por el metodo characterCount tenia codigo duplicado, el mismo que estaba en dicho metodo
 */
public class Document {
	 List<String> words;
	  
	    public long characterCount() {
		 	long count = this.words
				.stream()
				.mapToLong(w -> w.length())
				.sum();
		    	return count;
		}
	    public long calculateAvg() {
	    	if (this.words.size() != 0) 
	    		return characterCount() / this.words.size();
	    	return 0;
		}

}
