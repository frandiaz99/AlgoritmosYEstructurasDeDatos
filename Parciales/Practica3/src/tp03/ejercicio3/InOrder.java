package tp03.ejercicio3;

import tp02.ejercicio2.*;
import tp03.ejercicio1.*;

public class InOrder extends ContadorArbol{
	
	public InOrder(ArbolBinario<Integer> arbol) {
		super(arbol);
	}
	
	
	public void coleccionarPares(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
		if(arbol.tieneHijoIzquierdo()) {
			coleccionarPares(arbol.getHijoIzquierdo(),lista);
		}
		if(arbol.getDato() % 2 == 0) {
			lista.agregarFinal(arbol.getDato());
		}
		
		if(arbol.tieneHijoDerecho()) {
			coleccionarPares(arbol.getHijoDerecho(), lista);
		}
		
			
		
	}
	
}
