package practica2_1_2;

import tp02.ejercicio2.*;
public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaEnlazadaGenerica<Estudiante> l = new ListaEnlazadaGenerica<Estudiante>();
		
		Estudiante e1 = new Estudiante("Francisco",1,"fran@gmail.com",45);
		Estudiante e2 = new Estudiante("Luis",2,"luis@gmail.com",3);
		Estudiante e3 = new Estudiante("Juan",3,"juan@gmail.com",4);
		Estudiante e4 = new Estudiante("Josefina",1,"jose@gmail.com",5);
		
		
		l.agregarFinal(e1);
		l.agregarFinal(e2);
		l.agregarFinal(e3);
		l.agregarFinal(e4);
		
		l.comenzar();
		
		while(!l.fin()) {
			System.out.println(l.proximo().tusDatos());
		}
		
		
	}

}
