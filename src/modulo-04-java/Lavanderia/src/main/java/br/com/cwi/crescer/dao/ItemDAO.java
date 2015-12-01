package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;

@Repository
public class ItemDAO extends AbstractDAO {

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findBySituacao(SituacaoItem situacao) {
        return em.createQuery("FROM Item c WHERE c.situacao = :situacao", Item.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    @Transactional
    public void savePersist(Item item) {
        em.persist(item);
    }

    public List<Item> buscarItensPorPedido(Long idPedido) {
        return em.createQuery("FROM Item c WHERE c.pedido.idPedido = :idPedido", Item.class)
                .setParameter("idPedido", idPedido)
                .getResultList();
    }
}