import java.util.ArrayList;

public class Dwarf extends Personagem {
    protected int dia;
    protected int mes;
    protected int ano;
    protected DataTerceiraEra dataNascimento;

    public Dwarf(String nome){
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        vida = 110;
        status = Status.VIVO;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        vida = 110;
        status = Status.VIVO;        
    }

    public void danoRecebido(){
        if (getStatus() == Status.MORTO){
            return;
        }
        else{
            if (getNumeroSorte() < 0){
                this.experiencia += 2;
            }
            if (getNumeroSorte() > 100){
                this.vida -= 10;
                statusDwarf();
            }            
        }
    }

    public void statusDwarf(){
        if (this.vida == 0){
            status = Status.MORTO;
        }
        else if (this.vida <= 0){
            status = Status.MORTO;
        }
    }

    public Status getStatus(){
        return this.status;
    }

    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }

    public double getNumeroSorte(){
        double numeroSorte = 101.0;
        boolean vidaSorte = this.vida >= 80 && this.vida <= 90;
        boolean nomeSorte = this.nome != null && this.nome.equals("Seixas") || this.nome.equals("Meireles");

        if (dataNascimento.ehBissesto() && vidaSorte){
            numeroSorte *= -33.0;
        }

        if (dataNascimento.ehBissesto() == false && nomeSorte){
            numeroSorte = numeroSorte * 33 % 100;
        }

        return numeroSorte;
    }
       
    public void tentarSorte(){
        double numero = getNumeroSorte();
        
        if (numero == -3333.0)
        {
            getInventario().aumentar1000UnidadeEmCadaItem();
        }
    }
    
    public void atacarOrc(Orc orc){
        orc.recebeAtaqueDwarf();
    }
}