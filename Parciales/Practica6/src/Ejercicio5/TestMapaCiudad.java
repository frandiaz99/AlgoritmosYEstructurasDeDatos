package Ejercicio5;

import tp06.ejercicio3.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class TestMapaCiudad {
    public static void main(String[] args){

        //Paso 1 - Creacion del Grafo
        Grafo<String> grafo2 = new GrafoImplListAdy<>();

        //Paso 2 - Creacion de los nodos (vertices)
        Vertice<String> BuenosAires = new VerticeImplListAdy<>("Buenos Aires");
        Vertice<String> LaPlata = new VerticeImplListAdy<>("La Plata");
        Vertice<String> Tokyo = new VerticeImplListAdy<>("Tokyo");
        Vertice<String> Berlin = new VerticeImplListAdy<>("Berlin");
        Vertice<String> Cordoba = new VerticeImplListAdy<>("Cordoba");
        Vertice<String> Paris = new VerticeImplListAdy<>("Paris");
        Vertice<String> Dubai = new VerticeImplListAdy<>("Dubai");

        //Paso 3 - Agregar vertices a la lista de vertices del grafo
        grafo2.agregarVertice(BuenosAires);
        grafo2.agregarVertice(LaPlata);
        grafo2.agregarVertice(Tokyo);
        grafo2.agregarVertice(Berlin);
        grafo2.agregarVertice(Cordoba);
        grafo2.agregarVertice(Paris);
        grafo2.agregarVertice(Dubai);

        //Paso 4 - conectar los vertices
        grafo2.conectar(BuenosAires,LaPlata,10);
        grafo2.conectar(BuenosAires,Berlin,20);
        grafo2.conectar(LaPlata,Tokyo,40);
        grafo2.conectar(Tokyo,Cordoba,50);
        grafo2.conectar(Berlin,LaPlata,20);
        grafo2.conectar(LaPlata,Berlin,20);
        grafo2.conectar(Berlin,Cordoba,60);
        grafo2.conectar(BuenosAires,Dubai,56);
        grafo2.conectar(Cordoba,Paris,78);


        Mapa m = new Mapa(grafo2);

        System.out.println(" - devolverCamino - ");
        ListaGenerica<String> l1 = m.devolverCamino("Buenos Aires", "Cordoba");
        l1.comenzar();
        while(!l1.fin()){
            System.out.println("--> " + l1.proximo());
        }

        // -------------------------------------------------------------------------------------------- //
        System.out.println();
        System.out.println(" ------------------------------ ");
        System.out.println();
        // -------------------------------------------------------------------------------------------- //
        System.out.println();
        System.out.println(" - devolverCaminoExceptuando - ");

        ListaGenerica<String> noAceptados = new ListaEnlazadaGenerica<>();
        noAceptados.agregarFinal("La Plata");
        noAceptados.agregarFinal("Tokyo");

        ListaGenerica<String> l2 = m.devolverCaminoExceptuando("Buenos Aires", "Cordoba", noAceptados);
        l2.comenzar();
        while(!l2.fin()){
            System.out.println("--> " + l2.proximo());
        }

        // -------------------------------------------------------------------------------------------- //
        System.out.println();
        System.out.println(" ------------------------------ ");
        System.out.println();
        // -------------------------------------------------------------------------------------------- //

        System.out.println();
        System.out.println(" - caminoMasCortoVertice - ");

        ListaGenerica<String> l3 = m.caminoMasCortoVertices("Buenos Aires", "Cordoba");
        l3.comenzar();
        while(!l3.fin()){
            System.out.println("--> " + l3.proximo());
        }

        // -------------------------------------------------------------------------------------------- //
        System.out.println();
        System.out.println(" ------------------------------ ");
        System.out.println();
        // -------------------------------------------------------------------------------------------- //

        System.out.println();
        System.out.println(" - caminoMasCortoPeso - ");

        ListaGenerica<String> l4 = m.caminoMasCortoPeso("Buenos Aires", "Cordoba");
        l4.comenzar();
        while(!l4.fin()){
            System.out.println("--> " + l4.proximo());
        }

        // -------------------------------------------------------------------------------------------- //
        System.out.println();
        System.out.println(" ------------------------------ ");
        System.out.println();
        // -------------------------------------------------------------------------------------------- //

        System.out.println();
        System.out.println(" - caminoSinCargarCombustible - ");

        ListaGenerica<String> l5 = m.caminoSinCargarCombustible("Buenos Aires", "Cordoba",90);
        l5.comenzar();
        while(!l5.fin()){
            System.out.println("--> " + l5.proximo());
        }
    }
}
