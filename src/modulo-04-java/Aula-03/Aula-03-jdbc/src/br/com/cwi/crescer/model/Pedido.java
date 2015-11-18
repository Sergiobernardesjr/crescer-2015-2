package br.com.cwi.crescer.model;


public class Pedido {

    private Long idCliente;

    private Long idPedido;

    private String dsPedido;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDsPedido() {
        return dsPedido;
    }

    public void setDsPedido(String dsPedido) {
        this.dsPedido = dsPedido;
    }
}
