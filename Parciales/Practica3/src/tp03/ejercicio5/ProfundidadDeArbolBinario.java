package tp03.ejercicio5;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;

public class ProfundidadDeArbolBinario {
	
	private ArbolBinario<Integer> arbol;
	
	ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol){
		this.arbol = arbol;
	}
	
	
	public int sumaElementosProfundidad(int p) {
		
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>();
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		
		
		
	}
	
}
