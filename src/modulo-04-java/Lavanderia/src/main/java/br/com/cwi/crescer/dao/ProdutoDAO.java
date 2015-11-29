package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

@Repository
public class ProdutoDAO extends AbstractDAO {

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> findAllProdutos() {
        return em.createQuery("FROM Produto", Produto.class)
                .getResultList();

    }

    @Transactional
    public Produto save(Produto produto) {

        if (produto.getIdProduto() == null) {
            produto.setSituacao(SituacaoProduto.ATIVO);
            em.persist(produto);
            return produto;
        }

        return em.merge(produto);
    }

    public void desativar(Produto produto) {
        produto.setSituacao(SituacaoProduto.INATIVO);
        em.merge(produto);
    }
}