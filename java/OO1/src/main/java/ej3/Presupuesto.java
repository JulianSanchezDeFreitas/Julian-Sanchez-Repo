package ej3;

import java.util.*;
import java.time.LocalDate;


public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items = new ArrayList<Item>() ;
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	public double calcularTotal() {
		double total = 0;
		for (Item item : items) {
			total += item.costo();
		}
		return total;
	}
	
}
