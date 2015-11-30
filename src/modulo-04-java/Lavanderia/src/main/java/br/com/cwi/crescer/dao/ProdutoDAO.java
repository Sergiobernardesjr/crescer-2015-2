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
    public void savePersist(Produto produto) {
        produto.setSituacao(SituacaoProduto.ATIVO);
        em.persist(produto);
    }

    @Transactional
    public void saveMerge(Produto produto) {
        em.merge(produto);
    }

    public void desativar(Produto produto) {
        em.merge(produto);
    }

    public List<Produto> buscaServicoEMaterial(Long idServico, Long idMaterial) {
        return em.createQuery("FROM Produto WHERE IDServico = :idservico and IDMaterial = :idmaterial", Produto.class)
                .setParameter("idservico", idServico).setParameter("idmaterial", idMaterial).getResultList();
    }
}