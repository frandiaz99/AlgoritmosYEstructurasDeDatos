
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

import java.sql.SQLIntegrityConstraintViolationException;

public class Main {

    public ArbolGeneral<Integer> creciente(ArbolGeneral<Integer> arbol){
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        ArbolGeneral<Integer> aux;
        Integer contAux = 0;
        Integer largoNvl = 1;
        Integer maxHijos = 0;
        ArbolGeneral<Integer> hijoMax= new ArbolGeneral<>(null);

        cola.encolar(arbol);
        cola.encolar(null);

        while(!cola.esVacia()){
            aux = cola.desencolar();
            if(!cola.esVacia() && aux != null){
                ListaGenerica<ArbolGeneral<Integer>> lHijos = aux.getHijos();
                System.out.println("cant. de hijos: " + lHijos.tamanio());
                if(lHijos.tamanio() > maxHijos) {
                    maxHijos = lHijos.tamanio();
                    hijoMax = aux;
                    System.out.println("Nodo con hijos max: " + hijoMax.getDato());

                }
                lHijos.comenzar();
                while(!lHijos.fin()){
                    cola.encolar(lHijos.proximo());
                    contAux +=1;
                    System.out.println("cont Aux: " + contAux);
                }
            }

            else if(!cola.esVacia()){
                cola.encolar(null);
                System.out.println("contAux: " + contAux);
                System.out.println("largoNvl: " + largoNvl);
                largoNvl+=1;
                if(contAux == largoNvl){
                    contAux = 0;
                }
                else {
                    return null;
                }
            }

        }

        return hijoMax;
    }

    public static void main(String[] args) {


        ArbolGeneral<Integer> a = new ArbolGeneral<>(1);

        ArbolGeneral<Integer> a2 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> a4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> a7 = new ArbolGeneral<>(7);
        ArbolGeneral<Integer> a8 = new ArbolGeneral<>(8);
        ArbolGeneral<Integer> a9 = new ArbolGeneral<>(9);

        ArbolGeneral<Integer> a5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> a10 = new ArbolGeneral<>(10);

        ArbolGeneral<Integer> a3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> a6 = new ArbolGeneral<>(6);


        a.agregarHijo(a2);
        a.agregarHijo(a3);

        a3.agregarHijo(a6);

        a2.agregarHijo(a4);

        a4.agregarHijo(a7);
        a4.agregarHijo(a8);
        a4.agregarHijo(a9);

        a2.agregarHijo(a5);

        a5.agregarHijo(a10);



        Main ej3 = new Main();
        System.out.println(ej3.creciente(a).getDato());
    }
}