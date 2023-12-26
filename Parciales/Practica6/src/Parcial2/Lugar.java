package Parcial2;

public class Lugar {
    private String nombre;
    private int tiempo;

    public Lugar(String nombre, int tiempo){
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getTiempo(){
        return tiempo;
    }


}
