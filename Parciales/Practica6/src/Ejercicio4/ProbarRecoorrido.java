package Ejercicio5;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.*;
public class ProbarRecoorrido {

    public static void main(String[] arg){

        //Paso 1 - Creacion de los nodos (vertices)
        VerticeImplListAdy<Integer> v1 = new VerticeImplListAdy<>(1);
        VerticeImplListAdy<Integer> v2 = new VerticeImplListAdy<>(2);
        VerticeImplListAdy<Integer> v3 = new VerticeImplListAdy<>(3);

        //Paso 2 - Creacion del Grafo
        Grafo<Integer> grafo = new GrafoImplListAdy<>();

        //Paso 3 - Agregar vertices a la lista de vertices del grafo
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);

        //Paso 4 - conectar los vertices
        grafo.conectar(v1, v2);
        grafo.conectar(v1, v3);
        grafo.conectar(v2, v3);
        grafo.conectar(v3, v2);

        ListaGenerica<Vertice<Integer>> l;

        Ejercicio5.Recorridos r = new Ejercicio5.Recorridos();

        l = r.dfs(grafo);

        l.comenzar();
        while(!l.fin()){
            System.out.println("-->" + l.proximo().dato());
        }


    }
}
