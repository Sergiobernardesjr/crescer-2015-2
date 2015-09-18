
public class Dwarf
{
    private String nome;
    private int vida = 110; 
    private int experiencia = 0;
    private int dia;
    private int mes;
    private int ano;
    private DataTerceiraEra dataNascimento;
    private Status status = Status.VIVO;

    public Dwarf(String nome){
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void danoRecebido(){
        if (getNumeroSorte() < 0){
            this.experiencia += 2;
        }
        else if (getNumeroSorte() >= 0 && getNumeroSorte() <= 100){
        }
        else
        {
            this.vida -= 10;
            statusDwarf();
        }

    }

    public int getVida(){
        return this.vida;
    }

    public void statusDwarf(){
        if (this.vida == 0){
            status = Status.MORTO;
        }
        else if ((this.vida > 0) && (this.vida < 110)){
            status = Status.FERIDO;
        }
    }

    public Status getStatus(){
        return this.status;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public String getNome(){
        return this.nome;
    }

    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }

    public double getNumeroSorte(){
        double numeroSorte = 101;
        boolean vidaSorte = this.vida >= 80 && this.vida <= 90;
        boolean nomeSorte = this.nome.equals("Seixas") || this.nome.equals("Meireles");
        if (dataNascimento.ehBissesto() && vidaSorte){
            numeroSorte *= -33;
        }
        else if (dataNascimento.ehBissesto() == false && nomeSorte){
            numeroSorte = numeroSorte%100;
        }

        return numeroSorte;
    }
}
