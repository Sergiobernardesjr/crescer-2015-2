package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Pedido;

public class PedidoDAOTest extends AbstractEstructureTest {

    @Autowired
    private PedidoDAO pedidoDao;

    @Test
    public void buscarPorId() throws Exception {
        Pedido pedido = pedidoDao.findById(1L);

        Assert.assertNotNull(pedido);
    }

    @Test
    public void buscarPorIdComCliente() throws Exception {
        Pedido pedido = pedidoDao.findById(1L);
        Assert.assertNotNull(pedido);
        Assert.assertNotNull(pedido.getCliente());
        Assert.assertNotNull(pedido.getCliente().getNome());
    }

    @Test
    public void testFindBySituacao() throws Exception {
        // throw new RuntimeException("not yet implemented");
    }

}
