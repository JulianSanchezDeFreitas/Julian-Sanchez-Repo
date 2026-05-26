package ej5ElementosQuimicos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnionTest {

		private ElementoQuimico union;
		private ElementoQuimico oxigeno;
		private ElementoQuimico hidrogeno;
		private ElementoQuimico sodio;
		private ElementoQuimico cloro;
		private ElementoQuimico calcio;
		private List<ElementoQuimico> listaElem;
		
		@BeforeEach
		void setUp() {
			oxigeno = new Oxigéno();
			hidrogeno = new Hidrógeno();
			sodio = new Sodio();
			cloro = new Cloro();
			calcio = new Calcio();
			listaElem = new ArrayList<ElementoQuimico>();
		
		}
		
		@Test
		void pesoMolecularTest() {
			listaElem.add(hidrogeno);
			listaElem.add(oxigeno);
			listaElem.add(calcio);
			union = new Union(listaElem);
			assertEquals(57, union.pesoMolecular());
		}
		
		@Test
		void cargaTest() {
			listaElem.add(hidrogeno);
			listaElem.add(calcio);
			listaElem.add(cloro);
			union = new Union(listaElem);
			assertEquals(2, union.carga());
		}
		@Test
		void formulaTest() {
			listaElem.add(hidrogeno);
			listaElem.add(hidrogeno);
			listaElem.add(oxigeno);
			union = new Union(listaElem);
			assertEquals("H2O", union.formula());
		}
		@Test
		void esValidoTest() {
			listaElem.add(sodio);
			listaElem.add(hidrogeno);
			listaElem.add(calcio);
			union = new Union(listaElem);
			assertEquals(true, union.esValida());
		}
		
		
}
