import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class Main {
    public static void main(String[] args) {

        ArbolGeneral<Integer> a2 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> a1 = new ArbolGeneral<>(1);
        ArbolGeneral<Integer> a12 = new ArbolGeneral<>(12);
        ArbolGeneral<Integer> a14 = new ArbolGeneral<>(14);
        ArbolGeneral<Integer> a5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> a4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> a8 = new ArbolGeneral<>(8);
        ArbolGeneral<Integer> a4b = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> a7 = new ArbolGeneral<>(7);
        ArbolGeneral<Integer> a9 = new ArbolGeneral<>(9);
        ArbolGeneral<Integer> a10 = new ArbolGeneral<>(10);
        ArbolGeneral<Integer> a5b = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> a3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> a13 = new ArbolGeneral<>(13);


        a2.agregarHijo(a1);
        a2.agregarHijo(a12);
        a2.agregarHijo(a14);

        a1.agregarHijo(a5);
        a1.agregarHijo(a4);

        a4.agregarHijo(a9);
        a4.agregarHijo(a10);
        a4.agregarHijo(a5b);

        a12.agregarHijo(a8);
        a12.agregarHijo(a4b);
        a12.agregarHijo(a7);

        a8.agregarHijo(a3);

        a7.agregarHijo(a13);

        Parcial p = new Parcial(a2);
        ListaGenerica<Integer> l;
        l = p.resolver();

        l.comenzar();
        while(!l.fin()){
            System.out.println(l.proximo());
        }
    }
}