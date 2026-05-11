package ej4Topografias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {

	private Topografia topografia1;
	private Topografia topografia2;
	private Agua agua1;
	private Agua agua2;
	private Tierra tierra1;
	private Tierra tierra2;
	private Component mixta2;
	private Component mixta3;
	private Component mixta4;
	private List<Component> listaMixta2;
	private List<Component> listaMixta3;
	private List<Component> listaMixta4;
	
	@BeforeEach
	void setUp() {
		
		topografia1 = new Topografia();
		topografia2 = new Topografia();
		agua1 = new Agua();
		agua2 = new Agua();
		tierra1 = new Tierra();
		tierra2 = new Tierra();
		listaMixta2 = new ArrayList<Component>();
		listaMixta3 = new ArrayList<Component>();
		listaMixta4 = new ArrayList<Component>();
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
		listaMixta4 = new ArrayList<Component>();
		listaMixta4.add(agua2);
		listaMixta4.add(tierra2);
		listaMixta4.add(tierra2);
		listaMixta4.add(agua1);
		mixta4 = new Mixta(listaMixta4);
	}
	
	@Test
	void proporcionDeAguaTest() {
		topografia1.agregarComponente(mixta3);
		assertEquals(0.375, topografia1.proporcionDeAgua());
	}
	@Test
	void esIgualTest() {
		topografia1.agregarComponente(mixta2);
		topografia2.agregarComponente(mixta2);
		assertEquals(true, topografia1.esIgual(topografia2));
	}
	
	@Test
	void esNoIgualTest() {
		topografia1.agregarComponente(mixta2);
		topografia2.agregarComponente(mixta4);
		assertEquals(false, topografia1.esIgual(topografia2));
	}
}
