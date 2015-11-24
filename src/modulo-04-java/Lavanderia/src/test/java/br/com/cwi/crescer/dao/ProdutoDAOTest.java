package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Produto;


public class ProdutoDAOTest extends AbstractEstructureTest {

    @Autowired
    private ProdutoDAO produtoDao;

    @Test
    public void buscarPorId() throws Exception {
        Produto produto = produtoDao.findById(1L);

        Assert.assertNotNull(produto);
    }

    @Test
    public void buscarPorIdVeriicarSeTemItens() throws Exception {
        Produto produto = produtoDao.findById(1L);

        Assert.assertNotNull(produto.getItens());
        Assert.assertNotNull(produto);
    }

}
