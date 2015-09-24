import java.util.*;

public class Exercito{
    private HashMap<String,Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> agrupadorPorStatus = new HashMap<Status, ArrayList<Elfo>>();
    
    public Exercito(){
    }
    
    public void alistarElfo(Elfo elfo){
        boolean nightElfOuGreenElf = (elfo instanceof NightElf || elfo instanceof GreenElf) && elfo.getNome() != null;
        
        if (nightElfOuGreenElf){
            exercito.put(elfo.getNome(),elfo);
        }
    }    
    
    public void agruparPorStatus(){
        for (Elfo elfo : exercito.values()){
            if (!agrupadorPorStatus.containsKey(elfo.getStatus())){//verificar no hashmap exercito se não existe status no elfo
                agrupadorPorStatus.put(elfo.getStatus(),new ArrayList<Elfo>());
            }
            agrupadorPorStatus.get(elfo.getStatus()).add(elfo); // hashmap exercito pega o status do elfo e adiciona o elfo em um array
        }
    }
    
    public ArrayList<Elfo> buscar(Status status){
        return agrupadorPorStatus.get(status);
    }
    
    public Elfo buscarPorNome(String nome){
        return exercito.get(nome);
    }
    
    public HashMap getExercito(){
        return exercito;
    }
}