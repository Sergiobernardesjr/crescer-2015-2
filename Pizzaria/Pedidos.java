public class Pedidos{
    private ItensPedido itensPedido = new ItensPedido();
    
    public Pedidos (Cliente cliente, Item item){
        this.itensPedido.adicionarItem(item);
    }
}