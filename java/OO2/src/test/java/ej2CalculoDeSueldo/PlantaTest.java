package ej2CalculoDeSueldo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlantaTest {
	private Planta planta;
	
	@BeforeEach
	void setUp() {
		planta = new Planta(true, 2, LocalDate.of(2023, 9, 1));	
	}
	
	@Test
	void sueldoConHijosAntiguedadCasadoTest() {
		assertEquals(55850, planta.sueldo());
	}
	@Test
	void sueldoSinHijosAntiguedadCasadoTest() {
		planta.setHijos(0);
		assertEquals(52050, planta.sueldo());
	}
	@Test
	void sueldoConHijosAntiguedadNoCasadoTest() {
		planta.setCasado(false);
		assertEquals(51100, planta.sueldo());
	}
	@Test
	void sueldoConHijosSinAntiguedadCasadoTest() {
		planta.setDiaAlta(LocalDate.now());
		assertEquals(52050, planta.sueldo());
	}
	// hubiera sido mejor, calcular los metodos, sueldo, adicional, antiguedad?

}
