
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
   private String descricao;
   private int quantidade;
   
   public Item(String descricao, int quantidade){
       this.descricao = descricao;
       this.quantidade = quantidade;
   }
   
   public boolean equalsDescricao(Object obj){
       Item item = (Item)obj;
       return this.descricao == item.getDescricao();
   }
   
   public boolean equalsQuantidade(Object obj){
       Item item = (Item)obj;
       return this.quantidade == item.getQuantidade();
   }
    
   public String getDescricao(){
       return this.descricao;
   }
   
   public int getQuantidade(){
       return this.quantidade;
   }
}
