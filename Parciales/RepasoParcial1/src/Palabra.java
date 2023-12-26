public class Palabra {
    private String valor;
    private Integer sig;

    public Palabra(String valor,Integer sig){
        this.valor = valor;
        this.sig = sig;
    }

    public Integer getSig(){
        return sig;
    }
    public String getValor(){
        return valor;
    }

}
