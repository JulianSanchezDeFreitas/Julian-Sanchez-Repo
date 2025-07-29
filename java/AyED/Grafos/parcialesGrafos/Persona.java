package parcialesGrafos;

public abstract class Persona {
	protected String nombre;
	protected String domicilio;
	
	
	public abstract boolean soyJubilado();
	public abstract boolean soyEmpleado();

	public String getNombre(){
		return nombre;
	}
}
