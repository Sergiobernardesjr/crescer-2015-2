public class Orc 
{ 
    public int vida; 

    private Inventario inventario = new Inventario();
    private Item arco = new Item("Arco", 5);; 
    private Item flecha1; 
    private Item flecha2; 
    private Item flecha3; 
    private Item escudoUrukHai = new Item("Escudo Uruk Hai", 1); 

    public Orc(){ 
        this.vida = 250;
    }

    public void orcUrukHai(){
        this.vida = 250;
        inventario.adicionarItem(escudoUrukHai);
    }
    
    public void orcSnaga(){
        this.vida = 70;
        inventario.adicionarItem(arco);
    }

    public void recebeAtaqueElfo() { 

        if(inventario.escudoUrukHai()) { 
            this.vida -= 4; 
        } 
        else{
            this.vida -= 8; 
        }
    } 

    public void recebeAtaqueDwarf() { 

        if(inventario.escudoUrukHai()) { 
            this.vida -= 5; 
        }
        else{
            this.vida -= 10;
        }
    } 

    public void adicionarNovoItem(Item i) { 

        if(i.getDescricao() == "Escudo UrukHai") { 
            this.escudoUrukHai = i; 
        } 
        else if(i.getDescricao().indexOf("Flecha") >= 0) { 

            if(i.getDescricao() == "Flecha1") 
                this.flecha1 = i; 
            if(i.getDescricao() == "Flecha2") 
                this.flecha2 = i; 
            if(i.getDescricao() == "Flecha3") 
                this.flecha3 = i; 
            else {
                this.arco = new Item("Arco  Uruk Hay",1); 
                this.flecha1 = new Item("Flecha", 1); 
            } 
        }
        else { 
            this.arco = i; 
        } 

    } 

    public void atacarAnao(Dwarf anao) { 
        /*   anao.vida -= 10; 

        for (Item item : new Item(this.novosItens)) { 

        ArrayList<int> numeroDeFlechas = new ArrayList<int>(); 
        numeroDeFlechas.add(1); 
        numeroDeFlechas.add(2); 
        numeroDeFlechas.add(3); 

        for(int i = 0; i < 3;i++) { 

        if(item.getDescricao() == "Flecha" + i) { 
        this.novosItens.remove(item); 
        } 
        } 
        } */
    } 

    public int getVida(){
        return this.vida;
    }

    public Inventario getInventario(){
        return this.inventario;
    }
} 
