package Parcial2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.*;
public class Parcial {

    public ListaGenerica<Lugar> resolver(Grafo<Lugar> sitios, String origen,int maxTiempo){

        ListaGenerica<Vertice<Lugar>> listaGrafo = sitios.listaDeVertices();
        boolean [] marca = new boolean[listaGrafo.tamanio()+1];

        ListaGenerica<Lugar> camino = new ListaEnlazadaGenerica<>();
        ListaGenerica<Lugar> listaAux = new ListaEnlazadaGenerica<>();

        Vertice<Lugar> v = null;

        listaGrafo.comenzar();
        while(!listaGrafo.fin()){
            Vertice<Lugar> verticeAux = listaGrafo.proximo();

            if(verticeAux.dato().getNombre().equals(origen)){
                v = verticeAux;

            }
        }

        System.out.println("Origen ---> " + v.dato().getNombre());
        if(v!=null){
            resolver(sitios,v,maxTiempo,camino,listaAux,marca);
        }

        return camino;
    }

    // auxTiempo //auxVisitados
    private void resolver (Grafo<Lugar> sitios, Vertice<Lugar> origen, int maxTiempo, ListaGenerica<Lugar> camino, ListaGenerica<Lugar> listaAux, boolean [] marca){

        int auxTiempo = origen.dato().getTiempo();
        System.out.println("Tiempo del lugar --> " + auxTiempo);
        maxTiempo -= auxTiempo;
        System.out.println("Nuevo Tiempo Maximo --> " + maxTiempo);

        marca[origen.getPosicion()] = true;

        listaAux.agregarFinal(origen.dato());
        System.out.println(" -------------- lista Auxiliar --------------");
        listaAux.comenzar();
        while(!listaAux.fin()){
            System.out.println(listaAux.proximo().getNombre());
        }

        if(maxTiempo > 0){
            ListaGenerica<Arista<Lugar>> ady = sitios.listaDeAdyacentes(origen);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<Lugar> arista = ady.proximo();
                Vertice<Lugar> sig = arista.verticeDestino();

                if (!marca[sig.getPosicion()]) {
                    System.out.println("Nuevo vertice ---> " + sig.dato().getNombre());
                    resolver(sitios,sig,maxTiempo,camino,listaAux,marca);

                }
            }
        }
        if(maxTiempo < 0)
            listaAux.eliminarEn(listaAux.tamanio());

        if(listaAux.tamanio() > camino.tamanio()) {
            camino = listaAux.clonar();

            System.out.println(" -------------- lista Camino --------------");
            camino.comenzar();
            while (!camino.fin()) {
                System.out.println(camino.proximo().getNombre());
            }
        }

        marca[origen.getPosicion()] = false;
        listaAux.eliminarEn(listaAux.tamanio());
    }
}
