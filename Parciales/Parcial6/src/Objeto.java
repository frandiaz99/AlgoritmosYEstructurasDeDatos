import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Objeto {
    private int valor;
    private ListaGenerica<ArbolBinario<Integer>> lista;

    public Objeto(int valor, ListaGenerica<ArbolBinario<Integer>> lista){
        this.valor = valor;
        this.lista = lista;
    }
    public void aumentarValor(int v){
        this.valor = valor + v;
    }
    public int getValor(){
        return valor;
    }

    public void agregarALista(ArbolBinario<Integer> a){
        this.lista.agregarFinal(a);
    }

    public ListaGenerica<ArbolBinario<Integer>> getLista(){
        return lista;
    }
}
