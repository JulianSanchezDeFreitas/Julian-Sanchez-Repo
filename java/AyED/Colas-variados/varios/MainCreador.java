package varios;

import java.util.Scanner;

public class MainCreador {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in) ;
		int n = s.nextInt();
		int[] vectorr = CreadorDeArreglos.CA(n);
		for (int i=0; i<n;i++) {
			System.out.print("---");
			System.out.print(vectorr[i]);
		}
	}

}
