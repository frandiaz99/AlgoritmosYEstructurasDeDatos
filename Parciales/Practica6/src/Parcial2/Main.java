package Parcial2;

import repasoParcial.sub20;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo<Lugar> grafo = new GrafoImplListAdy<>();

        Lugar l1 = new Lugar("Estadio Diego Armando Maradona",30);
        Lugar l2 = new Lugar("Legislatura",20);
        Lugar l3 = new Lugar("Coliseo Podesta",50);
        Lugar l4 = new Lugar("MACLA",120);
        Lugar l5 = new Lugar("Catedral",60);
        Lugar l6 = new Lugar("Palacio Campodonico",40);
        Lugar l7 = new Lugar("Rectorado UNLP",45);
        Lugar l8 = new Lugar("Museo",200);

        Vertice<Lugar> maradona = new VerticeImplListAdy<>(l1);
        Vertice<Lugar> legislatura = new VerticeImplListAdy<>(l2);
        Vertice<Lugar> coliseo = new VerticeImplListAdy<>(l3);
        Vertice<Lugar> macla = new VerticeImplListAdy<>(l4);
        Vertice<Lugar> catedral = new VerticeImplListAdy<>(l5);
        Vertice<Lugar> palacio = new VerticeImplListAdy<>(l6);
        Vertice<Lugar> rectorado = new VerticeImplListAdy<>(l7);
        Vertice<Lugar> museo = new VerticeImplListAdy<>(l8);

        grafo.agregarVertice(maradona);
        grafo.agregarVertice(legislatura);
        grafo.agregarVertice(coliseo);
        grafo.agregarVertice(macla);
        grafo.agregarVertice(catedral);
        grafo.agregarVertice(palacio);
        grafo.agregarVertice(rectorado);
        grafo.agregarVertice(museo);

        grafo.conectar(maradona,legislatura);
        grafo.conectar(legislatura,maradona);
        grafo.conectar(maradona,coliseo);
        grafo.conectar(coliseo,maradona);
        grafo.conectar(maradona,macla);
        grafo.conectar(macla,maradona);
        grafo.conectar(maradona,catedral);
        grafo.conectar(catedral,maradona);

        grafo.conectar(legislatura,coliseo);
        grafo.conectar(coliseo,legislatura);
        grafo.conectar(coliseo,palacio);
        grafo.conectar(palacio,coliseo);
        grafo.conectar(macla,catedral);
        grafo.conectar(catedral,macla);
        grafo.conectar(catedral,rectorado);
        grafo.conectar(rectorado,catedral);
        grafo.conectar(rectorado,palacio);
        grafo.conectar(palacio,rectorado);
        grafo.conectar(rectorado,museo);
        grafo.conectar(museo,rectorado);

        Parcial p = new Parcial();

        ListaGenerica<Lugar> aux = new ListaEnlazadaGenerica<>();

        aux = p.resolver(grafo,"Estadio Diego Armando Maradona",140);

        System.out.print("Camino --> ");
        aux.comenzar();
        while(!aux.fin()){
            System.out.println(aux.proximo().getNombre());
        }
    }
}
