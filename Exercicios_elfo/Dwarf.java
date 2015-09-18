
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
        this.dataNascimento = new DataTerceiraEra(17,9,2015);
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void danoRecebido(){
        this.vida -= 10;
        statusDwarf();
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
}
