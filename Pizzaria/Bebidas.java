public class Bebidas extends Item {
    private TipoBebida tipo;
    public Bebidas(int bebida){
        if(bebida == 1){
            this.tipo = TipoBebida.LATA;
            valorUnitario = 3.50;
        }
        else if (bebida == 2){
            this.tipo = TipoBebida.DOISLITROS;
            valorUnitario = 7;
        }
    }
}
