
public class Dwarf
{
    private int vida = 110;   
        
    public void danoRecebido(){
        this.vida -= 10;
    }
    
    public int getVida(){
        return this.vida;
    }
}
