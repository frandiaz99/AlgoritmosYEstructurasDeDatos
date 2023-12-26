import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
public class Main {

    public static ListaGenerica<Integer> numeroImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();

        if(a.getDato()%2 != 0 && a.getDato() > n){
            lista.agregarFinal(a.getDato());
        }

        if(a.tieneHijos()){
            ListaGenerica<Integer> lAux;
            ListaGenerica<ArbolGeneral<Integer>> lHijos= a.getHijos();

            lHijos.comenzar();
            while(!lHijos.fin()){
                lAux = numeroImparesMayoresQuePreOrden(lHijos.proximo(),n);
                lAux.comenzar();
                while(!lAux.fin()){
                    lista.agregarFinal(lAux.proximo());
                }
            }
        }
        return lista;
    }

    public static ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> lAux;
        ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();

        if(a.tieneHijos()){
            lHijos.comenzar();
            lAux = numerosImparesMayoresQueInOrden(lHijos.proximo(),n);
            lAux.comenzar();
            while(!lAux.fin()){
                lista.agregarFinal(lAux.proximo());
            }
        }

        if(a.getDato()%2 != 0 && a.getDato() > n){
            lista.agregarFinal(a.getDato());
        }

        if(a.tieneHijos()){
            while(!lHijos.fin()){
                lAux = numerosImparesMayoresQueInOrden(lHijos.proximo(),n);
                lAux.comenzar();
                while(!lAux.fin()){
                    lista.agregarFinal(lAux.proximo());
                }
            }

        }

        return lista;
    }

    public static ListaGenerica<Integer> numerosImparesMayoresQuePorNivel(ArbolGeneral<Integer> arbol, Integer n){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        ArbolGeneral<Integer> arbolAux;

        cola.encolar(arbol);
        cola.encolar(null);
        while(!cola.esVacia()){
            arbolAux = cola.desencolar();
           if(!cola.esVacia() && arbolAux != null){

                if (arbolAux.getDato() % 2 != 0 && arbolAux.getDato() > n) {
                    lista.agregarFinal(arbolAux.getDato());
                }
                if (arbolAux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Integer>> lHijos = arbolAux.getHijos();
                       lHijos.comenzar();
                       while (!lHijos.fin()) {
                           cola.encolar(lHijos.proximo());
                       }
                }
                System.out.println("a");
            }
            else if (!cola.esVacia()) {
                cola.encolar(null);
                System.out.println("b");
            }

        }
        return lista;
    }

    public static void imprimirLista(ListaGenerica<Integer> l){
        l.comenzar();
        while(!l.fin()){
            System.out.print(l.proximo() + " | ");
        }
    }

    public static void main(String[] args){

        ArbolGeneral<Integer> a1 = new ArbolGeneral <Integer>(1);
        ArbolGeneral<Integer> a2 = new ArbolGeneral <Integer>(3);
        ArbolGeneral<Integer> a3 = new ArbolGeneral <Integer>(4);
        ArbolGeneral<Integer> a4 = new ArbolGeneral <Integer>(7);
        ArbolGeneral<Integer> a5 = new ArbolGeneral <Integer>(5);
        ArbolGeneral<Integer> a6 = new ArbolGeneral <Integer>(6);
        ArbolGeneral<Integer> a7 = new ArbolGeneral <Integer>(9);
        ArbolGeneral<Integer> a8 = new ArbolGeneral <Integer>(11);

        ListaGenerica<ArbolGeneral<Integer>> hijos1 = new ListaEnlazadaGenerica<>();

        hijos1.agregarFinal(a2);
        hijos1.agregarFinal(a3);
        hijos1.agregarFinal(a4);

        a1.setHijos(hijos1);

        ListaGenerica<ArbolGeneral<Integer>> hijos2 = new ListaEnlazadaGenerica<>();

        hijos2.agregarFinal(a5);
        hijos2.agregarFinal(a6);
        hijos2.agregarFinal(a7);

        a2.setHijos(hijos2);

        a4.agregarHijo(a8);

        //        1
        //      / | \
        //     3  4  7
        //    /|\     \
        //   5 6 9    11

        ListaGenerica<Integer> listaPreOrden = numeroImparesMayoresQuePreOrden(a1,0);

        System.out.print("Pre Orden: ");
        imprimirLista(listaPreOrden);
        System.out.println();
        ListaGenerica<Integer> listaInOrden = numerosImparesMayoresQueInOrden(a1,0);
        System.out.print("In Orden: ");
        imprimirLista(listaInOrden);
        System.out.println();
        ListaGenerica<Integer> listaPorNivel = numerosImparesMayoresQuePorNivel(a1,0);
        System.out.print("Por Nivel: ");
        imprimirLista(listaPorNivel);



    }
}