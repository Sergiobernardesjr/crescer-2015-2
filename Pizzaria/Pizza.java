import java.util.*;

public class Pizza extends Item{
    private TamanhoPizza tamanho;
    private ArrayList<String> sabor = new ArrayList<>();
    
    public Pizza(int tamanho){
           
        if(tamanho == 1){
            this.tamanho = TamanhoPizza.PEQUENA;
            valorUnitario = 20;
        }
        else if (tamanho == 2){
            this.tamanho = TamanhoPizza.GRANDE;
            valorUnitario = 40;
        }
        else if (tamanho == 3){
            this.tamanho = TamanhoPizza.TITANIC;
            valorUnitario = 100;
        }
    }
}