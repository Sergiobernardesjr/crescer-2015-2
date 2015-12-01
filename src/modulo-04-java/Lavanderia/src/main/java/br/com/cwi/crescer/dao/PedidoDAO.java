package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO extends AbstractDAO {

    public Pedido findById(Long id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> findBySituacao(SituacaoPedido situacao) {
        return em.createQuery("FROM Pedido c WHERE c.situacao = :situacao", Pedido.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    public List<Pedido> findAllPedidos() {
        return em.createQuery("FROM Pedido", Pedido.class)
                .getResultList();
    }

    @Transactional
    public Pedido savePersist(Pedido pedido) {
        em.persist(pedido);
        return pedido;
    }

    @Transactional
    public Pedido saveMerge(Pedido pedido) {
        return em.merge(pedido);
    }

}