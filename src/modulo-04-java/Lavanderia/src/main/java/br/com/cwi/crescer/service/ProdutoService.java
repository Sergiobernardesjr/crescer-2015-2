package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.ProdutoMapper;

@Service
public class ProdutoService {

    public ProdutoDAO produtoDao;
    public MaterialDAO materialDao;
    public ServicoDAO servicoDao;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDao, MaterialDAO materialDao, ServicoDAO servicoDao) {
        this.produtoDao = produtoDao;
        this.servicoDao = servicoDao;
        this.materialDao = materialDao;
    }

    public ProdutoDTO findById(Long id){
        Produto produto = produtoDao.findById(id);
        ProdutoDTO dto = ProdutoMapper.toDTO(produto);
        return dto;
    }

    public List<ProdutoDTO> listarProdutos() {

        List<Produto> produtos = produtoDao.findAllProdutos();

        List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();

        for (Produto produto : produtos) {
            dtos.add(ProdutoMapper.toDTO(produto));
        }

        return dtos;
    }

    public ProdutoDTO buscarProdutoPorId(Long id) {
        return ProdutoMapper.toDTO(produtoDao.findById(id));
    }

    public void atualizar(ProdutoDTO dto) {

        Produto produto = produtoDao.findById(dto.getIdProduto());

        ProdutoMapper.merge(dto, produto);

        produto.setMaterial(materialDao.findById(dto.getIdMaterial()));
        produto.setServico(servicoDao.findById(dto.getIdServico()));

        produtoDao.save(produto);

    }

    public void incluir(ProdutoDTO dto) {

        Produto produto = ProdutoMapper.newProduto(dto);

        produto.setMaterial(materialDao.findById(dto.getIdMaterial()));
        produto.setServico(servicoDao.findById(dto.getIdServico()));

        produtoDao.save(produto);
    }

    public void desativar(ProdutoDTO dto) {
        Produto produto = new Produto();

        ProdutoMapper.merge(dto, produto);

        produtoDao.desativar(produto);
    }

    public List<SituacaoProduto> listarSituacao() {
        List<SituacaoProduto> lista = new ArrayList<SituacaoProduto>();
        lista.add(SituacaoProduto.ATIVO);
        lista.add(SituacaoProduto.INATIVO);
        return lista;
    }

}
