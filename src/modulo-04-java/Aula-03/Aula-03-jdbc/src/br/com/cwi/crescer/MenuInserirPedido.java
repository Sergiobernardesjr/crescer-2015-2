package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class MenuInserirPedido {

    private static final int INSERIR_PEDIDO = 1;
    Scanner scanner = new Scanner(System.in);

    Pedido pedido = new Pedido();
    PedidoDao pedidoDao = new PedidoDao();
    ClienteDao clienteDao = new ClienteDao();
    String dsPedido;

    public void menuInserirSelecionandoCliente(List<Cliente> clientes, int opcaoCliente, Cliente cliente) throws SQLException {
        if (opcaoCliente == INSERIR_PEDIDO){
            System.out.println("Descricao pedido: ");
            dsPedido = scanner.nextLine();
            pedido.setDsPedido(dsPedido);
            pedido.setIdCliente(clientes.get(0).getIdCliente());
            pedidoDao.insert(pedido);
        } else {
            menuInserir(cliente);
        }
    }

    public void menuInserir(Cliente cliente) throws SQLException {
        System.out.println("Descricao pedido: ");
        pedido.setDsPedido(scanner.nextLine());
        pedido.setIdCliente(cliente.getIdCliente());
        pedidoDao.insert(pedido);
    }
}

