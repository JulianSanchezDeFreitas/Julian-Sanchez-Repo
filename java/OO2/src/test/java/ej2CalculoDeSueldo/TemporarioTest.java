package ej2CalculoDeSueldo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemporarioTest {

	private Temporario temporario;
	
	@BeforeEach
	void setUp() {
		temporario = new Temporario(true, 2, 24);
		
	}
	
	@Test
	void sueldoTest(){
		assertEquals(32214, temporario.sueldo());
	}
	
	@Test
	void adicionalConParejaEHijosTest(){
		assertEquals(9000, temporario.adicional());
	}
	@Test
	void adicionalSinParejaConHijosTest(){
		temporario.setCasado(false);
		assertEquals(4000, temporario.adicional());
	}
	@Test
	void adicionalConParejaSinHijosTest(){
		temporario.setHijos(0);
		assertEquals(5000, temporario.adicional());
	}
}
