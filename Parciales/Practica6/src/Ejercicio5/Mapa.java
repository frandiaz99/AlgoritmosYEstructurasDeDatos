package Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.*;
public class Mapa {

    private Grafo<String> grafo;

    public Mapa(Grafo<String> grafo){
        this.grafo = grafo;
    }

    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){

        boolean [] marca = new boolean [grafo.listaDeVertices().tamanio()+1];

        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();

        Vertice<String> origen = null, destino = null;
        grafo.listaDeVertices().comenzar();
        while(!grafo.listaDeVertices().fin()){
            Vertice<String> actual = grafo.listaDeVertices().proximo();
            if(actual.dato().equals(ciudad1)){
                origen = actual;
            }
            else if(actual.dato().equals(ciudad2)){
                destino = actual;
            }
        }
        if((origen!=null) && (destino!=null)){
            devolverCamino(origen,destino,camino,marca);
        }
        return camino;
    }

    private boolean devolverCamino(Vertice<String> origen, Vertice<String> destino, ListaGenerica<String> camino, boolean[] marca){

        marca[origen.getPosicion()] = true;
        camino.agregarFinal(origen.dato());

        if(origen == destino){
            return true;
        }else{
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                if(!marca[sig.getPosicion()]){
                    boolean resultado = devolverCamino(sig,destino,camino,marca);
                    if(resultado){
                        return true;
                    }
                }
            }
        }
        camino.eliminarEn(camino.tamanio());
        return false;
    }

    // ----------------------------------------------------------------------------------- //

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){

        boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();

        Vertice<String> origen = null, destino = null;

        grafo.listaDeVertices().comenzar();
        while(!grafo.listaDeVertices().fin()){
            Vertice<String> actual = grafo.listaDeVertices().proximo();

            if(actual.dato().equals(ciudad1)){
                origen = actual;

            }
            if(actual.dato().equals(ciudad2)){
                destino = actual;

            }
        }

        if((origen != null) && (destino != null)){
            devolverCaminoExceptuando(origen,destino,ciudades,camino,marca);
        }
        return camino;
    }

    private boolean devolverCaminoExceptuando(Vertice<String> origen, Vertice<String> destino, ListaGenerica<String> ciudades, ListaGenerica<String> camino, boolean [] marca) {

        boolean resultado = false;
        boolean puedeVisitarse = true;
        marca[origen.getPosicion()] = true;
        ciudades.comenzar();
        while (!ciudades.fin()) {
            if (ciudades.proximo().equals(origen.dato())) {
                puedeVisitarse = false;
            }
        }
        if (puedeVisitarse == true) {

            camino.agregarFinal(origen.dato());

            if(origen.dato() == destino.dato()){
                return true;
            }

            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();

                if (!marca[sig.getPosicion()]) {
                    resultado = devolverCaminoExceptuando(sig, destino, ciudades, camino, marca);
                    if(resultado)
                        return true;
                }
            }
        }
        return false;
    }

    public ListaGenerica<String> caminoMasCortoVertices(String ciudad1, String ciudad2){
        boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        ListaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>();
        int cont = 0;
        int contMin = 999;
        Vertice<String> origen = null, destino = null;

        grafo.listaDeVertices().comenzar();
        while(!grafo.listaDeVertices().fin()){
            Vertice<String> actual = grafo.listaDeVertices().proximo();
            if(actual.dato().equals(ciudad1)){
                origen = actual;

            }
            if(actual.dato().equals(ciudad2)){
                destino = actual;

            }
        }
        if(origen!=null & destino != null){
            caminoMasCortoVertices(origen,destino,camino,caminoAux,marca,cont,contMin);
        }

        return camino;
    }

    private void caminoMasCortoVertices(Vertice<String> origen, Vertice<String> destino, ListaGenerica<String> camino,ListaGenerica<String> caminoAux, boolean [] marca, int cont, int contMin) {
        marca[origen.getPosicion()] = true;

        caminoAux.agregarFinal(origen.dato());


        if (origen.dato().equals(destino.dato())) {

            if (cont < contMin) {
                camino.comenzar();
                while(!camino.esVacia()){
                    camino.eliminarEn(camino.tamanio());
                }
                caminoAux.comenzar();
                while (!caminoAux.fin()) {
                    camino.agregarFinal(caminoAux.proximo());
                }
                contMin = cont;
            }
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();

                if (!marca[sig.getPosicion()]) {
                    cont++;
                    caminoMasCortoVertices(sig, destino, camino, caminoAux, marca, cont,contMin);
                    cont--;
                }
            }
        }
        caminoAux.eliminarEn(caminoAux.tamanio());
        marca[origen.getPosicion()] = false;
    }

    public ListaGenerica<String> caminoMasCortoPeso(String ciudad1, String ciudad2){
        boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        ListaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>();

        int pesoAux = 0;
        Resultado res = new Resultado();
        Vertice<String> origen = null, destino = null;
        grafo.listaDeVertices().comenzar();
        while(!grafo.listaDeVertices().fin()){
            Vertice<String> actual = grafo.listaDeVertices().proximo();
            if(actual.dato().equals(ciudad1)){
                origen = actual;
            }

            if(actual.dato().equals(ciudad2)){
                destino = actual;
            }

        }
        if(origen!=null & destino != null){
            caminoMasCortoPeso(origen,destino,camino,caminoAux,marca,pesoAux,res);
        }
        return camino;
    }

    private void caminoMasCortoPeso(Vertice<String> origen, Vertice<String> destino, ListaGenerica<String> camino,ListaGenerica<String> caminoAux, boolean [] marca, int pesoAux, Resultado res) {

        marca[origen.getPosicion()] = true;

        caminoAux.agregarFinal(origen.dato());

        if (origen == destino) {
            if (pesoAux < res.getResultado()) {

                camino.comenzar();
                while(!camino.esVacia()){
                    camino.eliminarEn(camino.tamanio());
                }
                caminoAux.comenzar();
                while (!caminoAux.fin()) {
                    camino.agregarFinal(caminoAux.proximo());
                }
                res.setResultado(pesoAux);

            }
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                if (!marca[sig.getPosicion()]) {
                    pesoAux += arista.peso();

                    caminoMasCortoPeso(sig, destino, camino, caminoAux, marca, pesoAux, res);

                    pesoAux -= arista.peso();
                }
            }
        }
        caminoAux.eliminarEn(caminoAux.tamanio());
        marca[origen.getPosicion()] = false;
    }

    public class Resultado {
        private int costo = Integer.MAX_VALUE;
        public int getResultado(){
            return costo;
        }
        public void setResultado(int costo){
            this.costo = costo;
        }
    }

    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int combustible){
        boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();

        int pesoAux = 0;
        Resultado res = new Resultado();
        Vertice<String> origen = null, destino = null;
        grafo.listaDeVertices().comenzar();
        while(!grafo.listaDeVertices().fin()){
            Vertice<String> actual = grafo.listaDeVertices().proximo();
            if(actual.dato().equals(ciudad1)){
                origen = actual;
            }

            if(actual.dato().equals(ciudad2)){
                destino = actual;
            }

        }
        if(origen!=null & destino != null){
            caminoSinCargarCombustible(origen,destino,camino,marca,pesoAux,combustible);
        }
        return camino;
    }

    private boolean caminoSinCargarCombustible(Vertice<String> origen, Vertice<String> destino, ListaGenerica<String> camino, boolean [] marca, int pesoAux, int combustible){

        boolean llego = false;
        marca[origen.getPosicion()] = true;
        camino.agregarFinal(origen.dato());

        if(origen == destino){

            return true;
        }else{

            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(origen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                Vertice<String> sig = arista.verticeDestino();
                pesoAux+= arista.peso();
                if(!marca[sig.getPosicion()] & pesoAux <= combustible){
                    llego = caminoSinCargarCombustible(sig,destino,camino,marca,pesoAux,combustible);
                }
                if(!llego)
                    pesoAux-=arista.peso();
                else{
                    return true;
                }
            }
        }

        camino.eliminarEn(camino.tamanio());
        marca[origen.getPosicion()] = false;
        return false;
    }
}
