

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
   @Test
   public void itemRecebeDesricaoEQuantidade(){
       Item arco = new Item("Arco",1);
       
       assertEquals("Arco", arco.getDescricao());
       assertEquals(1, arco.getQuantidade());
   }
}
