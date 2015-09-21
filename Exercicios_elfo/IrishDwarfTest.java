
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void IrishDwarfRecebeVidaEExperiencia(){
        IrishDwarf gloin = new IrishDwarf("Gloin");
        assertEquals("Gloin", gloin.getNome());
        assertEquals(0, gloin.getExperiencia());
    }

    @Test
    public void testeNomeSemInformarDataNascimento(){
        IrishDwarf ion = new IrishDwarf("ion");
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,1,1);
        DataTerceiraEra dataObtida = ion.getDataNascimento();

        assertEquals(dataEsperada, dataObtida);
    }

    @Test
    public void IrishDwarfNasceComNomeEDataInformadoPeloUsuario(){
        IrishDwarf anao = new IrishDwarf("anao",new DataTerceiraEra(11,02,1995));
        DataTerceiraEra esperada = new DataTerceiraEra(11,02,1995);

        assertEquals(esperada, anao.getDataNascimento());
    }

    @Test
    public void quandoIrishDwarfNasceCom110DeVida(){
        IrishDwarf gimli = new IrishDwarf("Gimli");
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void IrishDwarfNasceVivo(){
        IrishDwarf gimli = new IrishDwarf("Gimli");
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void danoRecebidoIrishDwarfEPerde10DeVida(){
        // AAA
        //Arrange (arranjo para o teste)
        IrishDwarf gimli = new IrishDwarf("Gimli");

        //Act (ato, ação para estar)
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido(); 
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido();
        gimli.danoRecebido();

        //Assert (Validação do reste)
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void IrishDwarfReceb12FlechasEMorre(){
        // AAA
        //Arrange (arranjo para o teste)
        IrishDwarf gimli = new IrishDwarf("Gimli");

        //Act (ato, ação para estar)
        gimli.danoRecebido();

        //Assert (Validação do reste)
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void quandoIrishDwarfEMeirelesNãoRecebeDano(){
        IrishDwarf meireles = new IrishDwarf("Meireles", new DataTerceiraEra(1,1,2015));
        int vidaEsperada = 110;

        meireles.danoRecebido();

        assertEquals(vidaEsperada, meireles.getVida());
    }

    @Test
    public void quandoIrishDwarfESeixasNãoRecebeDano(){
        IrishDwarf seixas = new IrishDwarf("Seixas", new DataTerceiraEra(1,1,2015));
        int vidaEsperada = 110;

        seixas.danoRecebido();

        assertEquals(vidaEsperada, seixas.getVida());
    }    

    @Test
    public void numeroDaSorteEstaCalculandoCertoConformeParametrosDoIrishDwarf(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,2000);
        IrishDwarf gnomo = new IrishDwarf("Gnomo", dataNascimento);
        double numeroSorteEsperado = 101.0;

        assertTrue(numeroSorteEsperado == gnomo.getNumeroSorte());
    }

    @Test
    public void gerarNumeroAnoBissestoVidaEntre80E90(){
        //arrange
        IrishDwarf balin = new IrishDwarf("balin");

        double resultado = balin.getNumeroSorte();

        assertEquals(101.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        IrishDwarf seixas = new IrishDwarf("Seixas", new DataTerceiraEra(01, 01, 2015));

        double resultado = seixas.getNumeroSorte();

        assertEquals(33.0, resultado, 0.00001);
    }

    @Test
    public void IrishDwarfQueNasceAnoBissestoRecebeTresFlechas(){
        IrishDwarf IrishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,2000));
        IrishDwarf.danoRecebido();
        IrishDwarf.danoRecebido();

        IrishDwarf.danoRecebido();

        assertEquals(2, IrishDwarf.getExperiencia());
        assertEquals(90, IrishDwarf.getVida());
    }

    @Test
    public void IrishDwarfReceberFlechadaComAnoNormalMeireles(){
        IrishDwarf IrishDwarf = new IrishDwarf("Meireles");
        IrishDwarf.danoRecebido();
        assertEquals(0, IrishDwarf.getExperiencia());
        assertEquals(110, IrishDwarf.getVida());
    }

    @Test
    public void IrishDwarfReceberFlechadaNormal(){
        IrishDwarf IrishDwarf = new IrishDwarf("Joao");

        IrishDwarf.danoRecebido();

        assertEquals(0, IrishDwarf.getExperiencia());
        assertEquals(100, IrishDwarf.getVida());
    }

    @Test
    public void mostrarItensQueOIrishDwarfTem(){
        IrishDwarf ion = new IrishDwarf("Cezar");
        Item item = new Item("Machado",2);
        Item itemEsperado = new Item("Machado",2);
        ion.getInventario().adicionarItem(item);

        assertEquals((itemEsperado),(ion.getInventario().getItem().get(0)));

    }

    @Test
    public void mostrarItensQueIrishDwarfSortudoTem(){
        IrishDwarf ion = new IrishDwarf("Cezar", new DataTerceiraEra(1,1,2000));
        Item item = new Item("Machado",3);
        Item itemEsperado = new Item("Machado",6003);

        ion.getInventario().adicionarItem(item);

        ion.danoRecebido();
        ion.danoRecebido();

        ion.tentarSorte();

        assertEquals((itemEsperado),(ion.getInventario().getItem().get(0)));
    }

    @Test
    public void mostrarItensQueIrishDwarfTemSortudo(){
        IrishDwarf ion = new IrishDwarf("Cezar");
        Item item = new Item("Machado",3);
        Item itemEsperado = new Item("Machado",3);

        ion.getInventario().adicionarItem(item);

        ion.danoRecebido();
        ion.danoRecebido();

        ion.tentarSorte();

        assertEquals((itemEsperado),(ion.getInventario().getItem().get(0)));
    }

    @Test
    public void irishDwarfAnoNormalMeirelesNãoÉSortudo(){
        IrishDwarf ion = new IrishDwarf("Meireles");
        Item item = new Item("Machado",3);
        Item itemEsperado = new Item("Machado",3);
        
        ion.getInventario().adicionarItem(item);

        ion.danoRecebido();        

        ion.tentarSorte();

        assertEquals(itemEsperado,ion.getInventario().getItem().get(0));
    }
}
