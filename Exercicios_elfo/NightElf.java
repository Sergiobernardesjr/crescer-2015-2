import java.util.*;

public class NightElf extends Elfo{
    
    public NightElf(String nome){
        super(nome);
    }

    public NightElf(String nome, int flechas){
        super(nome,flechas);
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        this.experiencia += 2;
        double vidaPerdida = this.vida * 0.05;
        this.vida -= (int)vidaPerdida;
        this.status = this.vida == 0 ? Status.MORTO : this.status;
    }  
}