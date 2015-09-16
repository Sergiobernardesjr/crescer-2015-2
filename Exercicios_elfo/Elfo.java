public class Elfo
{
    private int flechas;
    private int experiencia;
    private String nome;
    
    public Elfo(String nome,Integer flechas)
    {
        this.nome = nome;
        if (flechas != null){
            this.flechas = flechas;
        }
        this.flechas = flechas;
    }
    
    public Elfo(String nome){
        this(nome,42);
    }
 
      public void atirarFlecha(){
        if (this.acertar()){
            this.flechas--;
            this.experiencia++;
        }
    }
    
    public static boolean acertar() {
       return Math.random() < 0.5;
   } 
}
