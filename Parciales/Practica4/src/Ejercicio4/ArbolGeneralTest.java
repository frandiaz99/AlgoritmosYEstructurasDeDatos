package Ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

import java.util.Optional;

public class ArbolGeneralTest {

    public static void main(String[] args){

        ArbolGeneral<Integer> a1 = new ArbolGeneral <Integer>(1);
        ArbolGeneral<Integer> a2 = new ArbolGeneral <Integer>(3);
        ArbolGeneral<Integer> a3 = new ArbolGeneral <Integer>(4);
        ArbolGeneral<Integer> a4 = new ArbolGeneral <Integer>(7);
        ArbolGeneral<Integer> a5 = new ArbolGeneral <Integer>(5);
        ArbolGeneral<Integer> a6 = new ArbolGeneral <Integer>(6);
        ArbolGeneral<Integer> a7 = new ArbolGeneral <Integer>(9);
        ArbolGeneral<Integer> a8 = new ArbolGeneral <Integer>(11);
        ArbolGeneral<Integer> a9 = new ArbolGeneral <Integer>(14);

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

        a7.agregarHijo(a9);

        //        1
        //      / | \
        //     3  4  7
        //    /|\     \
        //   5 6 9    11
        //        \
        //        14


        System.out.println("Altura del arbol: " + a1.altura());
        System.out.println("Nivel del dato " + 1 + " es: " + a1.nivel(1));
        System.out.println("Ancho: " + a1.ancho());

        System.out.println(a1.esAncesto(1,6));




    }

}
