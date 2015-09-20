import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest
{
   @Test
   public void adicionarItemNoInventario(){
       Inventario inv = new Inventario();
       String item = "item1";
       
       inv.adicionarItem(item);
       
       assertEquals("item1", inv.getItem());
   }
}
