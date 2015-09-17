

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void default42Flechas(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(42, legolas.getFlechas());
    }
    
     @Test
    public void acertarVerdadeiro(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(true, legolas.acertar());
    }
    
      @Test
    public void acertarFalso(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(true, legolas.acertar());
    }

}