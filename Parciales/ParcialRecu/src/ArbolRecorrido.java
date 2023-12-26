import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class ArbolRecorrido {
    private ArbolGeneral<Integer> arbol;

    public ArbolRecorrido(ArbolGeneral<Integer> arbol){
        this.arbol = arbol;
    }
    public ListaGenerica<Integer> recorrer(int num){

        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        recorrer(this.arbol, num,lista);

        return lista;
    }

    private boolean recorrer(ArbolGeneral<Integer> a, int num, ListaGenerica<Integer> l){
        boolean verificar = true;

        l.agregarFinal(a.getDato());

        if(a.getDato()%num == 0) {

            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
                lHijos.comenzar();
                while (!lHijos.fin() && verificar == true) {
                    verificar = recorrer(lHijos.proximo(), num, l);
                }
            }

            if(a.esHoja()){
                return false;
            }
        }
        if(verificar == true)
            l.eliminarEn(l.tamanio());
        return verificar;
    }


}
