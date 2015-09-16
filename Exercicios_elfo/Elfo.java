
/**
 * Escreva a descrição da classe Elfo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Elfo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int flechas;
    private int experiencia;
    
    
    /**
     * COnstrutor para objetos da classe Elfo
     */
    public Elfo(int flechas)
    {
        this.flechas = flechas;
        
        if (this.flechas == 0){
            this.flechas = 42;
        }     
    }

    public void atirarFlecha(boolean acertar){
        if (acertar == true){
            this.flechas--;
            this.experiencia++;
        }
    }
   
}
