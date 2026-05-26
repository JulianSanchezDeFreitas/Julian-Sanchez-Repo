package ej4Topografias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {

	private Agua agua1;
	private Agua agua2;
	private Tierra tierra1;
	private Tierra tierra2;
	private Mixta mixta2;
	private Mixta mixta3;
	private Mixta mixta4;
	private List<Topografia> listaMixta2;
	private List<Topografia> listaMixta3;
	private List<Topografia> listaMixta4;
	
	@BeforeEach
	void setUp() {
		
		agua1 = new Agua();
		agua2 = new Agua();
		tierra1 = new Tierra();
		tierra2 = new Tierra();
		listaMixta2 = new ArrayList<Topografia>();
		listaMixta3 = new ArrayList<Topografia>();
		listaMixta4 = new ArrayList<Topografia>();
		listaMixta2.add(agua1);
		listaMixta2.add(tierra1);
		listaMixta2.add(tierra2);
		listaMixta2.add(agua2);
		mixta2 = new Mixta(listaMixta2);
		listaMixta3.add(agua1);
		listaMixta3.add(tierra1);
		listaMixta3.add(tierra2);
		listaMixta3.add(mixta2);
		mixta3 = new Mixta(listaMixta3);
		listaMixta4 = new ArrayList<Topografia>();
		listaMixta4.add(agua2);
		listaMixta4.add(tierra2);
		listaMixta4.add(tierra2);
		listaMixta4.add(agua1);
		mixta4 = new Mixta(listaMixta4);
	}
	
	@Test
	void proporcionDeAguaTest() {
		assertEquals(0.375, mixta3.proporcionDeAgua());
	}
	@Test
	void esIgualTest() {
		assertEquals(true, mixta2.esIgual(mixta2));
	}
	
	@Test
	void esNoIgualTest() {
		assertEquals(false, mixta2.esIgual(mixta4));
	}
}
