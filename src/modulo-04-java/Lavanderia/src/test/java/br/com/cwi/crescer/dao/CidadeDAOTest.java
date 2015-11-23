package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Cidade;



public class CidadeDAOTest extends AbstractEstructureTest {

    @Autowired
    private CidadeDAO cidadeDao;

    @Test
    public void buscandoPorId() throws Exception {
        Cidade cidade = cidadeDao.findById(1L);
        Assert.assertNotNull(cidade);
    }

}
