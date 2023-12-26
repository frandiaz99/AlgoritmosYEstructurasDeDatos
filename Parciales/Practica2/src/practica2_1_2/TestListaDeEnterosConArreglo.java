package practica2_1_2;

import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos(); 
		l.agregarFinal(1); 
		l.agregarFinal(2);
		l.agregarFinal(3);
		
		l.comenzar();
		while(!l.fin()) {
			System.out.print(l.proximo());
		}
			
		
		ListaDeEnterosEnlazada e = new ListaDeEnterosEnlazada();
		
		e.agregarFinal(4);
		e.agregarFinal(5);
		e.agregarFinal(6);
		
		e.comenzar();
		while(!e.fin()) {
			System.out.print(e.proximo());
		
		}
		
		System.out.println();
		
		
	}

}
