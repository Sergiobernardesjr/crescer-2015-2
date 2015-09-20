import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();
    
    public void perdeItem(Item item){
        this.itens.remove(item);
    }
    
    public void adicionarItem(Item item){
        this.itens.add(item);
    }
    
    public ArrayList<Item> getItem(){
        return this.itens;
    }
    
}