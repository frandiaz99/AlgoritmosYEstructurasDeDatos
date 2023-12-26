import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProcesadorDeArbol {

    private ArbolBinario<Integer> a;

    public ProcesadorDeArbol(ArbolBinario<Integer> a){
        this.a = a;
    }

    public Objeto procesar(){
        if(!this.a.esVacio())
            return procesar(this.a);
        else{
            return null;
        }
    }

    private Objeto procesar(ArbolBinario<Integer> a){
        ListaGenerica<ArbolBinario<Integer>> lAux = new ListaEnlazadaGenerica<>();
        Objeto o = new Objeto(0,lAux);

        if(a.getDato()%2 == 0){
            o.aumentarValor(1);
            if(a.tieneHijoIzquierdo() && a.tieneHijoDerecho()){
                o.agregarALista(a);
            }

        }

        if(a.tieneHijoIzquierdo()){
            Objeto oIzq = procesar(a.getHijoIzquierdo());
            o.aumentarValor(oIzq.getValor());
            ListaGenerica<ArbolBinario<Integer>> l;
            l = oIzq.getLista();
            l.comenzar();
            while(!l.fin()){
                o.agregarALista(l.proximo());
            }
        }

        if(a.tieneHijoDerecho()){
            Objeto oDer = procesar(a.getHijoDerecho());
            o.aumentarValor(oDer.getValor());
            ListaGenerica<ArbolBinario<Integer>> l;
            l = oDer.getLista();
            l.comenzar();
            while(!l.fin()){
                o.agregarALista(l.proximo());
            }
        }

        return o;
    }
}
