
public class Dwarf
{
    private String nome;
    private int vida = 110; 
    private int experiencia = 0;
    private Status status = Status.VIVO;
    
    public Dwarf(String nome){
        this.nome = nome;
    }
    
    public void danoRecebido(){
        this.vida -= 10;
        statusDwarf();
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public void statusDwarf(){
        if (this.vida == 0){
            status = Status.MORTO;
        }
        else if ((this.vida > 0) && (this.vida < 110)){
            status = Status.FERIDO;
       }
    }
    
    public Status getStatus(){
        return this.status;
    }
        
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public String getNome(){
        return this.nome;
    }
    }
