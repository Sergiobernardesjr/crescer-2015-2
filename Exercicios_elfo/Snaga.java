
public class Snaga extends Orc
{

    public Snaga()
    {
        super.vida = 70;
        Item arco = new Item("Arco",1);
        Item flechas = new Item("Flecha",5);
        super.adicionarItem(arco);
        super.adicionarItem(flechas);
    }

}
