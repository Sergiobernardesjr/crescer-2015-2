

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GreenElfTest {
    @Test
    public void elfoAtacaDwarfEGanhaDobroDeExperiencia(){
        GreenElf elfo = new GreenElf("Elfo");
        Dwarf dwarf = new Dwarf("dwarf");
        int flechasEsperada = 41, 
            experienciaEsperada = 2;
            
        elfo.atirarFlecha(dwarf);
        
        assertEquals(flechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
    }
    
    @Test
    public void elfoAtacaIrishDwarfEGanhaDobroDeExperiencia(){
        GreenElf elfo = new GreenElf("Elfo");
        IrishDwarf dwarf = new IrishDwarf("dwarf");
        int flechasEsperada = 41, 
            experienciaEsperada = 2;
            
        elfo.atirarFlecha(dwarf);
        
        assertEquals(flechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
    }    
}
