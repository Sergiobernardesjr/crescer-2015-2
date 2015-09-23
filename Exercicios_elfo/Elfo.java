public class Elfo extends Personagem {
    protected int flechas;

    public Elfo(String nome,Integer flechas)
    {
        this.nome = nome;
        if (flechas != null){
            this.flechas = flechas;
        }
        this.flechas = flechas;
        this.status = Status.VIVO;
        vida = 80;
    }

    public Elfo(String nome){
        this(nome,42);
        vida = 80;
    }

    public void atirarFlecha(Dwarf dwarf){
        this.experiencia++;
        dwarf.danoRecebido();
        this.flechas--;
    }
    
    public void atacarOrc(Orc orc){
        orc.recebeAtaque();
        this.flechas--;
    }

    public String toString(){
        boolean flechasPlural = Math.abs(this.flechas) != 1;

        boolean nivelNoSingular = Math.abs(this.experiencia) == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",this.nome, this.flechas, flechasPlural ? "flechas" : "flecha", this.experiencia, nivelNoSingular ? "nível" : "níveis");
    }

    public int getFlechas(){
        return this.flechas;
    }
}