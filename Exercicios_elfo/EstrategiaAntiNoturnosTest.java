import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAntiNoturnosTest {
    /**
     * 4 Elfos (3 Noturnos + 1 Verde) * 2 Anões = 8 intenções
     * 8 intenções * 0.3 = 2.4 elfos noturnos podem atacarDwarf.
     * Só 2 noturnos (parte inteira de 2.4) podem atacarDwarf
     **/
    @Test
    public void quatroElfos3Noturnos1VerdeAtacam2AnoesMasSo2NoturnosPodematacarDwarf() {
        
        // Arrange
        Dwarf balin = new Dwarf("Balin");
        Dwarf stalin = new Dwarf("Stalin");
        double vidaEsperada = 80;
        Elfo green1 = new GreenElf("Green Elf1");
        
        Elfo night1 = new NightElf("Night Elf2");
        Elfo night2 = new NightElf("Night Elf3");
        Elfo green2 = new GreenElf("Green 1");
        
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new EstrategiaAntiNoturnos());
        exercito.alistarElfo(green1);
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        exercito.alistarElfo(green2);        
        dwarves.add(balin);
        dwarves.add(stalin);
        
        exercito.atacarDwarf(dwarves);
        // Assert
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();

        int noturnosQueAtiraram = 0;

        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof NightElf) {
                noturnosQueAtiraram++;
            }
        }

        assertEquals(1, noturnosQueAtiraram);
        assertEquals(vidaEsperada, balin.getVida(), 0.0000001);
        assertEquals(vidaEsperada, stalin.getVida(),0.0000001);
    }

    /**
     * 4 Elfos (2 noturnos vivos - 1 noturno morto + 1 Verde) * 2 Anões = 6 intenções
     * 6 intenções * 0.3 = 1.8 elfos noturnos podem atacarDwarf.
     * Só 1 noturno (parte inteira de 1.8) pode atacarDwarf
     **/
    @Test
    public void quatroElfos3NoturnosSendoUmMortoE1VerdeAtacam2AnoesMasSo1NoturnoPodeatacarDwarf() {
        // Arrange
        Dwarf balin = new Dwarf("Balin");
        Dwarf stalin = new Dwarf("Stalin");
        double vidaEsperada = 90;
        Elfo noturno1 = new NightElf("Night Elf1");
        Elfo noturno2 = new NightElf("Night Elf2");
        Elfo noturno3 = new NightElf("Night Elf3");
        for (int i = 0; i<900; i++) {
            noturno3.atirarFlecha(new Dwarf("joel"+i));
        }
        Elfo verde1 = new GreenElf("Green 1");
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new EstrategiaAntiNoturnos());
        exercito.alistarElfo(noturno1);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(noturno3);
        exercito.alistarElfo(verde1);
        // Act
        exercito.atacarDwarf(new ArrayList<>(Arrays.asList(balin, stalin)));
        // Assert
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();

        int noturnosQueAtiraram = 0;
        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof NightElf) {
                noturnosQueAtiraram++;
            }
        }

        assertEquals(1, noturnosQueAtiraram);
        assertEquals(vidaEsperada, balin.getVida(), .0);
        assertEquals(vidaEsperada, stalin.getVida(), .0);
    }
}