import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest
{
   @Test
   public void adicionarItemNoInventario(){
       Item itemEsperado = new Item("vida", 2);
       Inventario inv = new Inventario();
       
       inv.adicionarItem(new Item("vida", 2));
       
       assertTrue((inv.getItem().get(0)).equals(itemEsperado));
   }
}
