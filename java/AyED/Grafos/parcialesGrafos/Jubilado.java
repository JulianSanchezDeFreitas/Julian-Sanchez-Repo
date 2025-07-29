package parcialesGrafos;

public class Jubilado extends Persona{

	
	public Jubilado(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		
	}
		
		public boolean soyJubilado() {
			return true;
		}
		
		public boolean soyEmpleado() {
			return false;
		}
}
