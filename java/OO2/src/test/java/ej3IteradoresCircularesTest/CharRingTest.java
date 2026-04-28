package ej3IteradoresCircularesTest;

import ej3IteradoresCirculares.CharRing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CharRingTest {

	private CharRing anilloChar;
	
	
	@BeforeEach
	void setup() {
		anilloChar = new CharRing("hola");
		
	}
	@Test
	void testNext() {
		assertEquals('h', anilloChar.next());
		anilloChar.next();
		anilloChar.next();
		assertEquals('a', anilloChar.next());
		assertEquals('h', anilloChar.next());
	}
}
