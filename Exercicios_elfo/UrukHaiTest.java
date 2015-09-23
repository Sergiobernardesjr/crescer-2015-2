
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrukHaiTest {
    @Test
    public void urukHaiNasceComEspadaEEscudoE150DeVida(){
        Orc uruk = new UrukHai();

        int vidaEsperada = 150;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item("Escudo Uruk Hai",1));
        inventarioEsperado.adicionarItem(new Item("Espada",1));

        assertEquals(vidaEsperada, uruk.getVida(),0.00001);
        assertEquals(inventarioEsperado, uruk.getInventario());
    }

    @Test
    public void urukHaiTomaAtaque(){
        Orc uruk = new UrukHai();

        int vidaEsperada = 144;

        uruk.recebeAtaque();

        assertEquals(vidaEsperada, uruk.getVida(),0.00001);
    }

    @Test
    public void urukHaiNaoTemEspadaENemArcoEFoge(){
        Orc uruk = new UrukHai();
        Elfo elfo = new Elfo("elfo");
        Item item = new Item("Espada", 1);
        uruk.removerItem(item);
        
        uruk.atacar(elfo);
        
        assertEquals(Status.FUGINDO, uruk.getStatus());
    }

    @Test
    public void urukHaiPerde10DeVidaPorQueNãoTemEscudoUrukHai(){
        Orc uruk = new UrukHai();
        uruk.removerItem(new Item("Escudo Uruk Hai", 1));
        uruk.recebeAtaque();

        assertEquals(140, uruk.getVida(),0.00001);
    }

    @Test
    public void urukHaiCausa8DeDanoEmElfoAtacandoComArco(){
        Orc uruk = new UrukHai();
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 92;
        Item espada = new Item("Espada", 1);
        Item arco = new Item("Arco", 1);
        Item flechas = new Item("Flecha", 3);
        
        uruk.removerItem(espada);
        uruk.adicionarItem(arco);
        uruk.adicionarItem(flechas);
        
        uruk.atacar(legolas);

        assertEquals(vidaEsperada, legolas.getVida(),0.00001);
    }

    @Test
    public void urukHaiCausa12DeDanoEmElfoComEspadaEAtacou(){
        Orc uruk = new UrukHai();
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 88;

        uruk.atacar(legolas);

        assertEquals(vidaEsperada, legolas.getVida(),0.00001);
    }

    @Test
    public void urukHaiFogePorqueNaoTemArmaParaAtacar(){
        Orc uruk = new UrukHai();
        uruk.removerItem(new Item("Espada",1));
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 100;

        uruk.atacar(legolas);

        assertEquals(Status.FUGINDO, uruk.getStatus());
        assertEquals(vidaEsperada, legolas.getVida(),0.00001);
    }
    
     @Test
    public void utukHaiRecebeAtaqueDeOrcSnaga(){
        Orc snaga = new Snaga();
        Orc urukHai = new UrukHai();
        
        urukHai.receberAtaqueOrc(snaga);
        
        assertEquals(142, urukHai.getVida(),0.00001);
    }
    
    @Test
    public void urukHaiRecebeAtaqueDeOrcUrukHai(){
        Orc urukAlvo = new UrukHai();
        Orc urukAtacante = new UrukHai();
        
        urukAlvo.receberAtaqueOrc(urukAtacante);
        
        assertEquals(138, urukAlvo.getVida(),0.00001);
    }
}
