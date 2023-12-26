package Ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp06.ejercicio3.*;
import tp02.ejercicio2.ListaGenerica;

import java.util.List;

public class VisitaOslo {

    public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
        ListaGenerica<Vertice<String>> grafoVertices = lugares.listaDeVertices();
        boolean [] marca = new boolean[grafoVertices.tamanio()+1];
        int auxValor = 0;
        Resultado res = new Resultado();

        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();

        String lugarOrigen = "Ayuntamiento";

        Vertice<String> auxOrigen = null, auxDestino = null;

        grafoVertices.comenzar();
        while(!grafoVertices.fin()){
            Vertice<String> aux = grafoVertices.proximo();

            if(aux.dato().equals(lugarOrigen)){
                auxOrigen = aux;
            }

            else if(aux.dato().equals(destino)){
                auxDestino = aux;
            }

            else {
                lugaresRestringidos.comenzar();
                while (!lugaresRestringidos.fin()) {
                    if (aux.dato().equals(lugaresRestringidos.proximo())) {
                        marca[aux.getPosicion()] = true;
                        System.out.println("restringido ---> " + aux.dato());
                    }
                }
            }

        }

        if(auxOrigen != null && auxDestino != null)
            paseoEnBici(lugares,auxOrigen,auxDestino,maxTiempo,camino,marca,auxValor);

        return camino;

    }

    private boolean paseoEnBici(Grafo<String> lugares, Vertice<String> origen, Vertice<String> destino, int maxTiempo, ListaGenerica<String> camino, boolean [] marca,int auxValor){

        boolean termino = false;

        marca[origen.getPosicion()] = true;

        camino.agregarFinal(origen.dato());

        System.out.println(" ----------------- camino ---------------- ");
        camino.comenzar();
        while(!camino.fin()){
            System.out.println(camino.proximo());
        }

        if(origen == destino){
            return true;
        }else{
            ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(origen);

            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();

                auxValor+= arista.peso();
                if(!marca[sig.getPosicion()] && (maxTiempo - auxValor) >= 0){

                    //res.setValor(arista.peso() + res.getValor());
                    //System.out.println("Valor Suma Aristas ---> " + res.getValor());
                    //System.out.println("Tiempo -> " + (maxTiempo - res.getValor()));
                    termino = paseoEnBici(lugares,sig,destino,maxTiempo,camino,marca,auxValor);

                }
                if(!termino){
                    auxValor-= arista.peso();
                }
            }
        }

        if(!termino) {
            camino.eliminarEn(camino.tamanio());
            marca[origen.getPosicion()] = false;
        }


        return termino;
    }

    public class Resultado{
        private int valor = 0;

        public Resultado(){
            this.valor = 0;
        }
        public void setValor(int valor){
            this.valor = valor;
        }

        public int getValor(){
            return valor;
        }
    }

}
