package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class Menu {

    private static final int SELECIONAR_CLIENTE = 1;

    public void menu(int opcaoMenu) throws SQLException {
        Cliente cliente = new Cliente();
        MenuInserirPedido menuInserirPedido = new MenuInserirPedido();
        MenuUtilizarClienteECadastrar menuUtilizarClienteECadastrar = new MenuUtilizarClienteECadastrar();
        Pedido pedido = new Pedido();
        ClienteDao clienteDao = new ClienteDao();
        PedidoDao pedidoDao = new PedidoDao();
        Scanner scanner = new Scanner(System.in);

        if (opcaoMenu == 1) {
            // Cliente cliente = new Cliente();
            // ClienteDao clienteDao = new ClienteDao();
            // System.out.println("Nome: ");
            // cliente.setNmCliente(scanner.nextLine());
            // System.out.println("CPF(Não obrigatorio): ");
            // cliente.setNrCpf(scanner.nextLine());
            // inserir cliente
        } else if (opcaoMenu == 2) {
            // Cliente cliente = new Cliente();
            // ClienteDao clienteDao = new ClienteDao();
            // System.out.println("Id do cliente: ");
            // clienteDao.delete(scanner.nextLong());
            // deletaCliente
        } else if (opcaoMenu == 3) {
            // pesquisar cliente
        } else if (opcaoMenu == 4) {
            // listar todos clientes
        } else if (opcaoMenu == 5) {
            System.out.println("Nome: ");
            cliente.setNmCliente(scanner.nextLine());
            System.out.println("CPF: ");
            cliente.setNrCpf(scanner.nextLine());

            List<Cliente> clientes = new ArrayList<Cliente>();

            clientes = clienteDao.find(cliente);

            if (clientes.size() > 1){

                int opcaoCliente = 0;
                for (Cliente clientesLista : clientes){
                    System.out.println("Mais de um registro foi encontrado!");
                    System.out.println("Código: " + clientesLista.getIdCliente());
                    System.out.println("Nome: " + clientesLista.getNmCliente());
                    System.out.println("CPF: " + clientesLista.getNrCpf());
                }
                System.out.println("1-Selecionar cliente pelo código\n2-Cadastrar novo cliente");
                opcaoCliente = scanner.nextInt();
                menuUtilizarClienteECadastrar.menuUtilizarCliente(opcaoCliente, cliente);

            } else if (clientes.size() == 1){

                int opcaoCliente = 0;
                for (Cliente clientesLista : clientes){
                    System.out.println("Mais de um registro foi encontrado!");
                    System.out.println("Código: " + clientesLista.getIdCliente());
                    System.out.println("Nome: " + clientesLista.getNmCliente());
                    System.out.println("CPF: " + clientesLista.getNrCpf());
                }
                System.out.println("1-Inserir pedido para este cliente\n2-Cadastrar novo cliente");
                opcaoCliente = scanner.nextInt();
                menuInserirPedido.menuInserirSelecionandoCliente(clientes, opcaoCliente, cliente);

            } else {
                clienteDao.insert(cliente);
                menuInserirPedido.menuInserir(cliente);
            }
        }

    }

}
