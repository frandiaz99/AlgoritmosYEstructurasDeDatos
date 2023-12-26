package tp03.ejercicio3;

import tp02.ejercicio2.*;
import tp03.ejercicio1.*;


public abstract class ContadorArbol {
	
	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaGenerica<Integer> numerosPares(){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		coleccionarPares(arbol,lista);
		return lista;
	}
	
	public abstract void coleccionarPares(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista);

}
