import tp02.ejercicio2.ListaGenerica;

public class sub20 {
    private ListaGenerica<String> lugares;
    private Integer cuadras;

    public void agregarALista(String lugar){
        lugares.agregarFinal(lugar);
    }

    public void aumentarDistancia(int distancia){
        cuadras += distancia;
    }

    public ListaGenerica<String> getLista(){
        return lugares;
    }

    public void setLista(ListaGenerica<String> lista){
        this.lugares = lista.clonar();
    }

    public void imprimirLista(){
        lugares.comenzar();
        while(lugares.fin()){
            System.out.println(lugares.proximo());
        }
    }

    public void distancia(){
        System.out.println(cuadras);
    }
}
