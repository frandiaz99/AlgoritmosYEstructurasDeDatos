package tp03.ejercicio3;


import tp02.ejercicio2.*;
import tp03.ejercicio1.*;
import tp02.ejercicio3.*;

public class Test {
	
	
	public static void main(String[] args) { 
	
		
		ArbolBinario<Integer> arbol = new ArbolBinario<>(1); 
		
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2); 
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
	
		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<>(4));
		hijoIzq.agregarHijoDerecho(new ArbolBinario<>(8));
		hijoDer.agregarHijoIzquierdo(new ArbolBinario<>(6));
		arbol.agregarHijoIzquierdo(hijoIzq);
		arbol.agregarHijoDerecho(hijoDer);
		
		ContadorArbol contador = new InOrder(arbol);
		
		ListaGenerica<Integer> l = contador.numerosPares();
		
		l.comenzar(); 
		while(!l.fin()) {
			System.out.println(l.proximo());
		}
		
		
	}
}
