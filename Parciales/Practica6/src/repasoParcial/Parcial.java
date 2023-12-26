package repasoParcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {

    public ListaGenerica<sub20> resolver(Grafo<String>sitios, String origen, String destino, ListaGenerica<String> evitarPasarPor){



        ListaGenerica<Vertice<String>> vertices = sitios.listaDeVertices();

        boolean [] marca = new boolean[vertices.tamanio()+1];
        ListaGenerica<sub20> caminos = new ListaEnlazadaGenerica<>();
        ListaGenerica<String> listaAux = new ListaEnlazadaGenerica<>();
        int auxCuadras = 0;

        Vertice<String> o = null, d = null;

        vertices.comenzar();
        while(!vertices.fin()) {
            Vertice<String> aux = vertices.proximo();
            if (aux.dato().equals(origen)) {
                o = aux;

            }

            else if (aux.dato().equals(destino)) {
                d = aux;

            }
            else {
                evitarPasarPor.comenzar();
                while (!evitarPasarPor.fin()) {
                    if (aux.dato() == evitarPasarPor.proximo()) {
                        marca[aux.getPosicion()] = true;

                    }
                }
            }
        }

        if(o != null && d != null){
            resolver(sitios,o,d,marca,caminos,listaAux,auxCuadras);
        }

        return caminos;
    }


    private void resolver(Grafo<String>sitios, Vertice<String> origen, Vertice<String> destino, boolean [] marca, ListaGenerica<sub20> caminos, ListaGenerica<String> listaAux ,int auxCuadras){

        sub20 s20 = new sub20();

        marca[origen.getPosicion()] = true;

        listaAux.agregarFinal(origen.dato());
        System.out.println(" ----------------- lista auxiliar ---------------");
        listaAux.comenzar();
        while(!listaAux.fin())
            System.out.println(listaAux.proximo());

        if(origen == destino){
            s20.setLista(listaAux.clonar());

            ListaGenerica<String> aux = s20.getLista();
            System.out.println("Lista sub 20 ---->");
            aux.comenzar();
            while(!aux.fin()){
                System.out.print("| "+ aux.proximo() +" |");
            }

            s20.setCuadras(auxCuadras);

            System.out.println("Cuadras ---> " + s20.getCuadras());

            caminos.agregarFinal(s20);

        }
        else {
            ListaGenerica<Arista<String>> ady = sitios.listaDeAdyacentes(origen);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();

                if(!marca[sig.getPosicion()]) {
                    auxCuadras+= arista.peso();
                    System.out.println("------ > " + s20.getCuadras());
                    resolver(sitios, sig, destino, marca, caminos, listaAux, auxCuadras);
                    auxCuadras-= arista.peso();
                }
            }

        }
        marca[origen.getPosicion()] = false;
        listaAux.eliminarEn(listaAux.tamanio());

        System.out.println(" ----------------- lista auxiliar eliminacion---------------");
        listaAux.comenzar();
        while(!listaAux.fin())
            System.out.println(listaAux.proximo());
    }
}
