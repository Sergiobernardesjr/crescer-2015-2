
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnagaTest {
    @Test
    public void snagaNasceComArcoE5Flechas(){
        Orc snaga = new Snaga();

        int vidaEsperada = 70;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item("Arco",1));
        inventarioEsperado.adicionarItem(new Item("Flecha",5));

        assertEquals(vidaEsperada, snaga.getVida(),0.00001);
        assertEquals(inventarioEsperado, snaga.getInventario());
    }

    @Test
    public void snagaTomaAtaque(){
        Orc snaga = new Snaga();

        int vidaEsperada = 60;

        snaga.recebeAtaque();

        assertEquals(vidaEsperada, snaga.getVida(),0.00001);
    }

    @Test
    public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
        Orc snaga = new Snaga();
        Elfo elfo = new Elfo("elfo");

        for(int i = 0; i < 6; i++){
            snaga.atacar(elfo);
        }

        assertEquals(Status.FUGINDO, snaga.getStatus());
    }

    @Test
    public void orcSnagaAtiraFlechaElfoEFicaCom4Flechas(){

        Orc snaga = new Snaga();
        Elfo elfo = new Elfo(null);

        snaga.atacar(elfo);

        int qtdFlechas = snaga.getInventario().getItemPorDescricao("Flecha").getQuantidade();

        assertEquals(4, qtdFlechas);

    }

    @Test
    public void orcSnaga6PorQueTemEscudoUrukHai(){
        Orc snaga = new Snaga();

        snaga.adicionarItem(new Item("Escudo Uruk Hai", 1));

        snaga.recebeAtaque();

        assertEquals(64, snaga.getVida(),0.00001);
    }

    @Test
    public void orcSnagaCausa8DeDanoEmElfoAtacandoComArco(){
        Orc snaga = new Snaga();
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 92;

        snaga.atacar(legolas);

        assertEquals(vidaEsperada, legolas.getVida(),0.00001);
    }

    @Test
    public void orcSnagaCausa12DeDanoEmElfoComEspadaEAtacou(){
        Orc snaga = new Snaga();
        snaga.adicionarItem(new Item("Espada", 1));
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 88;

        snaga.atacar(legolas);

        assertEquals(vidaEsperada, legolas.getVida(),0.00001);
    }

    @Test
    public void orcSnagaFogePorqueNaoTemArmaParaAtacar(){
        Orc snaga = new Snaga();
        snaga.removerItem(new Item("Arco",1));
        snaga.removerItem(new Item("Flecha",5));
        Elfo legolas = new Elfo("Legolas");
        int vidaEsperada = 100;

        snaga.atacar(legolas);

        assertEquals(Status.FUGINDO, snaga.getStatus());
        assertEquals(vidaEsperada, legolas.getVida(),0.00001);
    }
    
     @Test
    public void orcSnagaRecebeAtaqueDeOrcUrukHai(){
        Orc snaga = new Snaga();
        Orc urukHai = new UrukHai();
        
        snaga.receberAtaqueOrc(urukHai);
        
        assertEquals(58, snaga.getVida(),0.00001);
    }
    
    @Test
    public void orcSnagaRecebeAtaqueDeOrcSnaga(){
        Orc snagaAlvo = new Snaga();
        Orc snagaAtacante = new Snaga();
        
        snagaAlvo.receberAtaqueOrc(snagaAtacante);
        
        assertEquals(62, snagaAlvo.getVida(),0.00001);
    }
}
