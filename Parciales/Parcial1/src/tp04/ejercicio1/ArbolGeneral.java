package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		int alturaMax = 0;
		if (this.esVacio() || this.esHoja())
			return 0;

		if(this.tieneHijos()){
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()){
				alturaMax = Math.max(alturaMax, lHijos.proximo().altura());
			}
		}
		return alturaMax + 1;
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> aux;
		int lvl = 0;

		cola.encolar(this);
		cola.encolar(null);

		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (!cola.esVacia() && aux != null) {
				if (aux.getDato() == dato) {
					return lvl;
				}
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lHijos = aux.getHijos();
					lHijos.comenzar();
					while (!lHijos.fin()) {
						cola.encolar(lHijos.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				lvl++;
			}


		}
		return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> aux;
		int cantNodosEnNivel = 0;
		int cantDeNodosMax = 0;

		cola.encolar(this);
		cola.encolar(null);

		while(!cola.esVacia()){



			aux = cola.desencolar();
			if(!cola.esVacia() && aux != null){
				if(aux.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> lHijos = aux.getHijos();
					lHijos.comenzar();
					while(!lHijos.fin()){
						cola.encolar(lHijos.proximo());
						cantNodosEnNivel++;
					}
					if(cantNodosEnNivel > cantDeNodosMax){
						cantDeNodosMax = cantNodosEnNivel;
					}
				}
			}
			else if(!cola.esVacia()){
				cola.encolar(null);
				cantNodosEnNivel = 0;
			}
		}

		return cantDeNodosMax;
	}


	public Boolean esAncesto(T a, T b){
		// falta el codigo. 
		return true;
	}


}