
/**
 * Write a description of class DataTerceiraEra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataTerceiraEra
{
   private int dia;
   private int mes;
   private int ano;
   
   public DataTerceiraEra(int dia,int mes,int ano){
       this.dia = dia;
       this.mes = mes;
       this.ano = ano;
   }
   
   public boolean ehBissesto(){
       if (this.ano/4 % 2 == 0){
           return true;
       }
       return false;
   }
   
   public int getDia(){
       return this.dia;
   }

   public int getMes(){
       return this.mes;
   }   

   public int getAno(){
       return this.ano;
   }   
}

