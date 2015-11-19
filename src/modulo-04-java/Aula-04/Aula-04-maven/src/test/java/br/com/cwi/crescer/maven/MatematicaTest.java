package br.com.cwi.crescer.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaTest {

    @Test
    public void somarDoisNumeroPositivos() {
        int resultado = new Matematica().somar(2, 2);

        assertEquals(4, resultado);
    }

}
