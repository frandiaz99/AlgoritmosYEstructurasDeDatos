
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

import java.lang.reflect.AccessibleObject;

public class Main {

    public ListaGenerica<String> buscarCamino(ArbolGeneral<Palabra> arbol){
        ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
        recorrer(arbol,lista);
        return lista;
    }

    public void recorrer(ArbolGeneral<Palabra> a, ListaGenerica<String> l){

        if(!a.esVacio()){
            l.agregarFinal(a.getDato().getValor());
        }
        if(a.tieneHijos()){
            recorrer(a.getHijos().elemento(a.getDato().getSig()),l);
        }
    }

    public static void main(String[] args) {

        ArbolGeneral<Palabra> Arbol = new ArbolGeneral<Palabra>(new Palabra("G", 1));
        ArbolGeneral<Palabra> Arbol2 = new ArbolGeneral<Palabra>(new Palabra("E", 3));
        ArbolGeneral<Palabra> Arbol3 = new ArbolGeneral<Palabra>(new Palabra("F", 2));
        ArbolGeneral<Palabra> Arbol4 = new ArbolGeneral<Palabra>(new Palabra("J", 5));

        Arbol2.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("A", 7)));
        Arbol2.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("B", 9)));
        Arbol2.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("C", 6)));

        Arbol3.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("D", 10)));

        Arbol4.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("H", 6)));
        Arbol4.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("I", 10)));

        Arbol.agregarHijo(Arbol2);
        Arbol.agregarHijo(Arbol3);
        Arbol.agregarHijo(Arbol4);

        Main main = new Main();

        System.out.println(main.buscarCamino(Arbol));



    }
}