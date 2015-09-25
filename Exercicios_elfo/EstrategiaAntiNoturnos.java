import java.util.*;

public class EstrategiaAntiNoturnos implements EstrategiaDeAtaque {
    
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }

    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves) {
        this.ordemDoUltimoAtaque.clear();

        ArrayList<Elfo> vivos = new ArrayList<>();

        for (Elfo elfo : elfos) {
            if (elfo.getStatus() == Status.VIVO) {
                vivos.add(elfo);
            }
        }

        int intencoesAtaque = vivos.size() * dwarves.size();
        int limiteElfosNoturnos = (int)(intencoesAtaque * 0.3);
        int qtdElfosNoturnosQueJáAtacaram = 0;

        for (Elfo elfoQueVaiAtacar : vivos) {
            boolean éElfoNoturno = elfoQueVaiAtacar instanceof NightElf;

            if (éElfoNoturno) {
                if (qtdElfosNoturnosQueJáAtacaram >= limiteElfosNoturnos){
                    continue;
                }
                qtdElfosNoturnosQueJáAtacaram++;
            }

            ordemDoUltimoAtaque.add(elfoQueVaiAtacar);
            for (Dwarf dwarf : dwarves) {
                elfoQueVaiAtacar.atirarFlecha(dwarf);
            }
        }
    }
}