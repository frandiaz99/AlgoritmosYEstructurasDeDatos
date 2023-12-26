import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

import javax.swing.*;
import java.lang.invoke.LambdaMetafactory;
import java.util.List;

public class Main {

    public ListaGenerica<Integer> resolver (ArbolGeneral<Integer> a){
        ListaGenerica<Integer> lAux = new ListaEnlazadaGenerica<>();
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica<>();

        if(!a.esVacio()){
            l = resolver(a,lAux);
        }

        return l;
    }

    private ListaGenerica<Integer> resolver(ArbolGeneral<Integer> a, ListaGenerica<Integer> l){
        ListaGenerica<Integer> lAux;

        lAux.agregarFinal(a.getDato());

        if(a.tieneHijos()){
            ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
            while(!lHijos.fin()){
                lAux= resolver(lHijos.proximo(),l);
            }
        }

        if(a.esHoja()){
            if()
        }

        return l;
    }

    public static void main(String[] args) {

        ArbolGeneral<Integer> a8 = new ArbolGeneral<>(8);
        ArbolGeneral<Integer> a3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> a5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> a4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> a7 = new ArbolGeneral<>(7);
        ArbolGeneral<Integer> a6 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> a1 = new ArbolGeneral<>(1);
        ArbolGeneral<Integer> a9 = new ArbolGeneral<>(9);
        ArbolGeneral<Integer> a10 = new ArbolGeneral<>(10);
        ArbolGeneral<Integer> a2 = new ArbolGeneral<>(2);

        a8.agregarHijo(a3);
        a8.agregarHijo(a5);

        a3.agregarHijo(a4);
        a3.agregarHijo(a7);
        a3.agregarHijo(a6);

        a7.agregarHijo(a2);

        a5.agregarHijo(a1);
        a5.agregarHijo(a9);
        a5.agregarHijo(a10);

        Main ej9 = new Main();

        System.out.println(ej9.resolver(a8));

    }
}