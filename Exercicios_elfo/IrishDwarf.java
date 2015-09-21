import java.util.ArrayList;

public class IrishDwarf extends Dwarf {
    
   
    public IrishDwarf(String nome){
    }

    public IrishDwarf(String nome, DataTerceiraEra data){
    }

    public void tentarSorte(){
        double numero = getNumeroSorte();
        
        if (numero == -3333.0)
        {
            getInventario().irishSortudo();
        }   
    }
}
