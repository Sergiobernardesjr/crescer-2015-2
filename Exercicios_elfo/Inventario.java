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
    
   public String inventarioDescricoes(){
       String descricoes = "";
       for (int i = 0; i < itens.size();i++){
           descricoes += this.itens.get(i).getDescricao();
           if (i+1 != itens.size()){
               descricoes += ",";
           }
       }
       return descricoes;
   }
   
   public void aumentar1000UnidadeEmCadaItem(){
       for (Item item : this.itens){
           item.aumentar1000Unidades();
       }
   }
   
   public boolean escudoUrukHai(){
       int indice = 0;
       boolean escudo;
       for (Item item : this.itens){
           if (item.getDescricao() == "Escudo Uruk Hai"){
               indice = this.itens.indexOf(item);
           }
       }
       return escudo = itens.get(indice).getDescricao() == "Escudo Uruk Hai";
   }   
   
   public void irishSortudo(){
      for (Item item : this.itens){
           item.aumentar1000UnidadesMaisSomaDasQuantidadesAtuais();
      }
   }
   
   public Item itemComMaiorQuantidade(){
       int indice = 0, maiorQtd = 0;
       
       for (Item item : this.itens){
           int qtdAtual = item.getQuantidade();
           if(qtdAtual > maiorQtd){
               indice = this.itens.indexOf(item);
               maiorQtd = qtdAtual;
           }
       }
       
       return this.itens.get(indice);
   }
   
       public void ordenarItens() {        
        // Versão mais simples porém mais instável do BubbleSort - sempre O(n^2)
        int numeroItens = this.itens.size();
        
        for (int i = 0; i < numeroItens; i++) {
            for (int j = 0; j < numeroItens - 1; j++) {
                Item itemAtual = this.itens.get(j);
                Item proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = 
                    itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                }
            }
        } 
    }
}