public class Orc extends Personagem{

    public Orc(){
    }
    
    public void recebeAtaque() {
        
        if(getItem("Escudo Uruk Hai") == null){
            perderVida(10);
        }
        else {
            perderVida(6);
        }
    }
    
    public void atacar(Personagem personagem){
        if(podeAtacarComEspada() || podeAtacarComArco()){
            personagem.receberAtaqueOrc(this);
            
            if (podeAtacarComArco()){
                debitarFlecha();
            }
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
    
    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            super.removerItem(flecha);
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
            super.status = Status.MORTO;
        }
        else {
            super.status = Status.FERIDO;
        }
    }  
} 
