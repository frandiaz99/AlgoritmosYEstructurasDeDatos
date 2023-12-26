import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
    private ArbolGeneral<Integer> arbol;

    public Parcial(ArbolGeneral<Integer> arbol) {
        this.arbol = arbol;
    }

    public ArbolGeneral<Integer> getArbol() {
        return arbol;
    }

    public ListaGenerica<Integer> resolver() {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica<>();
        ArbolGeneral<Integer> a = this.arbol;
        if(!a.esVacio())
            resolver(a,l);

        return l;
    }

    private int resolver(ArbolGeneral<Integer> a, ListaGenerica<Integer> l) {
        int cantHijos = 0;
        int sumHijos = 0;

        if (a.tieneHijos()) {
            ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
            lHijos.comenzar();
            while (!lHijos.fin()) {
                    cantHijos++;
                    sumHijos += resolver(lHijos.proximo(),l);
            }
            System.out.println("Nodo: " + a.getDato() + " | Hijos: " + cantHijos + " | Suma: " + sumHijos);
        }

        if((cantHijos%2 != 0) && !a.esHoja()){
            l.agregarFinal(sumHijos);
            l.comenzar();
            while(!l.fin()){
                System.out.print(" | " + l.proximo());
            }
            System.out.println();
        }

        return a.getDato();
    }
}
