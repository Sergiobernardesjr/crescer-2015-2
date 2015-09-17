
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void quandoDwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void danoRecebidoDwarfEPerde10DeVida(){
        // AAA
        //Arrange (arranjo para o teste)
        Dwarf gimli = new Dwarf();

        //Act (ato, ação para estar)
        gimli.danoRecebido();

        //Assert (Validação do reste)
        assertEquals(100, gimli.getVida());
    }
}
