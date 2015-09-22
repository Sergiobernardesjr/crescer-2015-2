public class GreenElf extends Elfo{
    public GreenElf(String nome){
        super(nome);
    }

    public GreenElf(String nome, int flechas){
        super(nome,flechas);
    }

    private void gerarInventario() {
        Item espadaValiriano = new Item("Espada de aço valiriano",1);
        Item arcoDeVidro = new Item("Arco de vidro", 1);
        Item flechaDeVidro = new Item("Flecha de vidro", 1);
        this.inventario.adicionarItem(espadaValiriano);
        this.inventario.adicionarItem(arcoDeVidro);
        this.inventario.adicionarItem(flechaDeVidro);
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        this.experiencia ++;
    }
    /*
    public void atirarFlecha(IrishDwarf dwarf){
        super.atirarFlecha(dwarf);
        this.experiencia ++;
    }
     */  
}