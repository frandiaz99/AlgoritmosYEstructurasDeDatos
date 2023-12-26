package tp03.ejercicio3b;

import tp03.ejercicio1.*;
import tp03.ejercicio3.ContadorArbol;
import tp03.ejercicio3.InOrder;
import tp02.ejercicio2.*;

public class testEj03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArbolBinario<Integer> arbol = new ArbolBinario<>(1); 
		
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2); 
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
	
		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<>(4));
		hijoIzq.agregarHijoDerecho(new ArbolBinario<>(8));
		hijoDer.agregarHijoIzquierdo(new ArbolBinario<>(6));
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);
		
		ContadorArbol cont = new ContadorArbol(arbol); 
		
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		
		lista = cont.numerosParesInOrder(); 
		
		lista.comenzar(); 
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
		
	}

}
