import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {

    public ListaGenerica<sub20> resolver(Grafo<String>sitios, String origen, String destino, ListaGenerica<String> evitarPasarPor){

        sub20 s20 = new sub20();

        ListaGenerica<Vertice<String>> vertices = sitios.listaDeVertices();

        boolean [] marca = new boolean[vertices.tamanio()-1];
        ListaGenerica<sub20> caminos = new ListaEnlazadaGenerica<>();

        Vertice<String> o = null, d = null;

        vertices.comenzar();
        while(!vertices.fin()) {
            Vertice<String> aux = vertices.proximo();
            if (aux.dato().equals(origen)) {
                o.equals(aux);
            }

            else if (aux.dato().equals(destino)) {
                d.equals(aux);
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

        if(o != null & d != null){
            resolver(sitios,o,d,marca,s20,caminos);
        }

        return caminos;
    }


    private void resolver(Grafo<String>sitios, Vertice<String> origen, Vertice<String> destino, boolean [] marca, sub20 s20, ListaGenerica<sub20> caminos){

        marca[origen.getPosicion()] = true;

        s20.agregarALista(origen.dato());

        if(origen == destino){
            s20.setLista(s20.getLista());
            caminos.agregarFinal(s20);
        }
        else {
            ListaGenerica<Arista<String>> ady = sitios.listaDeAdyacentes(origen);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();

                s20.aumentarDistancia(arista.peso());
            }

        }
        s20.getLista().eliminarEn(s20.getLista().tamanio());
    }
}
