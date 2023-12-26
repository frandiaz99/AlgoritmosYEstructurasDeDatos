import tp03.ejercicio1.ArbolBinario;

public class Main {

    public static void main(String[] args) {


        ArbolBinario<Integer> a1 = new ArbolBinario<>(2);
        ArbolBinario<Integer> a2 = new ArbolBinario<>(7);
        ArbolBinario<Integer> a3 = new ArbolBinario<>(-5);
        ArbolBinario<Integer> a4 = new ArbolBinario<>(23);
        ArbolBinario<Integer> a5 = new ArbolBinario<>(6);
        ArbolBinario<Integer> a6 = new ArbolBinario<>(19);
        ArbolBinario<Integer> a7 = new ArbolBinario<>(-3);
        ArbolBinario<Integer> a8 = new ArbolBinario<>(55);
        ArbolBinario<Integer> a9 = new ArbolBinario<>(11);
        ArbolBinario<Integer> a10 = new ArbolBinario<>(4);
        ArbolBinario<Integer> a11 = new ArbolBinario<>(18);

        a1.agregarHijoIzquierdo(a2);

        a2.agregarHijoIzquierdo(a4);
        a2.agregarHijoDerecho(a5);

        a4.agregarHijoIzquierdo(a7);

        a5.agregarHijoIzquierdo(a8);
        a5.agregarHijoDerecho(a9);

        a1.agregarHijoDerecho(a3);

        a3.agregarHijoIzquierdo(a6);

        a6.agregarHijoDerecho(a10);

        a10.agregarHijoIzquierdo(a11);

        ParcialArboles a = new ParcialArboles(a1);

        System.out.println(a.isLeftTree(19));
    }
}