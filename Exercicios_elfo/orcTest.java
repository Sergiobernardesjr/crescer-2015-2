

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class orcTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class orcTest
{
    @Test
    public void orcaÉUrukHaiEComecaComUmEscudoUrukHaiE250DeVida(){
        Orc orc = new Orc();
        orc.orcUrukHai();
        Item itemEsperado = new Item("Escudo Uruk Hai",1);
        assertEquals(250, orc.getVida());
        assertEquals(itemEsperado, orc.getInventario().getItem().get(0));
    }
    
    @Test
    public void orcaÉSnagaComecaComArcoE5FlechasE70DeVida(){
        Orc orc = new Orc();
        orc.orcSnaga();
        Item itemEsperado = new Item("Arco", 5);
        assertEquals(70, orc.getVida());
        assertEquals(itemEsperado, orc.getInventario().getItem().get(0));
    }
}
