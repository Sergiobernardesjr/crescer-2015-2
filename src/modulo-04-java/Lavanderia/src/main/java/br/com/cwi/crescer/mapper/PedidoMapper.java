package br.com.cwi.crescer.mapper;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoDTO;

public class PedidoMapper {

    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setDataEntrega(pedido.getDataEntrega());
        dto.setDataInclusao(pedido.getDataInclusao());
        dto.setIdCliente(pedido.getCliente().getIdCliente());
        dto.setNomeCliente(pedido.getCliente().getNome());
        dto.setIdPedido(pedido.getIdPedido());
        dto.setValorBruto(pedido.getValorBruto());
        dto.setValorDesconto(pedido.getValorDesconto());
        dto.setValorFinal(pedido.getValorFinal());
        dto.setIdPedido(pedido.getIdPedido());
        return dto;
    }

    public static Pedido newPedido(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setDataEntrega(dto.getDataEntrega());
        pedido.setDataInclusao(dto.getDataInclusao());
        pedido.setIdPedido(dto.getIdPedido());
        pedido.setValorBruto(dto.getValorBruto());
        pedido.setValorDesconto(dto.getValorDesconto());
        pedido.setValorFinal(dto.getValorFinal());
        pedido.setValorBruto(new BigDecimal(0));
        return pedido;
    }

}
