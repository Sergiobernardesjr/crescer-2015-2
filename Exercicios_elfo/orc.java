public class orc 
 { 
     public int vida; 
      
     protected Item arco; 
     protected Item flecha1; 
     protected Item flecha2; 
     protected Item flecha3; 
     protected Item escudoUrukHai; 
     
     public orc() 
     { 
         int vida = 250; 
     } 
 
     public void gerarVida(int vidaAleatoria) { 
          
         vida = vidaAleatoria; 
     } 
     
    public void receverFlechaDeElfo(/*Elfo elfo*/) { 
         
        if(this.escudoUrukHai == null) { 
            gerarVida(this.vida - 10); 
        } 
         
        gerarVida(this.vida - 5); 
    } 
     
    public void receverFlechaDeDwarf(/*Dwarf elfo*/) { 
        if(this.escudoUrukHai == null) { 
            gerarVida(this.vida - 10); 
        } 
         
        gerarVida(this.vida - 5); 
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
         anao.vida -= 10; 
          
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
         } 
     } 
      
 } 
