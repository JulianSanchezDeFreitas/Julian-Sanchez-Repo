package ej4Topografias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TierraTest {
	private Topografia tierra;
	
	@BeforeEach
	void setUp() {
		tierra = new Tierra();
	}
	
	@Test
	void proporcionDeAguaTest() {
		assertEquals(0, tierra.proporcionDeAgua());
	}
}
