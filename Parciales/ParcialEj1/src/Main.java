import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Main {

    public ListaGenerica<String> buscar (ArbolGeneral<Palabra> a){
        ListaGenerica<String> l = new ListaEnlazadaGenerica<>();

        if(!a.esVacio()) {
            l.agregarFinal(a.getDato().getLetra());
        }

        if(a.tieneHijos()){
            ListaGenerica<ArbolGeneral<Palabra>> lHijos = a.getHijos();
            lHijos.comenzar();
                ListaGenerica<String> lAux = buscar(lHijos.elemento(a.getDato().getNum()));
                while(!lAux.fin())
                    l.agregarFinal(lAux.proximo());
        }
        return l;
    }

    public static void main(String[] args) {
        Palabra p1 = new Palabra(1,"G");
        Palabra p2 = new Palabra(3,"E");
        Palabra p3 = new Palabra(2,"F");
        Palabra p4 = new Palabra(2,"J");
        Palabra p5 = new Palabra(7,"A");
        Palabra p6 = new Palabra(3,"B");
        Palabra p7 = new Palabra(6,"C");
        Palabra p8 = new Palabra(10,"D");
        Palabra p9 = new Palabra(6,"H");
        Palabra p10 = new Palabra(12,"I");

        ArbolGeneral<Palabra> aG = new ArbolGeneral<>(p1);
        ArbolGeneral<Palabra> aE = new ArbolGeneral<>(p2);
        ArbolGeneral<Palabra> aF = new ArbolGeneral<>(p3);
        ArbolGeneral<Palabra> aJ = new ArbolGeneral<>(p4);
        ArbolGeneral<Palabra> aA = new ArbolGeneral<>(p5);
        ArbolGeneral<Palabra> aB = new ArbolGeneral<>(p6);
        ArbolGeneral<Palabra> aC = new ArbolGeneral<>(p7);
        ArbolGeneral<Palabra> aD = new ArbolGeneral<>(p8);
        ArbolGeneral<Palabra> aH = new ArbolGeneral<>(p9);
        ArbolGeneral<Palabra> aI = new ArbolGeneral<>(p10);

        aG.agregarHijo(aE);
        aG.agregarHijo(aF);
        aG.agregarHijo(aJ);

        aE.agregarHijo(aA);
        aE.agregarHijo(aB);
        aE.agregarHijo(aC);

        aF.agregarHijo(aD);

        aJ.agregarHijo(aH);
        aJ.agregarHijo(aI);

        Main ej1 = new Main();

        ListaGenerica<String> l;

        l = ej1.buscar(aG);

        l.comenzar();
        while(!l.fin()){
            System.out.print(" | " + l.proximo());
        }

    }
}