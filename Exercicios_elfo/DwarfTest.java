
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
        Dwarf ion = new Dwarf("Ion");
        DataTerceiraEra data = ion.getDataNascimento();
        assertEquals(17, data.getDia());
        assertEquals(9, data.getMes());
        assertEquals(2015, data.getAno());
    }
    
    @Test
    public void testeNomeInformandoDataNascimento(){
//        Dwarf ion = new Dwarf("
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

        //Assert (Validação do reste)
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void aMorteDoAnao(){
        Dwarf gimli = new Dwarf("Gimli");
        int i;
        for (i = 0;i <= 10; i++){
            gimli.danoRecebido();
        }
        assertEquals(Status.MORTO, gimli.getStatus());
    }
}
