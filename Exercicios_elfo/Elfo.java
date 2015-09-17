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
 
      public void atirarFlecha(Dwarf dwarf){
             this.experiencia++;
             dwarf.danoRecebido();
             this.flechas--;
    }
   
    public String toString(){
        return "Nome: " +this.nome+ " Flechas: " +this.flechas;
    }
    
   
    public int getFlechas(){
        return this.flechas;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
}