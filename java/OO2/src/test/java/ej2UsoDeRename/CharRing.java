package ej2UsoDeRename;
// en este ejercicio ,en el metodo next la variable que actualmente tiene el nombre currentPosition tenia el nombre result,
//se usa la herramienta rename de refactorizacion
public class CharRing extends Object {
	private char[] source;
	public int idx;
		   
	public CharRing(String srcString) {
		char result;
		source = new char[srcString.length()];
		srcString.getChars(0, srcString.length(), source, 0);
		result = 0;
		idx = result;
		      }
	public char next() {
		int currentPosition;
		if (idx >= source.length)
			idx = 0;
		currentPosition = idx++;
	    return source[currentPosition];
	}

}
