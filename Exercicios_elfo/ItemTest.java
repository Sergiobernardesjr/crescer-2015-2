

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
   @Test
   public void itemRecebeDesricaoEQuantidade(){
       Item arco = new Item("Arco",1);
       
       assertEquals("Arco", arco.getDescricao());
       assertEquals(1, arco.getQuantidade());
   }
   
   @Test
   public void aumentar1000MaisQuantidadesAtuaisCom3Quantidade(){
       Item arco = new Item("Arco",3);
       int quantidadeEsperada = 6003;
       arco.aumentar1000UnidadesMaisSomaDasQuantidadesAtuais();
       
       assertEquals(quantidadeEsperada, arco.getQuantidade());
   }
   
   @Test
   public void aumentar1000MaisQuantidadesAtuaisCom10Quantidade(){
       Item arco = new Item("Arco",10);
       int quantidadeEsperada = 55010;
       arco.aumentar1000UnidadesMaisSomaDasQuantidadesAtuais();
       
       assertEquals(quantidadeEsperada, arco.getQuantidade());
   }
}
