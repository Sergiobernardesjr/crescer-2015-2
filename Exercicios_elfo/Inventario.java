import java.util.ArrayList;

public class Inventario
{
    private ArrayList<String> itens = new ArrayList<>();
    
    public void perdeItem(String item){
        this.itens.remove(item);
    }
    
    public void adicionarItem(String item){
        this.itens.add(item);
    }
    
    public ArrayList<String> getItem(){
        return this.itens;
    }
}
