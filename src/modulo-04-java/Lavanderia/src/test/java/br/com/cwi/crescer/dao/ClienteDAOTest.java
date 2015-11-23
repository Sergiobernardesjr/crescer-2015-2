package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;


public class ClienteDAOTest extends AbstractEstructureTest {

    @Autowired
    private ClienteDAO clienteDao;

    @Test
    public void buscarPorId() throws Exception {
        Cliente cliente = clienteDao.findById(1L);
        Assert.assertNotNull(cliente.getCidade());
        Assert.assertNotNull(cliente);
    }

    @Test
    public void buscarPorIdEVerificarListaDePedidos() throws Exception {
        Cliente cliente = clienteDao.findById(1L);
        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getPedidos());
    }

    @Test
    public void buscarPorSituacao() throws Exception {
        List<Cliente> cliente = clienteDao.findBySituacao(SituacaoCliente.ATIVO);

        Assert.assertFalse(cliente.isEmpty());

        for (Cliente clientes : cliente) {
            Assert.assertEquals(SituacaoCliente.ATIVO, clientes.getSituacao());
        }
    }

}
