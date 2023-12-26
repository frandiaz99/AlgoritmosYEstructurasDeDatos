import tp03.ejercicio1.ArbolBinario;

public class Main {
    public static void main(String[] args) {

        ArbolBinario<Integer> a20 = new ArbolBinario<>(20);
        ArbolBinario<Integer> a7 = new ArbolBinario<>(7);
        ArbolBinario<Integer> a15 = new ArbolBinario<>(15);
        ArbolBinario<Integer> a12 = new ArbolBinario<>(12);
        ArbolBinario<Integer> a6 = new ArbolBinario<>(6);
        ArbolBinario<Integer> a10 = new ArbolBinario<>(10);
        ArbolBinario<Integer> a13 = new ArbolBinario<>(13);
        ArbolBinario<Integer> a11 = new ArbolBinario<>(11);
        ArbolBinario<Integer> a40 = new ArbolBinario<>(40);
        ArbolBinario<Integer> a34 = new ArbolBinario<>(34);

        a20.agregarHijoIzquierdo(a7);
        a20.agregarHijoDerecho(a15);

        a7.agregarHijoIzquierdo(a12);
        a7.agregarHijoDerecho(a6);

        a6.agregarHijoIzquierdo(a13);
        a6.agregarHijoDerecho(a11);

        a11.agregarHijoDerecho(a34);

        a15.agregarHijoDerecho(a10);
        a10.agregarHijoIzquierdo(a40);

        BuscadorDeArbol bus = new BuscadorDeArbol(a20);

        System.out.println(bus.buscar());


    }
}