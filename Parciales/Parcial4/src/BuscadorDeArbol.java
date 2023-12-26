import tp03.ejercicio1.ArbolBinario;

import java.sql.SQLIntegrityConstraintViolationException;

public class BuscadorDeArbol {
    private ArbolBinario<Integer> a;

    public BuscadorDeArbol(ArbolBinario<Integer> a){
        this.a=a;
    }

    public ArbolBinario<Integer> getArbol(){
        return a;
    }

    public int buscar(){
        int prof = 0;

        return buscar(this.a, prof);
    }

    private int buscar(ArbolBinario<Integer> a, int prof) {
        int maxElement = a.getDato();
        int maxIzq = 0;
        int maxDer = 0;
        int maxProf = prof;

        System.out.println("maxElement: " + maxElement);
        System.out.println("maxProf: " + prof);

        if(a.tieneHijoIzquierdo()){
            maxIzq = buscar(a.getHijoIzquierdo(),(prof+1));
            System.out.println("maxIzq: " + maxIzq);
        }

        if(a.tieneHijoDerecho()){
            maxDer = buscar(a.getHijoDerecho(),(prof+1));
            System.out.println("maxDer: " + maxDer);
        }

        if (maxIzq != 0 && ((prof + 1) >= maxProf)) {
            System.out.println("prof: " + (prof+1));
            System.out.println("maxProf: " + maxProf);
            maxElement = maxIzq;
            System.out.println("maxElement: ----> " + maxElement);
            maxProf = (prof + 1);
            System.out.println("maxProf: " + maxProf);
        }

        if (maxDer != 0 && ((prof + 1) >= maxProf)) {
            System.out.println("prof: " + (prof+1));
            System.out.println("maxProf: " + maxProf);
            maxElement = maxDer;
            System.out.println("maxElement: ----> " + maxElement);
            maxProf = (prof + 1);
            System.out.println("maxProf: " + maxProf);
        }

        if(a.esHoja()){
            return a.getDato();
        }

        return maxElement;
    }
}
