package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDAO extends AbstractDAO {

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> findAllClientes() {
        return em.createQuery("FROM Cliente", Cliente.class)
                .getResultList();
    }

    @Transactional
    public Cliente save(Cliente cliente) {

        if (cliente.getIdCliente() == null) {
            cliente.setSituacao(SituacaoCliente.ATIVO);
            em.persist(cliente);
            return cliente;
        }

        return em.merge(cliente);
    }

    @Transactional
    public Cliente desativar(Cliente cliente) {
        cliente.setSituacao(SituacaoCliente.INATIVO);
        return em.merge(cliente);
    }

    public List<Cliente> findByNome(String nomeCliente) {
        return em.createQuery("FROM Cliente WHERE nome LIKE :nomeCliente", Cliente.class)
                .setParameter("nomeCliente", nomeCliente + "%")
                .getResultList();
    }
}