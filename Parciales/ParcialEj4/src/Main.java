import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

import java.util.List;

public class Main {

    public ListaGenerica<ListaGenerica<String>> caminosPares(ArbolGeneral<String> a){

        ListaGenerica<ListaGenerica<String>> ll = new ListaEnlazadaGenerica<>();
        ListaGenerica<String> l = new ListaEnlazadaGenerica<>();
        if(!a.esVacio())
            caminosPares(a,ll,l);

        return ll;
    }

    private void caminosPares(ArbolGeneral<String> a, ListaGenerica<ListaGenerica<String>> ll, ListaGenerica<String> l){

        l.agregarFinal(a.getDato());

        if(a.esHoja()){
            if(l.tamanio() % 2 == 0){
                ll.agregarFinal(l.clonar());
            }
        }

        if(a.tieneHijos()){
            ListaGenerica<ArbolGeneral<String>> lHijos = a.getHijos();

            lHijos.comenzar();
            while(!lHijos.fin()){
                caminosPares(lHijos.proximo(), ll,l);
            }
        }

        l.eliminarEn(l.tamanio());
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

        Main ej4 = new Main();

        System.out.println(ej4.caminosPares(a));

    }
}