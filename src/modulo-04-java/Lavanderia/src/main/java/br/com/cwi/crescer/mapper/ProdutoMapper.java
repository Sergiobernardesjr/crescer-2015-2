package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {

    public static ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();

        dto.setIdMaterial(produto.getMaterial().getIdMaterial());
        dto.setIdProduto(produto.getIdProduto());
        dto.setIdServico(produto.getServico().getIdServico());
        dto.setValor(produto.getValor());
        dto.setPrazo(produto.getPrazo());
        dto.setIdMaterial(produto.getIdProduto());
        dto.setMaterial(produto.getMaterial().getDescricao());
        dto.setServico(produto.getServico().getDescricao());
        dto.setSituacao(produto.getSituacao());

        return dto;
    }

    public static Produto merge(ProdutoDTO dto, Produto produto) {
        produto.setIdProduto(dto.getIdProduto());
        produto.setSituacao(dto.getSituacao());
        produto.setValor(dto.getValor());
        return null;
    }

    public static Produto newProduto(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setPrazo(dto.getPrazo());
        produto.setIdProduto(dto.getIdProduto());
        produto.setSituacao(dto.getSituacao());
        produto.setValor(dto.getValor());
        return produto;
    }

}
