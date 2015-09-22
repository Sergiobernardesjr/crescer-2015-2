import java.util.*;

public class GreenElf extends Elfo{
    
    public GreenElf(String nome){
        super(nome);
    }

    public GreenElf(String nome, int flechas){
        super(nome,flechas);
    }

    private void gerarInventario(Item item) {
       ArrayList<String> validas = 
            new ArrayList<String>(
                Arrays.asList(new String[] { 
                    "Espada de aço valiriano", "Arco e Flecha de Vidro"
                })
            );
            
        boolean podeAdicionar = 
                item != null && validas.contains(item.getDescricao());
            
        if (podeAdicionar){
            super.adicionarItem(item);
        }
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        this.experiencia ++;
    }  
}