
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NightElfTest
{
    @Test
    public void nightElfAtacaDwarfEGanhaTriploDeExperienciaEPerdeVida(){
        Elfo elfo = new NightElf("Elfo");
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
        Elfo elfo = new NightElf("Elfo");
        Dwarf dwarf = new IrishDwarf("dwarf");
        int flechasEsperada = 41, 
        experienciaEsperada = 3;
        double vidaEsperada = 95;

        elfo.atirarFlecha(dwarf);

        assertEquals(flechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperada, elfo.getVida(),0.00001);
    }   

    @Test
    public void elfoAtacaDwarfEIrishDwarfEGanha6DeExperienciaEPerdeVidaPorAtaque(){
        Elfo elfo = new NightElf("Elfo");
        Dwarf dwarf = new IrishDwarf("Dwarf");
        Dwarf dwarf2 = new Dwarf("Dwarfx");
        
        int flechasEsperada = 40,
        experienciaEsperada = 6;
        double vidaEsperada = 0,
        vida1,
        vidaPerdida;
        
        vida1 = (100*0.95);
        vidaPerdida = vida1 * 0.95;
        vidaEsperada = (int)vidaPerdida;
        
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf2);
        
        assertEquals(flechasEsperada, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida(),0.00001);
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(Status.VIVO, elfo.getStatus());
        
    }
    
        @Test
    public void elfoAtacaDwarfEMorre(){
        Elfo elfo = new NightElf("Elfo");
        Dwarf dwarf = new Dwarf("dwarf");
        
        double vidaEsperada = 0;
        for(int i = 0; i <= 100; i++){
            elfo.atirarFlecha(dwarf);
        }
        
        assertEquals(vidaEsperada, elfo.getVida(),0.00001);
        assertEquals(Status.MORTO, elfo.getStatus());
        
    }
}
