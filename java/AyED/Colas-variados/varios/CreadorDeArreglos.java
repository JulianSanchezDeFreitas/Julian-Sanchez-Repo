package varios;

public class CreadorDeArreglos {

	public static int[] CA(int n){
		int[]vectorr = new int[n];
		for (int i=0; i<n; i++) {
			vectorr[i]= (i+1)*n;
		}
		
 		return vectorr;
	}
}
