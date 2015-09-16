
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
    private String nome;
    
    
    /**
     * COnstrutor para objetos da classe Elfo
     */
    public Elfo(String nome, int flechas)
    {
        this.nome = nome;
        this.flechas = flechas;
        
        if (this.flechas == 0){
            this.flechas = 42;
        }     
    }

    public void atirarFlecha(){
        if (acertar() == true){
            this.flechas--;
            this.experiencia++;
        }
    }
    
    public static boolean acertar() {
       return Math.random() < 0.5;
   } 
}
