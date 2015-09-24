import java.util.*;

public class Exercito{
    private Map<Status, ArrayList<Elfo>> exercito = new HashMap<>();
    
    public Exercito(){
    }
    
    public void alistarElfo(Elfo elfo){
        String nomeElfo;
        boolean nightElfOuGreenElf = (elfo instanceof NightElf || elfo instanceof GreenElf) && elfo.getNome() != null;
        
        if (nightElfOuGreenElf){
            exercito.put(elfo.getStatus(),new ArrayList<Elfo>());
        }
 
    }    
}