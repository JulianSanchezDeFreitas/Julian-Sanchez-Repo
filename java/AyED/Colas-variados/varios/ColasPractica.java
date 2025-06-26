package varios;

import ejercicio1.Queue;

public class ColasPractica {

	public static void main(String[] args) {
		Queue<Integer> cola = new Queue<Integer>();
		
		cola.enQueue(1);
		cola.enQueue(2);
		cola.enQueue(3);
		cola.enQueue(4);
		cola.enQueue(5);
		
		System.out.println(cola.head());
		System.out.println(cola.toString());
		System.out.println(cola.deQueue());
		System.out.println(cola.toString());
	}

}
