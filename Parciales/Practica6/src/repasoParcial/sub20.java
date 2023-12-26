package repasoParcial;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class sub20 {
    private ListaGenerica<String> lista;
    private Integer cuadras;

    public sub20(){
        this.cuadras = 0;
        this.lista = new ListaEnlazadaGenerica<>();
    }

    public void setLista (ListaGenerica<String> lista){
        this.lista = lista;
    }

    public ListaGenerica<String> getLista(){
        return lista;
    }

    public void setCuadras(int cuadras){
        this.cuadras = cuadras;
    }

    public int getCuadras(){
        return cuadras;
    }
}
