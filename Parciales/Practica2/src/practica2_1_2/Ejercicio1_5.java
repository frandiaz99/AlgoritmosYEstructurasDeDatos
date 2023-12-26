package practica2_1_2;

import tp02.ejercicio1.*;
public class Ejercicio1_5 {
	
	public static void imprimirInverso(ListaDeEnteros l, int numero) {
		if(numero > 0) {
			System.out.print(l.elemento(numero));
			numero--;
			imprimirInverso(l,numero);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos();
		
		l.agregarFinal(1);
		l.agregarFinal(2);
		l.agregarFinal(3);
		l.agregarFinal(4);
		
		
		imprimirInverso(l,l.tamanio());
	}

}
