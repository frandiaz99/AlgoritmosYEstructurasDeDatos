import com.sun.jdi.IntegerValue;
import tp03.ejercicio1.ArbolBinario;

public class ParcialArboles {
    private ArbolBinario<Integer> a;

    public ParcialArboles(ArbolBinario<Integer> a){
        this.a = a;
    }

    public ArbolBinario<Integer> getArbol(){
        return a;
    }

    public boolean isLeftTree(int num){
        ArbolBinario<Integer> aAux;

        aAux = buscar(this.getArbol(),num);

        if(aAux!=null){
            return isLeftTree(aAux);
        }

        return false;
    }

    private ArbolBinario<Integer> buscar(ArbolBinario<Integer> a, int num){
        ArbolBinario<Integer> aux = null;

        if(a.getDato().equals(num)) {
            System.out.println("Dato 1 arbol: " + a.getDato());
            return a;
        }

        if(a.tieneHijoIzquierdo())
            aux = buscar(a.getHijoIzquierdo(),num);

        if(a.tieneHijoDerecho() && aux == null)
            aux = buscar(a.getHijoDerecho(),num);

        System.out.println("Dato 2 arbol: " + a.getDato());
        return aux;
    }

    private int contarHijosIzq(ArbolBinario<Integer> a){

        int cant = 0;

        if(a.tieneHijoIzquierdo()){
            cant += contarHijosIzq(a.getHijoIzquierdo());
        }

        if(a.tieneHijoDerecho()){
            cant+= contarHijosIzq(a.getHijoDerecho());
        }

        if(a.tieneHijoIzquierdo() && !a.tieneHijoDerecho()){
            cant++;
            System.out.println("Numero: " + a.getDato() + " | cantidad: " + cant);
            return cant;
        }
       return cant;
    }

    private boolean isLeftTree(ArbolBinario<Integer> a) {
        int hi = -1;
        int hd = -1;

        System.out.println("Dato Arbol: " + a.getDato());

        if(a.tieneHijoIzquierdo()){
            hi = contarHijosIzq(a.getHijoIzquierdo());
            System.out.println("Hijos izquierdos: " + hi);
        }
        if(a.tieneHijoDerecho()){
            hd = contarHijosIzq(a.getHijoDerecho());
            System.out.println("Hijos Derechos: " + hd);
        }


        if(hd >= hi) {
            System.out.println(hi + " < " + hd );
            return false;
        }
        else {
            System.out.println(hi + " >= " + hd);
            return true;
        }
    }
}

