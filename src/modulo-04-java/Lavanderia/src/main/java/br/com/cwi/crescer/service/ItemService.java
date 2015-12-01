package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.mapper.ItemMapper;

@Service
public class ItemService {

    private PedidoDAO pedidoDao;
    private ProdutoDAO produtoDao;
    private ItemDAO itemDao;

    @Autowired
    public ItemService(PedidoDAO pedidoDao, ProdutoDAO produtoDao, ItemDAO itemDao) {
        this.pedidoDao = pedidoDao;
        this.produtoDao = produtoDao;
        this.itemDao = itemDao;
    }
    public void incluir(ItemDTO dto) {

        Item item = ItemMapper.newItem(dto);

        item.setPedido(pedidoDao.findById(dto.getIdPedido()));
        Produto produto = produtoDao.buscaServicoEMaterial(dto.getIdServico(), dto.getIdMaterial()).get(0);
        item.setProduto(produto);
        item.setSituacao(SituacaoItem.PENDENTE);

        itemDao.savePersist(calcularTotais(item));
    }

    public List<SituacaoItem> listar() {
        List<SituacaoItem> situacao = new ArrayList<SituacaoItem>();
        situacao.add(SituacaoItem.PENDENTE);
        situacao.add(SituacaoItem.PROCESSANDO);
        situacao.add(SituacaoItem.PROCESSADO);

        return situacao;
    }

    public Item calcularTotais(Item item) {
        item.setValorUnitario(produtoDao.findById(item.getProduto().getIdProduto()).getValor());
        item.setValorTotal(item.getValorUnitario().multiply(item.getPeso()));

        return item;
    }

}
