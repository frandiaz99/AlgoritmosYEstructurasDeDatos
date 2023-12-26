package tp02.ejercicio4;


import tp02.ejercicio3.*;
public class prueba {
	
	
	public static void main(String arg[]) {
	
		PilaGenerica <Integer> pila = new PilaGenerica<Integer>();
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		
		System.out.println(pila.tope());
		
		System.out.println(pila.desapilar());
		System.out.println(pila.desapilar());
		System.out.println(pila.desapilar());
		
		
	}
	
	
	
	
	
	
	
	

}
