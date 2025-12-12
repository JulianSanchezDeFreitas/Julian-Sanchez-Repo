package ej14;

public abstract class Pieza {
	private String color;
	private String material;
	
	public abstract double getVolumen();
	public abstract double getSuperficie();
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
