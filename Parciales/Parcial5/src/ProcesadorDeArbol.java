import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

import java.util.LinkedHashMap;

public class ProcesadorDeArbol {
    private ArbolGeneral<Integer> arbol;
    public ProcesadorDeArbol(ArbolGeneral<Integer> arbol){
        this.arbol = arbol;
    }

    public int resolver (ArbolGeneral<Integer> arbol){
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        ListaGenerica<ArbolGeneral<Integer>> listaAux = new ListaEnlazadaGenerica<>();
        int mult = 1;
        int multAux = 0;
        ArbolGeneral<Integer> aAux;
        cola.encolar(arbol);
        cola.encolar(null);

        while(!cola.esVacia()){
            aAux = cola.desencolar();

            if(!cola.esVacia() && aAux!=null){

                if(aAux.tieneHijos()){
                    ListaGenerica<ArbolGeneral<Integer>> lHijos = aAux.getHijos();
                    lHijos.comenzar();
                    while(!lHijos.fin()){
                        ArbolGeneral<Integer> a = lHijos.proximo();
                        cola.encolar(a);
                        mult = mult*a.getDato();
                    }

                }

            }else{
                if(!cola.esVacia()){
                    cola.encolar(null);
                    multAux = mult;
                    mult = 1;
                }
            }
        }
        return multAux;
    }

}
