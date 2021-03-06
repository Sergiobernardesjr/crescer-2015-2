
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoCriadoComNomeNasceCom42Flechas(){
        Elfo joao = new Elfo("Joao");
        assertEquals(42, joao.getFlechas());
    }

    @Test
    public void verificaOContadorDeUmElfosCriados(){
        int contadorEsperado = 1;
        
        new Elfo("Legolas");

        assertEquals (contadorEsperado, Elfo.getContadorElfo());
    }

    @Test
    public void verificaOContadorCriando100Elfos(){
        int esperado = 100;
        for (int i = 0; i < 100; i++){
            Elfo elfo = new Elfo("legolinha" + 1);
        }         
        assertEquals(esperado,Elfo.getContadorElfo());
    }

    @Before
    public void setUp(){
        Elfo.resetaContador();
    }

    @Test
    public void elfoNasceVivo(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(Status.VIVO, legolas.getStatus());
    }

    @Test
    public void elfoCriadoComNomeNull(){
        Elfo elfo1 = new Elfo(null);
        assertNull(elfo1.getNome());  
    }

    @Test
    public void elfoCriadoComNomeVazio(){
        Elfo elfo1 = new Elfo("");
        assertEquals("",elfo1.getNome());  
    }

    @Test
    public void elfoNasceComExperienciaZero(){
        Elfo zerinho = new Elfo("Zerinho");
        assertEquals(0, zerinho.getExperiencia());
    }

    @Test
    public void elfoCriadoComNomeRecebidoMediasFlechas(){
        Elfo elfis = new Elfo("Elfis", 10);
        assertEquals("Elfis", elfis.getNome());
        assertEquals(10, elfis.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeRecebidoComMuitasFlechas(){
        Elfo elfis = new Elfo("Elfis", 8293828);
        assertEquals("Elfis", elfis.getNome());
        assertEquals(8293828, elfis.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeRecebidoDevendoFlechas(){
        Elfo elfis = new Elfo("Elfis", -10);
        assertEquals("Elfis", elfis.getNome());
        assertEquals(-10, elfis.getFlechas());
    }

    @Test
    public void elfoAtiraFlechaDwarf(){
        //Arrange
        Elfo mirado = new Elfo("Mirado");
        Dwarf balin = new Dwarf("balin");
        int qtdFlechasEsperada = 41;
        int experienciaEsperada = 1;
        double vidaEsperada = 100;
        //Act
        mirado.atirarFlecha(balin);
        //Assert        
        assertEquals(qtdFlechasEsperada, mirado.getFlechas());
        assertEquals(experienciaEsperada, mirado.getExperiencia());
        assertEquals(vidaEsperada, balin.getVida(),0.000001);
    }

    @Test
    public void elfoAtacaOrcComEscudoUrukHai(){
        Elfo ninja = new Elfo("Ninja");
        UrukHai orc = new UrukHai();
        int qtdFlechasEsperada = 41;
        double vidaEsperada = 144;

        ninja.atacarOrc(orc);
        assertEquals(qtdFlechasEsperada, ninja.getFlechas());
        assertEquals(vidaEsperada, orc.getVida(),0.000001);
    }

    @Test
    public void elfoAtiraFlechaIrishDwarf(){
        //Arrange
        Elfo mirado = new Elfo("Mirado");
        IrishDwarf balin = new IrishDwarf("balin");
        int qtdFlechasEsperada = 41;
        int experienciaEsperada = 1;
        double vidaEsperada = 100;
        //Act
        mirado.atirarFlecha(balin);
        //Assert        
        assertEquals(qtdFlechasEsperada, mirado.getFlechas());
        assertEquals(experienciaEsperada, mirado.getExperiencia());
        assertEquals(vidaEsperada, balin.getVida(),0.000001);
    }

    @Test
    public void elfoAtiraEmDoisAnoes(){
        //Arrange
        Elfo mirado = new Elfo("Mirado");
        Dwarf balin = new Dwarf("balin");
        Dwarf gimli = new Dwarf("gimli");
        int qtdFlechasEsperada = 40;
        int experienciaEsperada = 2;
        double vidaEsperada = 100;
        //Act
        mirado.atirarFlecha(balin);
        mirado.atirarFlecha(gimli);
        //Assert        
        assertEquals(qtdFlechasEsperada, mirado.getFlechas());
        assertEquals(experienciaEsperada, mirado.getExperiencia());
        assertEquals(vidaEsperada, gimli.getVida(),0.000001);
        assertEquals(vidaEsperada, balin.getVida(),0.000001);
    }

    @Test
    public void elfoAtiraEmDoisIrishDwarf(){
        //Arrange
        Elfo mirado = new Elfo("Mirado");
        IrishDwarf balin = new IrishDwarf("balin");
        IrishDwarf gimli = new IrishDwarf("gimli");
        int qtdFlechasEsperada = 40;
        int experienciaEsperada = 2;
        double vidaEsperada = 100;
        //Act
        mirado.atirarFlecha(balin);
        mirado.atirarFlecha(gimli);
        //Assert        
        assertEquals(qtdFlechasEsperada, mirado.getFlechas());
        assertEquals(experienciaEsperada, mirado.getExperiencia());
        assertEquals(vidaEsperada, gimli.getVida(),0.000001);
        assertEquals(vidaEsperada, balin.getVida(),0.000001);
    }    

    @Test
    public void doisElfosAtiramEmDoisDwarves(){
        //Arrange
        Elfo mirado = new Elfo("Mirado");
        Elfo noob = new Elfo("noob");
        Dwarf balin = new Dwarf("balin");
        Dwarf gimli = new Dwarf("gimli");
        int qtdFlechasEsperada = 40;
        int experienciaEsperada = 2;
        double vidaEsperada = 90.0;
        //Act
        mirado.atirarFlecha(balin);
        mirado.atirarFlecha(gimli);
        noob.atirarFlecha(balin);
        noob.atirarFlecha(gimli);
        //Assert        
        assertEquals(qtdFlechasEsperada, mirado.getFlechas());
        assertEquals(experienciaEsperada, mirado.getExperiencia());
        assertEquals(vidaEsperada, gimli.getVida(),0.000001);
        assertEquals(vidaEsperada, balin.getVida(),0.000001);

        assertEquals(qtdFlechasEsperada, noob.getFlechas());
        assertEquals(experienciaEsperada, noob.getExperiencia());
        assertEquals(vidaEsperada, gimli.getVida(),0.000001);
        assertEquals(vidaEsperada, balin.getVida(),0.000001);
    }

    @Test
    public void elfoStringComNomeEFlechaEExperienciaSingular(){
        Elfo gnolim = new Elfo("Gnolim", 2);
        gnolim.atirarFlecha(new Dwarf("bofur"));
        assertEquals("Gnolim possui 1 flecha e 1 nível de experiência.", gnolim.toString());
    }

    public void elfoStringComNomeEFlechaEExperienciaPlural(){
        Elfo gnolim = new Elfo("Gnolim", 10); 

        assertEquals("Gnolim possui 10 flechas e 0 níveis de experiência.", gnolim.toString());
    }

    public void elfoPodeTerItens(){
        Elfo elfo = new Elfo("elfo");
        Item arco = new Item("Arco",1);
        Item itemEsperado = new Item ("Arco",1);

        elfo.getInventario().adicionarItem(arco);

        assertEquals(itemEsperado, elfo.getInventario().getItem().get(0));

    }

    public void elfoTemInventario(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals(new Inventario(), elfinho.getInventario());
    }
}