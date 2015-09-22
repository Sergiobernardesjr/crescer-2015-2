public class Elfo
{
    private int flechas;
    private int experiencia;
    private String nome;
    private Status status; 

    public Elfo(String nome,Integer flechas)
    {
        this.nome = nome;
        if (flechas != null){
            this.flechas = flechas;
        }
        this.flechas = flechas;
        this.status = Status.VIVO;
    }

    public Elfo(String nome){
        this(nome,42);
    }

    public void atirarFlecha(Dwarf dwarf){
        this.experiencia++;
        dwarf.danoRecebido();
        this.flechas--;
    }
    
    public void atacarOrc(Orc orc){
        orc.recebeAtaqueElfo();
        this.flechas--;
    }

    public void atirarFlecha(IrishDwarf dwarf){
        this.experiencia++;
        dwarf.danoRecebido();
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

    public String getNome(){
        return this.nome;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public Status getStatus(){
        return this.status;
    }
}