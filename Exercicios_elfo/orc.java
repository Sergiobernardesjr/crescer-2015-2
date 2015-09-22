public class Orc {
    private int vida;
    private Inventario inventario;
    private Status status;
    private TipoOrc tipoOrc;

    public Orc(TipoOrc tipoOrc)
    {
        this.inventario = new Inventario();
        this.tipoOrc = tipoOrc;
        gerarVidaInicial();
        gerarInventario();
        this.status = Status.VIVO;
    }
    
    public void recebeAtaqueDwarf() {
        
        if(getItem("Escudo Uruk-Hai") == null){
            perderVida(10);
        }
        else {
            perderVida(5);
        }
    }
    
    public void recebeAtaqueElfo() {
        perderVida(8);
    }
    
    public void atacarAnao(Dwarf dwarf){
        if(podeAtacarComEspada()){
            dwarf.danoRecebido();
        }
        else if(podeAtacarComArco()) {
            dwarf.danoRecebido();
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }
    }
    
    public void atacarElfo(Elfo elfo){
        if(podeAtacarComEspada()){
            elfo.receberAtaqueOrc(this);
        }
        else if(podeAtacarComArco()) {
            elfo.receberAtaqueOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }
    }
    
    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }
        
        if(podeAtacarComArco()){
            return 8;
        }
        
        return 0;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            this.inventario.perdeItem(flecha);
        }
        else {
            flecha.perdeUnidade();
        }
    }
    
    private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }
    
    private boolean podeAtacarComArco(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;
        
        return temArco && temFlechaProArco;
    }
    
    private void perderVida(int qtdVidaPerdida) {
        this.vida -= qtdVidaPerdida;
        
        if(vida <= 0){
            vida = 0;
            this.status = Status.MORTO;
        }
        else {
            this.status = Status.FERIDO;
        }
    }
    
    private Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
    
    private void gerarInventario() {
        if(this.tipoOrc == TipoOrc.URUKHAI) {
            Item escudoUrukHai = new Item("Escudo Uruk-Hai",1);
            Item espada = new Item("Espada", 1);
            this.inventario.adicionarItem(escudoUrukHai);
            this.inventario.adicionarItem(espada);
        }
        else if(this.tipoOrc == TipoOrc.SNAGA){
            Item arco = new Item("Arco",1);
            Item flechas = new Item("Flecha",5);
            this.inventario.adicionarItem(arco);
            this.inventario.adicionarItem(flechas);
        }
    }
    
    private void gerarVidaInicial() {
        if(this.tipoOrc == TipoOrc.URUKHAI) {
            this.vida = 150;
        }
        else if(this.tipoOrc == TipoOrc.SNAGA){
            this.vida = 70;
        }
    }
    
} 
