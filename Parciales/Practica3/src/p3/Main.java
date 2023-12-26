package p3;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;
public class Main {

	
	public static void traverse(ArbolBinario<Integer> a) {
		if (!a.esVacio()) {
			System.out.print(a.getDato() + " - ");
		if (a.tieneHijoIzquierdo())
			traverse(a.getHijoIzquierdo());
		if (a.tieneHijoDerecho())
			traverse(a.getHijoDerecho());
		System.out.print(a.getDato() + " - ");
		}
	}
	
	public static void porNivel(ArbolBinario <Integer> arbol) {
		ColaGenerica<ArbolBinario <Integer>> cola = new ColaGenerica<>();
		ArbolBinario<Integer> aa = null; 
		cola.encolar(arbol);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			aa = cola.desencolar();
			
			if(aa!=null) {
				System.out.println(aa.getDato());
				if(aa.tieneHijoIzquierdo()) 
					cola.encolar(aa.getHijoIzquierdo());
				if(aa.tieneHijoDerecho())
					cola.encolar(aa.getHijoDerecho());
			}
			else if(!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArbolBinario <Integer> ab = new ArbolBinario<Integer>(40);
		
		ArbolBinario<Integer> hijoIzquierdo = new ArbolBinario<Integer>(25);
		
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(32));
		
		ArbolBinario<Integer> hijoDerecho = new ArbolBinario<Integer>(78);
		
		//         40
		//        /  \
		//       25  78
		//      /  \
        //     10  32
		//
		ab.agregarHijoIzquierdo(hijoIzquierdo);
		ab.agregarHijoDerecho(hijoDerecho);
		
		System.out.println(ab.contarHojas()); 
		
		//ab.printInOrden();
		
		System.out.println(" ---------------------------- "); 
		
		//ab.printPreOrden();
		
		//System.out.println(" ---------------------------- ");
		
		//ab.espejo().printPreOrden();
		
		ContadorArbol aa = new ContadorArbol(ab);
	
		ListaEnlazadaGenerica<Integer> listaAux = new ListaEnlazadaGenerica<Integer>();
		
		
		
		listaAux = aa.numerosParesInOrder();
		
		listaAux.comenzar();
		
		while(!listaAux.fin()) {
			System.out.println(listaAux.proximo());
		}
		
		traverse(ab); 
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println();
		porNivel(ab); 
	}

}
