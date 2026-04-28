package ej2CalculoDeSueldo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasanteTest {

	private Pasante pasante;
	
	@BeforeEach
	void setUp() {
		pasante = new Pasante(30);
	}
	
	@Test
	void sueldoConExamenesTest() {
		assertEquals(74400, pasante.sueldo());
	}
	@Test
	void sueldoSinExamenesTest() {
		pasante.setExamenesRendidos(0);
		assertEquals(17400, pasante.sueldo());
	}
	
}
