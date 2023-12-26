package repasoParcial;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.*;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new GrafoImplListAdy<>();

        Vertice<String> maradona = new VerticeImplListAdy<>("Estadio Diego Armando Maradona");
        Vertice<String> legislatura = new VerticeImplListAdy<>("Legislatura");
        Vertice<String> coliseo = new VerticeImplListAdy<>("Coliseo Podesta");
        Vertice<String> macla = new VerticeImplListAdy<>("MACLA");
        Vertice<String> catedral = new VerticeImplListAdy<>("Catedral");
        Vertice<String> palacio = new VerticeImplListAdy<>("Palacio Campodonico");
        Vertice<String> rectorado = new VerticeImplListAdy<>("Rectorado UNLP");
        Vertice<String> museo = new VerticeImplListAdy<>("Museo");

        grafo.agregarVertice(maradona);
        grafo.agregarVertice(legislatura);
        grafo.agregarVertice(coliseo);
        grafo.agregarVertice(macla);
        grafo.agregarVertice(catedral);
        grafo.agregarVertice(palacio);
        grafo.agregarVertice(rectorado);
        grafo.agregarVertice(museo);

        grafo.conectar(maradona,legislatura,25);
        grafo.conectar(maradona,coliseo,20);
        grafo.conectar(maradona,macla,35);
        grafo.conectar(maradona,catedral,40);

        grafo.conectar(legislatura,coliseo,25);
        grafo.conectar(coliseo,palacio,10);
        grafo.conectar(macla,catedral,8);
        grafo.conectar(catedral,rectorado,5);
        grafo.conectar(rectorado,palacio,30);
        grafo.conectar(rectorado,museo,15);

        Parcial p = new Parcial();
        ListaGenerica<String> noEntran = new ListaEnlazadaGenerica<>();
        noEntran.agregarFinal("Legislatura");
        noEntran.agregarFinal("MACLA");

        ListaGenerica<sub20> s20;

        s20 = p.resolver(grafo,"Estadio Diego Armando Maradona","Palacio Campodonico",noEntran);

        s20.comenzar();
        while(!s20.fin()){
            sub20 aux20 = s20.proximo();
            ListaGenerica<String> aux = aux20.getLista();
            aux.comenzar();
            while(!aux.fin()){
                System.out.print("| "+ aux.proximo() +" |");
            }

            System.out.println("Distancia: " + aux20.getCuadras());
        }
    }
}