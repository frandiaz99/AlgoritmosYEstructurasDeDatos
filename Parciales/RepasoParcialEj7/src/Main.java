import tp03.ejercicio1.ArbolBinario;

public class Main {

    public Integer sumaImparesPosOrdenMayoresA(ArbolBinario<Integer> a, int n){
        Integer suma = 0;
        if(a.tieneHijoIzquierdo()){
            suma += sumaImparesPosOrdenMayoresA(a.getHijoIzquierdo(),n);
        }
        if(a.tieneHijoDerecho()){
            suma += sumaImparesPosOrdenMayoresA(a.getHijoDerecho(),n);
        }

        if(a.getDato() > n && a.getDato()%2 != 0){
            suma += a.getDato();
        }

        return suma;
    }

    public static void main(String[] args) {

        ArbolBinario<Integer> a1 = new ArbolBinario<>(7);
        ArbolBinario<Integer> a2 = new ArbolBinario<>(56);
        ArbolBinario<Integer> a3 = new ArbolBinario<>(25);
        ArbolBinario<Integer> a4 = new ArbolBinario<>(38);
        ArbolBinario<Integer> a5 = new ArbolBinario<>(31);
        ArbolBinario<Integer> a6 = new ArbolBinario<>(5);
        ArbolBinario<Integer> a7 = new ArbolBinario<>(6);
        ArbolBinario<Integer> a8 = new ArbolBinario<>(87);
        ArbolBinario<Integer> a9 = new ArbolBinario<>(77);
        ArbolBinario<Integer> a10 = new ArbolBinario<>(94);
        ArbolBinario<Integer> a11 = new ArbolBinario<>(16);
        ArbolBinario<Integer> a12 = new ArbolBinario<>(2);
        ArbolBinario<Integer> a13 = new ArbolBinario<>(43);
        ArbolBinario<Integer> a14 = new ArbolBinario<>(1);
        ArbolBinario<Integer> a15 = new ArbolBinario<>(9);
        ArbolBinario<Integer> a16 = new ArbolBinario<>(10);

        a1.agregarHijoIzquierdo(a2);
        a1.agregarHijoDerecho(a3);

        a3.agregarHijoIzquierdo(a6);
        a3.agregarHijoDerecho(a7);

        a2.agregarHijoIzquierdo(a4);
        a2.agregarHijoDerecho(a5);

        a5.agregarHijoDerecho(a10);
        a10.agregarHijoDerecho(a12);
        a12.agregarHijoIzquierdo(a14);

        a4.agregarHijoIzquierdo(a8);
        a4.agregarHijoDerecho(a9);

        a9.agregarHijoIzquierdo(a11);
        a11.agregarHijoDerecho(a13);
        a13.agregarHijoIzquierdo(a15);
        a13.agregarHijoDerecho(a16);

        Main ej6 = new Main();
        System.out.print(ej6.sumaImparesPosOrdenMayoresA(a1,30));

    }
}