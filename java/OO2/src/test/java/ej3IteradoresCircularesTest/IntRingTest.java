package ej3IteradoresCircularesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ej3IteradoresCirculares.IntRing;
import ej3IteradoresCirculares.Ring;


public class IntRingTest {

	private Ring anilloInt;
	
	@BeforeEach
	void setUp() {
		Integer[] numeros = {1,2,3};
		anilloInt = new IntRing(numeros);
	}
	
	@Test
	void TestNext() {
		assertEquals(1, anilloInt.next());
		anilloInt.next();
		assertEquals(3, anilloInt.next());
		assertEquals(1, anilloInt.next());
	}
	
}
