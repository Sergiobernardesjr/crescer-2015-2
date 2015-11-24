package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Servico;


public class ServicoDAOTest extends AbstractEstructureTest {

    @Autowired
    private ServicoDAO servicoDao;

    @Test
    public void buscarPorId() throws Exception {
        Servico servico = servicoDao.findById(1L);

        Assert.assertNotNull(servico);
    }

    @Test
    public void buscarPorIdComProdutos() throws Exception {
        Servico servico = servicoDao.findById(1L);

        Assert.assertNotNull(servico.getProdutos());
        Assert.assertNotNull(servico);
    }
}
