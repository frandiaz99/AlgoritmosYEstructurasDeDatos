import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class Main {

    public ListaGenerica<Integer> resolver(ArbolBinario<Integer> arbol){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        System.out.println("a");
        resolver(arbol, lista);
        return lista;
    }

    private int resolver(ArbolBinario<Integer> a, ListaGenerica<Integer> l) {
        int hi = 0;
        int hd = 0;

        if (a.tieneHijoIzquierdo()) {
            hi++;
            hi += resolver(a.getHijoIzquierdo(), l);
        }
        if (a.tieneHijoDerecho()) {
            hd++;
            hd += resolver(a.getHijoDerecho(), l);
        }
        if (hi == hd) {
            
            l.agregarFinal(a.getDato());
        }

        return hd + hi;
    }


    public static void main(String[] args) {

        ArbolBinario<Integer> a1 = new ArbolBinario<>(1);
        ArbolBinario<Integer> a2 = new ArbolBinario<>(2);
        ArbolBinario<Integer> a3 = new ArbolBinario<>(3);
        ArbolBinario<Integer> a4 = new ArbolBinario<>(4);
        ArbolBinario<Integer> a5 = new ArbolBinario<>(5);
        ArbolBinario<Integer> a6 = new ArbolBinario<>(6);
        ArbolBinario<Integer> a7 = new ArbolBinario<>(7);
        ArbolBinario<Integer> a8 = new ArbolBinario<>(8);
        ArbolBinario<Integer> a9 = new ArbolBinario<>(9);
        ArbolBinario<Integer> a10 = new ArbolBinario<>(10);
        ArbolBinario<Integer> a11 = new ArbolBinario<>(11);

        a1.agregarHijoIzquierdo(a2);
        a1.agregarHijoDerecho(a3);

        a3.agregarHijoIzquierdo(a6);
        a3.agregarHijoDerecho(a7);

        a2.agregarHijoIzquierdo(a4);
        a2.agregarHijoDerecho(a5);

        a4.agregarHijoIzquierdo(a8);
        a4.agregarHijoDerecho(a9);

        a5.agregarHijoIzquierdo(a10);
        a5.agregarHijoDerecho(a11);

        ListaGenerica<Integer> l;
        Main ej10 = new Main();

        l = ej10.resolver(a1);

        l.comenzar();
        while(!l.fin()){
            System.out.println(l.proximo());
        }

    }
}