import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Main {


    public static void main(String[] args) {

        ArbolBinario<Integer> a10 = new ArbolBinario<>(10);

        ArbolBinario<Integer> a6 = new ArbolBinario<>(6);
        ArbolBinario<Integer> a2 = new ArbolBinario<>(2);

        ArbolBinario<Integer> a1 = new ArbolBinario<>(1);
        ArbolBinario<Integer> a9 = new ArbolBinario<>(9);
        ArbolBinario<Integer> a8 = new ArbolBinario<>(8);
        ArbolBinario<Integer> a3 = new ArbolBinario<>(3);

        ArbolBinario<Integer> a20 = new ArbolBinario<>(20);
        ArbolBinario<Integer> a11 = new ArbolBinario<>(11);
        ArbolBinario<Integer> a5 = new ArbolBinario<>(5);
        ArbolBinario<Integer> b2 = new ArbolBinario<>(2);
        ArbolBinario<Integer> a4 = new ArbolBinario<>(4);

        a10.agregarHijoIzquierdo(a6);
        a10.agregarHijoDerecho(a2);

        a6.agregarHijoIzquierdo(a1);
        a6.agregarHijoDerecho(a9);

        a1.agregarHijoDerecho(a20);

        a9.agregarHijoIzquierdo(a11);
        a9.agregarHijoDerecho(a5);

        a2.agregarHijoIzquierdo(a8);
        a2.agregarHijoDerecho(a3);

        a8.agregarHijoIzquierdo(b2);
        a8.agregarHijoDerecho(a4);

        ProcesadorDeArbol pa = new ProcesadorDeArbol(a10);

        ListaGenerica<ArbolBinario<Integer>> l;
        int v;

        l = pa.procesar().getLista();
        v = pa.procesar().getValor();

        l.comenzar();
        while(!l.fin()){
            System.out.println(l.proximo());
        }
        System.out.println("Valor: " + v);

    }
}