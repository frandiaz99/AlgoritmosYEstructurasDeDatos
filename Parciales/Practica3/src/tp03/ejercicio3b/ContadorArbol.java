package tp03.ejercicio3b;

import tp03.ejercicio1.*;
import tp02.ejercicio2.*;

public class ContadorArbol {
	
	ArbolBinario<Integer> arbol = new ArbolBinario<>();
	
	
	public ListaGenerica<Integer> numeroParesInOrder(){
		
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		
		coleccionParesInOrder(arbol,lista);
		
		return lista; 
		
	}
	
	public void coleccionParesInOrder(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
		if(arbol.tieneHijoIzquierdo()) {
			coleccionParesInOrder(arbol.getHijoIzquierdo(),lista);
		}
		if(arbol.getDato() % 2 == 0) {
			lista.agregarFinal(arbol.getDato());
		}
		
		if(arbol.tieneHijoDerecho()) {
			coleccionParesInOrder(arbol.getHijoDerecho(), lista);
		}
	}
}
