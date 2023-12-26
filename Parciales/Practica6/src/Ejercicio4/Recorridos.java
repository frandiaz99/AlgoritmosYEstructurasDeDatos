package Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos {
    public ListaGenerica<Vertice<Integer>> dfs (Grafo<Integer> grafo){
        boolean [] marcas = new boolean[grafo.listaDeVertices().tamanio()+1];
        ListaEnlazadaGenerica<Vertice<Integer>> lis = new ListaEnlazadaGenerica<>();

        for (int i=1; i<grafo.listaDeVertices().tamanio();i++){
            if(!marcas[i]){
                this.dfs(i,grafo,lis,marcas);
            }
        }
        System.out.println("aaaaaa");
        return lis;
    }

    private void dfs(int i, Grafo<Integer> grafo, ListaEnlazadaGenerica<Vertice<Integer>> lis, boolean [] marca){
        marca[i] = true;
        Vertice<Integer> v = grafo.listaDeVertices().elemento(i);
        lis.agregarFinal(v);
        ListaGenerica<Arista<Integer>> ady = grafo.listaDeAdyacentes(v);

        ady.comenzar();
        while(!ady.fin()){
            int j = ady.proximo().verticeDestino().getPosicion();
            if(!marca[j]){
                this.dfs(j, grafo, lis,marca);
            }
        }
    }
}
