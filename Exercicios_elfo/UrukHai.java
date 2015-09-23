
public class UrukHai extends Orc {
    public UrukHai()
    {
        vida = 150;
        Item escudoUrukHai = new Item("Escudo Uruk Hai",1);
        Item espada = new Item("Espada", 1);
        super.adicionarItem(escudoUrukHai);
        super.adicionarItem(espada);
    }    
}
