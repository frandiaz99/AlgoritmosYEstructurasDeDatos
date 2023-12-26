package practica2_1_2;

import tp02.ejercicio1.*;
public class Ejercicio1_6 {

	public static int calcular(int n) {
		if(n>1) {
			if(n%2 == 0) {
				n = n/2;
			}
			else {
				n = 3*n+1;
			}
		}
		return n;
	}
	
	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada l;
		if(n>1) {
			l = calcularSucesion(calcular(n));
		}
		else {
			l = new ListaDeEnterosEnlazada();
		}
		
		l.agregarInicio(n);
		return l;
		 
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio1_6 f = new Ejercicio1_6();
		
		ListaDeEnterosEnlazada l = f.calcularSucesion(6);
		
		l.comenzar();
		while(!l.fin()) {
			System.out.print(l.proximo() + ", ");
		}
	}

}
