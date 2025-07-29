package parcialesGrafos;

public class Empleado extends Persona {

	public Empleado(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		
	}
		
		public boolean soyJubilado() {
			return false;
		}
		
		public boolean soyEmpleado() {
			return true;
		}
}


