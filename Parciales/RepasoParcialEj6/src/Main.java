import tp02.ejercicio3.ColaGenerica;

import tp03.ejercicio1.ArbolBinario;

import javax.swing.event.InternalFrameEvent;

public class Main {
    public ArbolBinario<Integer> minEnNivelAB(int n, ArbolBinario<Integer> a){
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>();
        ArbolBinario<Integer> aux;
        int nivel = 0;
        int min = 9999;
        ArbolBinario<Integer> minAb = null;

        cola.encolar(a);
        cola.encolar(null);

        while(!cola.esVacia()) {
            aux = cola.desencolar();

            if (!cola.esVacia() && aux != null) {

                if((nivel == n) && aux.esHoja()) {
                    if(min > aux.getDato()){
                        min = aux.getDato();
                        minAb = aux;

                    }
                }

                if (aux.tieneHijoIzquierdo()) {
                    cola.encolar(aux.getHijoIzquierdo());
                }
                if (aux.tieneHijoDerecho()) {
                    cola.encolar(aux.getHijoDerecho());
                }
            } else {
                if (!cola.esVacia()) {
                    if(nivel == n){
                        return minAb;
                    }
                    nivel++;
                    cola.encolar(null);


                }
            }
        }
        return minAb;
    }


    public static void main(String[] args) {

        ArbolBinario<Integer> a = new ArbolBinario<>(2);
        ArbolBinario<Integer> a1 = new ArbolBinario<>(7);
        ArbolBinario<Integer> a2= new ArbolBinario<>(5);
        ArbolBinario<Integer> a3= new ArbolBinario<>(2);
        ArbolBinario<Integer> a4= new ArbolBinario<>(6);
        ArbolBinario<Integer> a5= new ArbolBinario<>(9);
        ArbolBinario<Integer> a6= new ArbolBinario<>(5);
        ArbolBinario<Integer> a7= new ArbolBinario<>(11);
        ArbolBinario <Integer> a8= new ArbolBinario<>(4);

        a.agregarHijoIzquierdo(a1);
        a.agregarHijoDerecho(a2);

        a1.agregarHijoIzquierdo(a3);
        a1.agregarHijoDerecho(a4);

        a2.agregarHijoDerecho(a5);

        a4.agregarHijoIzquierdo(a6);
        a4.agregarHijoDerecho(a7);

        a5.agregarHijoIzquierdo(a8);

        Main ej6 = new Main();

        System.out.print(ej6.minEnNivelAB(1,a));

    }
}