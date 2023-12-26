package tp02.ejercicio4;

import java.util.Scanner; 
import tp02.ejercicio3.*;
public class testBalanceado {

    public static boolean estaBalanceado(String S) {
        
    	PilaGenerica <Character> pila = new PilaGenerica<>();
        
    	for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (esCaracterDeApertura(c)) {
                pila.apilar(c);
            } else if (esCaracterDeCierre(c)) {
                if (pila.esVacia()) {
                    return false;
                }
                char tope = pila.tope();
                if (!correspondeCaracterDeApertura(tope, c)) {
                    return false;
                }
                pila.desapilar();
            }
        }
        return pila.esVacia();
    }

    private static boolean esCaracterDeApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean esCaracterDeCierre(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean correspondeCaracterDeApertura(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }
    
    public static void main(String arg[]) {
    	Scanner consola = new Scanner(System.in);
    	
    	System.out.println("Solo puede ingresar los siguientes caracteres: ");
        System.out.println("{}[]() en el orden en el quiera: ");
		String cadena = consola.nextLine();
		consola.close();
  
        if (estaBalanceado(cadena)){
            System.out.println("La expresion esta balanceada: " + cadena);
        }
        else 
            {
                System.out.println("La expresion no esta balanceada" );
            }
    }
    	
    	
}
    


