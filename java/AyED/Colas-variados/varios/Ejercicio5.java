package varios;

public class Ejercicio5 {

	public Valores devuelvoEnReturn(int[]v, int dimL) {
		double suma = 0;
		Valores val = new Valores(999,-999,0);
		for (int i=0; i < dimL;i++ ) {
			if (v[i]<val.getMin()) {
				val.setMin(v[i]);
			}
			if (v[i]>val.getMax()) {
				val.setMax(v[i]);
			}
			suma += v[i];
		}
			val.setPromedio(suma/dimL);
		return val;
	}
	
	public void devuelvoEnParametro(int[]v, int dimL, Valores valores) {
		double suma = 0;
		Valores val = new Valores(999,-999,0);
		for (int i=0; i < dimL;i++ ) {
			if (v[i]<val.getMin()) {
				val.setMin(v[i]);
			}
			if (v[i]>val.getMax()) {
				val.setMax(v[i]);
			}
			suma += v[i];
		}
			val.setPromedio(suma/dimL);
	}
	
	
}
