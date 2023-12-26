package tp03.ejercicio1;

import tp02.ejercicio3.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int contarHoja = 0;
		
		if(esHoja()) {
			return 1;
		}
		else {
			if(tieneHijoIzquierdo()) {
				contarHoja += hijoIzquierdo.contarHojas();
			}
			if(tieneHijoDerecho()) {
				contarHoja += hijoDerecho.contarHojas();
			}
		}
		return contarHoja;
		
	}
	
	public ArbolBinario<T> espejo(){
		
		if (this.esVacio()){
			return new ArbolBinario<>();
		}
		else {
			ArbolBinario<T> espejoAbb = new ArbolBinario<T>(this.getDato());
			
			if(this.tieneHijoIzquierdo()) {
				espejoAbb.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			}
			
			if(this.tieneHijoDerecho()) {
				espejoAbb.agregarHijoIzquierdo(this.getHijoIzquierdo().espejo());
			}
			
			return espejoAbb;
		} 
		
	}
	
    public void printPreOrden() {
    	System.out.println(this.getDato());
    	if(this.tieneHijoIzquierdo()){
    		this.getHijoIzquierdo().printPreOrden();
    	}
    	
    	if(this.tieneHijoDerecho()) {
    		this.getHijoDerecho().printPreOrden();
    	}
    }
    
    public void printInOrden() {
    	
    	if(this.tieneHijoIzquierdo()){
    		this.getHijoIzquierdo().printInOrden();
    	}
    	
    	System.out.println(this.getDato());
    	
    	if(this.tieneHijoDerecho()) {
    		this.getHijoDerecho().printInOrden();
    	}
    }
    

	public void entreNiveles(int n, int m){
		int altura = 0;
		ColaGenerica<ArbolBinario<T>> cola= new ColaGenerica<>();
		ArbolBinario<T> arbol;
		cola.encolar(this);
		cola.encolar(null);

		if (n>=0 && m<=altura){
			while (!cola.esVacia()){
				arbol = cola.desencolar();
				if (arbol == null){ //Si llegue al final del nivel
					if (!cola.esVacia()){
						cola.encolar(null);
						altura++;
					}
				}
				else{
					if (n<=altura && altura<=m){
						System.out.println(arbol.getDato());
					}
					if (arbol.tieneHijoIzquierdo()){
						cola.encolar(arbol.getHijoIzquierdo());
					}
					if (arbol.tieneHijoDerecho()){
						cola.encolar(arbol.getHijoDerecho());
					}
				}
			}
		}
	}

}
