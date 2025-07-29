package parcialesGrafos;

public class Recinto {
    private int tiempo;
    private String nombre;


    public Recinto(int tiempo, String nombre){
        this.tiempo = tiempo;
        this.nombre = nombre;
    }

    public int getTiempo(){
        return this.tiempo;
    }

    
    public String getNombre(){
        return this.nombre;
    }
}
