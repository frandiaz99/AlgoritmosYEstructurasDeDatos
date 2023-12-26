import tp04.ejercicio1.ArbolGeneral;

public class Main {
    public static void main(String[] args) {


        ArbolGeneral<Integer> a20 = new ArbolGeneral<>(20);

        ArbolGeneral<Integer> a1 = new ArbolGeneral<>(1);
        ArbolGeneral<Integer> a45 = new ArbolGeneral<>(45);
        ArbolGeneral<Integer> a21 = new ArbolGeneral<>(21);

        ArbolGeneral<Integer> a6 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> a0 = new ArbolGeneral<>(0);
        ArbolGeneral<Integer> a8 = new ArbolGeneral<>(8);
        ArbolGeneral<Integer> a10 = new ArbolGeneral<>(10);

        ArbolGeneral<Integer> a22 = new ArbolGeneral<>(22);
        ArbolGeneral<Integer> a2 = new ArbolGeneral<>(2);

        a20.agregarHijo(a1);
        a20.agregarHijo(a45);
        a20.agregarHijo(a21);

        a1.agregarHijo(a6);
        a1.agregarHijo(a0);

        a45.agregarHijo(a8);

        a21.agregarHijo(a10);

        a10.agregarHijo(a22);
        a10.agregarHijo(a2);

        ProcesadorDeArbol p = new ProcesadorDeArbol(a20);

        System.out.println(p.resolver(a20));
    }
}