package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.mapper.PedidoMapper;

@Service
public class PedidoService {

    private PedidoDAO pedidoDao;
    private ClienteDAO clienteDao;
    private ItemDAO itemDao;

    @Autowired
    public PedidoService(PedidoDAO pedidoDao, ClienteDAO clienteDao, ItemDAO itemDao) {
        this.pedidoDao = pedidoDao;
        this.clienteDao = clienteDao;
        this.itemDao = itemDao;
    }

    public List<PedidoDTO> listAll() {
        List<Pedido> pedidos = pedidoDao.findAllPedidos();

        List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();

        for (Pedido pedido : pedidos) {
            dtos.add(PedidoMapper.toDTO(pedido));
        }

        return dtos;
    }

    public List<SituacaoPedido> listarSituacao() {
        List<SituacaoPedido> lista = new ArrayList<SituacaoPedido>();
        lista.add(SituacaoPedido.PENDENTE);
        lista.add(SituacaoPedido.PROCESSANDO);
        lista.add(SituacaoPedido.PROCESSADO);
        lista.add(SituacaoPedido.ENCERRADO);
        lista.add(SituacaoPedido.CANCELADO);

        return lista;
    }

    public Pedido incluir(PedidoDTO dto) {
        Calendar dataAtual = Calendar.getInstance();

        Pedido pedido = PedidoMapper.newPedido(dto);

        pedido.setSituacao(SituacaoPedido.PENDENTE);
        pedido.setCliente(clienteDao.findById(dto.getIdCliente()));
        pedido.setDataInclusao(dataAtual.getTime());

        return pedidoDao.savePersist(pedido);
    }

    public PedidoDTO buscarPedidoPorId(Long id) {
        Pedido pedido = pedidoDao.findById(id);

        return PedidoMapper.toDTO(pedido);
    }

    public void finalizar(PedidoDTO dto) {
        List<Item> itensPedido = itemDao.buscarItensPorPedido(dto.getIdPedido());

        Pedido pedido = PedidoMapper.newPedido(dto);

        Cliente cliente = clienteDao.findById(dto.getIdCliente());
        pedido.setCliente(cliente);

        Integer maiorPrazo = 0;


        for (Item item : itensPedido) {
            if (item.getProduto().getPrazo() > maiorPrazo) {
                maiorPrazo = item.getProduto().getPrazo();
            }
        }

        pedido.setDataEntrega(calcularDataEntrega(dto.getDataInclusao(), maiorPrazo));
        pedido.setValorBruto(calcularValorTotal(itensPedido));
        pedido.setValorFinal(calcularValorTotal(itensPedido));
        pedido.setDataEntrega(calcularDataEntrega(dto.getDataInclusao(), maiorPrazo));

        pedido.setSituacao(SituacaoPedido.PROCESSANDO);
        pedidoDao.saveMerge(pedido);
    }

    // private BigDecimal calcularValorDesconto(List<Item> itensPedido) {
    // BigDecimal valorTotalPedido = calcularValorTotal(itensPedido);
    //
    // return null;
    // }

    public Date calcularDataEntrega(Date dataInclusao, Integer prazo) {
        Calendar dataAdicionadoPrazo = Calendar.getInstance();
        dataAdicionadoPrazo.setTime(dataInclusao);
        dataAdicionadoPrazo.add(Calendar.DAY_OF_MONTH, prazo);
        return dataInclusao;
    }

    public BigDecimal calcularValorTotal(List<Item> itensPedido) {
        BigDecimal valorTotalPedido = new BigDecimal(0);

        for (Item item : itensPedido) {
            valorTotalPedido = valorTotalPedido.add(item.getValorTotal());
        }

        return valorTotalPedido;
    }
}
