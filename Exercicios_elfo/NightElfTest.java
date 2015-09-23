
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NightElfTest
{
    @Test
    public void nightElfAtacaDwarfEGanhaTriploDeExperienciaEPerdeVida(){
        NightElf elfo = new NightElf("Elfo");
        Dwarf dwarf = new Dwarf("dwarf");
        int flechasEsperada = 41, 
        experienciaEsperada = 3;
        double vidaEsperada = 95;

        elfo.atirarFlecha(dwarf);

        assertEquals(flechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperada, elfo.getVida(),0.00001);
    }

    @Test
    public void elfoAtacaIrishDwarfEGanhaTriploDeExperiencia(){
        NightElf elfo = new NightElf("Elfo");
        IrishDwarf dwarf = new IrishDwarf("dwarf");
        int flechasEsperada = 41, 
        experienciaEsperada = 3;
        double vidaEsperada = 95;

        elfo.atirarFlecha(dwarf);

        assertEquals(flechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperada, elfo.getVida(),0.00001);
    }   

}
