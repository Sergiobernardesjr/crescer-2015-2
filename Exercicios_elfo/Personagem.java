
public class Personagem
{
    protected Inventario inventario = new Inventario();
    protected int vida;
    protected int experiencia;
    protected String nome;
    protected Status status;

    public void receberAtaqueOrc(Orc orc){
        this.vida -= orc.getDanoDeAtaque();
    }

    public Status getStatus(){
        return this.status;
    }

    public int getVida(){
        return this.vida;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public String getNome(){
        return this.nome;
    }

    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }

    public void removerItem(Item item){
        this.inventario.perdeItem(item);
    }

    public Inventario getInventario(){
        return this.inventario;
    }
}
