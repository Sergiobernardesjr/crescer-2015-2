
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

    public boolean equals(Object obj){
        Item item = (Item)obj;
        return this.descricao == item.getDescricao() && this.quantidade == item.getQuantidade();
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void aumentar1000Unidades(){
        this.quantidade += 1000;
    }

    public void aumentar1000UnidadesMaisSomaDasQuantidadesAtuais(){
        int quantidadeAcumulada = 0;

        int pa = ((this.quantidade * (this.quantidade+1)) / 2);
        this.quantidade += 1000 * pa;
    }

    public void perdeUnidade(){
        if(this.quantidade > 0){
            this.quantidade--;
        }
    }
}
