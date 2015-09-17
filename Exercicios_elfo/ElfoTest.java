

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void nomeNotNullComFlechas(){
        String nome = "joao";
        int flechas = 100;
        
        Elfo joao = new Elfo(nome, flechas);
        assertNotNull(joao.getNome());
        assertEquals("joao", joao.getNome());
        assertFalse(flechas != joao.getFlechas());
        assertEquals(flechas,joao.getFlechas());
        assertFalse(0 != joao.getExperiencia());
        assertEquals(0, joao.getExperiencia());
    }
    
    @Test
    public void nomeNullComFlechas(){
        String nome = null;
        int flechas = 9;
        
        Elfo joao = new Elfo(nome, flechas);
        assertNull(joao.getNome());
        assertEquals(nome, joao.getNome());
        assertFalse(flechas != joao.getFlechas());
        assertEquals(flechas,joao.getFlechas());
        assertFalse(0 != joao.getExperiencia());
        assertEquals(0, joao.getExperiencia());
    }
    
    @Test
    public void defaultNomeSemFlechas(){
        String nome = "Joni";
                
        Elfo joao = new Elfo(nome);
        assertNotNull(joao.getNome());
        assertEquals(nome, joao.getNome());
        assertFalse(42 != joao.getFlechas());
        assertEquals(42,joao.getFlechas());
        assertFalse(0 != joao.getExperiencia());
        assertEquals(0, joao.getExperiencia());
        
        Elfo nulinho = new Elfo(null);
        assertNull(nulinho.getNome());
        assertEquals(null, nulinho.getNome());
        assertFalse(42 != nulinho.getFlechas());
        assertEquals(42,nulinho.getFlechas());
        assertFalse(0 != nulinho.getExperiencia());
        assertEquals(0, nulinho.getExperiencia());
    }
    
    @Test
    public void acertarFalso(){
        Elfo legolas = new Elfo("Legolas");
        assertFalse(legolas.acertar());
    }
    
    @Test
    public void acertarVerdadeiro(){
        Elfo legolas = new Elfo("Legolas");
        assertTrue(legolas.acertar());
    }
    /*
    @Test
    public void atirarFlechaNoDwarf(){
        int flechas = 1000000;
        String nome = "Mirado";
        Elfo mirado = new Elfo(nome, flechas);        
        Elfo nulinho = new Elfo(null);         
        Dwarf gimli = new Dwarf(), balin = new Dwarf(); 
        
         assertTrue(mirado.acertar());
         assertEquals(flechas-1, mirado.getFlechas()); 
         assertFalse(flechas-1 != mirado.getFlechas()); 
         assertFalse(1 != mirado.getExperiencia());
         assertEquals(1, mirado.getExperiencia()); 
        
         assertTrue(mirado.acertar());
         assertEquals(41, nulinho.getFlechas()); 
         assertFalse(41 != nulinho.getFlechas()); 
         assertFalse(1 != nulinho.getExperiencia()); 
         assertEquals(1, nulinho.getExperiencia()); 
         
         assertTrue(mirado.acertar());
         assertTrue(nulinho.acertar());
         assertTrue(mirado.acertar());
         assertTrue(mirado.getFlechas() != 0); 
         assertEquals(flechas-3, mirado.getFlechas()); 
         assertFalse(flechas-3 != mirado.getFlechas()); 
         assertEquals(4, mirado.getExperiencia()); 
         assertFalse(4 != mirado.getExperiencia());        
    }*/
}