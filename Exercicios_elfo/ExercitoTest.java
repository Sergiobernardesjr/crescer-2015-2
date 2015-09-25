
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoTest
{
    @Test
    public void greenElfAlistado(){
        Exercito exercito = new Exercito(); //cria um exercito
        GreenElf verde = new GreenElf("Homem-aranha"); // cria um elfo verde para alistar;

        exercito.alistarElfo(verde); //alista um elfo verde no exercito declado acima.

        assertEquals(verde, exercito.getExercito().get("Homem-aranha")); //verifica buscando pelo nome se existe o elfo verde no hashmap.
    }

    @Test
    public void nightElfAlistado(){
        Exercito exercito = new Exercito(); //cria um exercito
        NightElf noturno = new NightElf("X-Men"); // cria um elfo verde para alistar;

        exercito.alistarElfo(noturno); //alista um elfo verde no exercito declado acima.

        assertEquals(noturno, exercito.getExercito().get("X-Men")); //verifica buscando pelo nome se existe o elfo verde no hashmap.
    }
    
    @Test
    public void greenElfAgrupadoPorStatusVivo(){
        Exercito exercito = new Exercito();
        GreenElf verdinho = new GreenElf("Elfinho");
        
        exercito.alistarElfo(verdinho);
        exercito.agruparPorStatus();
        
        assertEquals(verdinho, exercito.buscar(Status.VIVO).get(0));
    }

}
