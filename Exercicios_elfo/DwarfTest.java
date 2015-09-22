
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfRecebeVidaEExperiencia(){
        Dwarf gloin = new Dwarf("Gloin");
        assertEquals("Gloin", gloin.getNome());
        assertEquals(0, gloin.getExperiencia());
    }

    @Test
    public void testeNomeSemInformarDataNascimento(){
        Dwarf ion = new Dwarf("ion");
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,1,1);
        DataTerceiraEra dataObtida = ion.getDataNascimento();
        
        assertEquals(dataEsperada, dataObtida);
    }

    @Test
    public void dwarfNasceComNomeEDataInformadoPeloUsuario(){
        Dwarf anao = new Dwarf("anao",new DataTerceiraEra(11,02,1995));
        DataTerceiraEra esperada = new DataTerceiraEra(11,02,1995);
        
        assertEquals(esperada, anao.getDataNascimento());
    }

    @Test
    public void quandoDwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfNasceVivo(){
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void danoRecebidoDwarfEPerde10DeVida(){
        // AAA
        //Arrange (arranjo para o teste)
        Dwarf gimli = new Dwarf("Gimli");

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
    public void dwarfReceb12FlechasEMorre(){
        // AAA
        //Arrange (arranjo para o teste)
        Dwarf gimli = new Dwarf("Gimli");

        //Act (ato, ação para estar)
        gimli.danoRecebido();

        //Assert (Validação do reste)
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void quandoDwarfEMeirelesNãoRecebeDano(){
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(1,1,2015));
        int vidaEsperada = 110;

        meireles.danoRecebido();

        assertEquals(vidaEsperada, meireles.getVida());
    }

    @Test
    public void quandoDwarfESeixasNãoRecebeDano(){
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(1,1,2015));
        int vidaEsperada = 110;

        seixas.danoRecebido();

        assertEquals(vidaEsperada, seixas.getVida());
    }    

    @Test
    public void numeroDaSorteEstaCalculandoCertoConformeParametrosDoDwarf(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,2000);
        Dwarf gnomo = new Dwarf("Gnomo", dataNascimento);
        double numeroSorteEsperado = 101.0;

        assertTrue(numeroSorteEsperado == gnomo.getNumeroSorte());
    }
    
    @Test
    public void gerarNumeroAnoBissestoVidaEntre80E90(){
        //arrange
        Dwarf balin = new Dwarf("balin");
        
        double resultado = balin.getNumeroSorte();
        
        assertEquals(101.0, resultado, 0.00001);
    }
    
    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(01, 01, 2015));
       
        double resultado = seixas.getNumeroSorte();
       
        assertEquals(33.0, resultado, 0.00001);
    }
    
    @Test
    public void dwarfQueNasceAnoBissestoRecebeTresFlechas(){
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,2000));
        dwarf.danoRecebido();
        dwarf.danoRecebido();
        
        dwarf.danoRecebido();
        
        assertEquals(2, dwarf.getExperiencia());
        assertEquals(90, dwarf.getVida());
    }
    
    @Test
    public void dwarfReceberFlechadaComAnoNormalMeireles(){
        Dwarf dwarf = new Dwarf("Meireles");
        dwarf.danoRecebido();
        assertEquals(0, dwarf.getExperiencia());
        assertEquals(110, dwarf.getVida());
    }
    
    @Test
    public void dwarfReceberFlechadaNormal(){
        Dwarf dwarf = new Dwarf("Joao");
        
        dwarf.danoRecebido();
        
        assertEquals(0, dwarf.getExperiencia());
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void mostrarItensQueODwarfTem(){
        Dwarf ion = new Dwarf("Cezar");
        Item item = new Item("Machado",2);
        Item itemEsperado = new Item("Machado",2);
        ion.getInventario().adicionarItem(item);
        
        assertEquals((itemEsperado),(ion.getInventario().getItem().get(0)));
    }
    
    @Test
    public void dwarfAtacaOrcaUrukHaiComEscudo(){
        Dwarf ion = new Dwarf("Atacadinho");
        Orc orc = new Orc();
        int vidaEsperada = 245;
        
        orc.orcUrukHai();
        
        ion.atacarOrc(orc);
        
        assertEquals(vidaEsperada, orc.getVida());
    }
    
    @Test
    public void dwarfAtacaOrcaUrukHaiSemEscudo(){
        Dwarf ion = new Dwarf("Atacadinho");
        Orc orc = new Orc();
        int vidaEsperada = 240;
         
        ion.atacarOrc(orc);
        
        assertEquals(vidaEsperada, orc.getVida());
    }    
}
