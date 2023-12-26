import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Main {
    public static void main(String[] args) {


        ArbolGeneral<Integer> a2 = new ArbolGeneral<>(2);

        ArbolGeneral<Integer> a3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> a4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> a8 = new ArbolGeneral<>(8);

        ArbolGeneral<Integer> a6 = new ArbolGeneral<>(6);

        ArbolGeneral<Integer> a5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> a7 = new ArbolGeneral<>(7);
        ArbolGeneral<Integer> a9 = new ArbolGeneral<>(10);
        ArbolGeneral<Integer> a11 = new ArbolGeneral<>(11);
        ArbolGeneral<Integer> a12 = new ArbolGeneral<>(12);

        a2.agregarHijo(a3);
        a2.agregarHijo(a4);
        a2.agregarHijo(a8);

        a3.agregarHijo(a5);

        a5.agregarHijo(a6);

        a4.agregarHijo(a7);
        a4.agregarHijo(a9);

        a8.agregarHijo(a11);
        a8.agregarHijo(a12);

        ArbolRecorrido ar = new ArbolRecorrido(a2);
        ListaGenerica<Integer> l = ar.recorrer(2);
        l.comenzar();
        while(!l.fin()){
            System.out.println(l.proximo());
        }
    }
}