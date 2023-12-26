import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp02.ejercicio3.PilaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Main {

    public Integer creciente(ArbolGeneral<Integer> a){
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        cola.encolar(a);
        int nodoMax = -1;
        int nivel = 0;
        int nodos = 0;
        int hijosMax = -1;
        cola.encolar(null);
        while(!cola.esVacia()){
            ArbolGeneral<Integer> aAux;
            aAux = cola.desencolar();
            if (!cola.esVacia() && aAux!=null){
                nodos++;
                if(aAux.tieneHijos()){
                    ListaGenerica<ArbolGeneral<Integer>> lHijos = aAux.getHijos();
                    if(lHijos.tamanio() > hijosMax){
                        hijosMax = lHijos.tamanio();
                        nodoMax = aAux.getDato();
                    }
                    while(!lHijos.fin()){
                        cola.encolar(lHijos.proximo());
                    }
                }
            }
            else {
                if (!cola.esVacia()) {
                    cola.encolar(null);
                    if (nodos == nivel + 1) {
                        System.out.println("Nodo: " + nodos);
                        System.out.println("Nivel: " + nivel);
                        nodos = 0;
                        nivel++;
                    } else {
                        return null;
                    }
                }
            }
        }

        return nodoMax;
    }

    public static void main(String[] args) {

        ArbolGeneral<Integer> a1 = new ArbolGeneral<>(1);

        ArbolGeneral<Integer> a2 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> a3 = new ArbolGeneral<>(3);

        a1.agregarHijo(a2);
        a1.agregarHijo(a3);

        ArbolGeneral<Integer> a4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> a5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> a6 = new ArbolGeneral<>(6);

        a2.agregarHijo(a4);
        a2.agregarHijo(a5);
        a2.agregarHijo(a6);

        Main ej3 = new Main();

        System.out.println(ej3.creciente(a1));

    }
}