package tp03.ejercicio4;

import java.lang.Math;
import tp03.ejercicio1.*;
public class RedBinariaLlena {
	
	
	public static int retardoReenvio(ArbolBinario<Integer> aa){
		int HI,HD,max; 
		
		if(aa.esHoja()) {
			return aa.getDato();
		}
		else
		{
			HI = retardoReenvio(aa.getHijoIzquierdo());
			HD = retardoReenvio(aa.getHijoDerecho());
			
			max = Math.max(HI, HD);
			return max+aa.getDato();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArbolBinario<Integer> catorce =new ArbolBinario<>(14);
        ArbolBinario<Integer> cincuentaYTres =new ArbolBinario<>(53);
        ArbolBinario<Integer> dos =new ArbolBinario<>(2);
        ArbolBinario<Integer> doce =new ArbolBinario<>(12);
        ArbolBinario<Integer> nueve = new ArbolBinario<>(9);
        ArbolBinario<Integer> treintaYTres =new ArbolBinario<>(33);
        ArbolBinario<Integer> cientoDos =new ArbolBinario<>(102);
        
        catorce.agregarHijoIzquierdo(cincuentaYTres);
        catorce.agregarHijoDerecho(dos);
        cincuentaYTres.agregarHijoIzquierdo(doce);
        cincuentaYTres.agregarHijoDerecho(nueve);
        dos.agregarHijoIzquierdo(treintaYTres);
        dos.agregarHijoDerecho(cientoDos);
        
        System.out.println(retardoReenvio(catorce));
	}

}
