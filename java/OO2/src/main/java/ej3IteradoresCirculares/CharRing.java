package ej3IteradoresCirculares;


public class CharRing extends Ring  {

		
	public CharRing(String src) {
		super(stringToCharacterArray(src));
		
	}
	
	private static Character[] stringToCharacterArray(String src) {
		char[] src_a_caracteres = src.toCharArray();
		Character[] caracteres = new Character[src_a_caracteres.length];
		for(int i = 0; i<src_a_caracteres.length; i++) {
			caracteres[i] = src_a_caracteres[i];
		}
		return caracteres;
	}
		
}
