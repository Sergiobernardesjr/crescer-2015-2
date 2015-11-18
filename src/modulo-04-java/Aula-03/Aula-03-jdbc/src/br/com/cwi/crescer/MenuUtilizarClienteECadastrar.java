package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class MenuUtilizarClienteECadastrar {

    private static final int SELECIONAR_CLIENTE = 1;
    private Scanner scanner;
    ClienteDao clienteDao = new ClienteDao();
    MenuInserirPedido menuInserirPedido = new MenuInserirPedido();

    public void menuUtilizarCliente(int opcaoCliente, Cliente cliente) throws SQLException {
        if (opcaoCliente == SELECIONAR_CLIENTE) {
            System.out.println("Código do cliente: ");
            Long codigoClienteSelecionado = scanner.nextLong();
            Cliente clienteSelecionado = new Cliente();
            clienteSelecionado = clienteDao.Load(codigoClienteSelecionado);
            menuInserirPedido.menuInserir(clienteSelecionado);
        } else {
            clienteDao.insert(cliente);
            menuInserirPedido.menuInserir(cliente);
        }
    }
}
