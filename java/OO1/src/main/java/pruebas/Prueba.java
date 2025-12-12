package pruebas;

public class Prueba {

	public static void main(String[] args) {
		Plan planG = new Grupal(4);
		Plan planI = new Individual(4, 2344);
		
		System.out.print(planG.costoTotal(5, 19));
		System.out.print("termine grupal");
		System.out.print(planI.costoTotal(5, 20));

	}

}
