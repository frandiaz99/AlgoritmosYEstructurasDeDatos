public class Palabra {

    private int num;
    private String p;

    public Palabra(int num, String p){
        this.num = num;
        this.p = p;
    }

    public String getLetra(){
        return p;
    }

    public int getNum(){
        return num;
    }
}
