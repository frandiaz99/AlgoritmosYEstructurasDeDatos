package p3;

import tp02.ejercicio2.*;
import tp03.ejercicio1.*;
public class ContadorArbol {

	
	private ArbolBinario<Integer> ab = new ArbolBinario<Integer>();
	
	public ContadorArbol(ArbolBinario<Integer> aa) {
		this.ab = aa; 
	}
	
	public ListaEnlazadaGenerica<Integer> ParesInOrder(ArbolBinario<Integer> aa, ListaEnlazadaGenerica<Integer> l){
		
		if(aa.tieneHijoIzquierdo()) {
			ParesInOrder(aa.getHijoIzquierdo(),l);
			
		}
		
		if(aa.getDato()%2 == 0)
			l.agregarFinal(aa.getDato());
		
		if(aa.tieneHijoDerecho()) {
			ParesInOrder(aa.getHijoDerecho(),l);
			
		}
		
		return l; 
		
		
		
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesInOrder(){
		
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		
		this.ParesInOrder(ab,lista);
		
		return lista; 
		
	}
	
	
}
	

