package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;

public class ItemDAOTest extends AbstractEstructureTest {

    @Autowired
    private ItemDAO itemDao;

    @Test
    public void buscarPorId() throws Exception {
        Item item = itemDao.findById(1L);
        Assert.assertNotNull(item);
    }

    @Test
    public void buscarPorIdEVerificarSeTemPedido() throws Exception {
        Item item = itemDao.findById(1L);
        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getPedido());
    }

    @Test
    public void buscarPorIdEVerificarSeTemProduto() throws Exception {
        Item item = itemDao.findById(1L);
        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getProduto());
    }

    @Test
    public void buscarPorSituacao() throws Exception {
        List<Item> listaItens = itemDao.findBySituacao(SituacaoItem.PENDENTE);

        Assert.assertNotNull(listaItens);

        for (Item item : listaItens) {
            Assert.assertEquals(SituacaoItem.PENDENTE, item.getSituacao());
        }
    }
}
