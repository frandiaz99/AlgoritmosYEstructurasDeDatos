import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;


public class Main {
    public ListaGenerica<ListaGenerica<String>> caminosPares(ArbolGeneral<String> arbol){

        ListaGenerica<String> listaParcial;
        ListaGenerica<ListaGenerica<String>> listaGenerica = new ListaEnlazadaGenerica<>();
        listaParcial = caminosPares(arbol,listaGenerica);
        return listaGenerica;
    }

    private ListaGenerica<String> caminosPares(ArbolGeneral<String> arbol, ListaGenerica<ListaGenerica<String>> listaGeneral){

        ListaGenerica<String> listaParcial = new ListaEnlazadaGenerica<>();

        listaParcial.agregarFinal(arbol.getDato());

        if(arbol.esHoja()){
            if(listaParcial.tamanio()%2 == 0){
                listaGeneral.agregarFinal(listaParcial.clonar());
            }
        }

        if(arbol.tieneHijos()) {
            ListaGenerica<ArbolGeneral<String>> lHijos = arbol.getHijos();
            while (!lHijos.fin()) {
                ListaGenerica<String> aux;
                aux = caminosPares(lHijos.proximo(), listaGeneral);
                aux.comenzar();
                while(!aux.fin()){
                    listaParcial.agregarFinal(aux.proximo());
                }
            }
        }

        listaParcial.eliminarEn(listaParcial.tamanio());

        return listaParcial;
    }

    public static void main(String[] args) {

        ArbolGeneral<String> a = new ArbolGeneral<>("A");

        ArbolGeneral<String> b = new ArbolGeneral<>("B");
        ArbolGeneral<String> c = new ArbolGeneral<>("C");
        ArbolGeneral<String> d = new ArbolGeneral<>("D");

        ArbolGeneral<String> e = new ArbolGeneral<>("E");
        ArbolGeneral<String> f = new ArbolGeneral<>("F");
        ArbolGeneral<String> g = new ArbolGeneral<>("G");
        ArbolGeneral<String> h = new ArbolGeneral<>("H");
        ArbolGeneral<String> i = new ArbolGeneral<>("I");

        a.agregarHijo(b);
        a.agregarHijo(c);
        a.agregarHijo(d);

        b.agregarHijo(e);

        c.agregarHijo(f);
        c.agregarHijo(g);

        f.agregarHijo(h);
        f.agregarHijo(i);

        Main ej5 = new Main();

        ListaGenerica<ListaGenerica<String>> l = ej5.caminosPares(a);
        l.comenzar();
        while(!l.fin()){
            ListaGenerica<String> l2 = l.proximo();
            l2.comenzar();
            while(!l2.fin()){
                System.out.print(l2.proximo());
            }
        }


    }
}