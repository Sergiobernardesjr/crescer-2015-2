package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class Menu {

    private static final int INSERIR_CLIENTE = 1;
    private static final int DELETAR_CLIENTE = 2;
    private static final int PESQUISAR_CLIENTE = 3;
    private static final int LISTAR_CLIENTES = 4;
    private int opcaoCliente = 0;
    private final Scanner scanner = new Scanner(System.in);;

    public void menu(int opcaoMenu) throws SQLException {
        Cliente cliente = new Cliente();
        MenuInserirPedido menuInserirPedido = new MenuInserirPedido();
        MenuUtilizarClienteECadastrar menuUtilizarClienteECadastrar = new MenuUtilizarClienteECadastrar();
        ClienteDao clienteDao = new ClienteDao();
        MenuPesquisaCliente menuPesquisaCliente = new MenuPesquisaCliente();

        if (opcaoMenu == INSERIR_CLIENTE) {
            String nome;
            String CPF;
            System.out.println("Nome: ");
            nome = scanner.nextLine();
            System.out.println("CPF: ");
            CPF = scanner.nextLine();
            cliente.setNmCliente(nome);
            cliente.setNrCpf(CPF);
            clienteDao.insert(cliente);
            System.out.println("Cliente inserido com sucesso!");
        } else if (opcaoMenu == DELETAR_CLIENTE) {
            Long idCliente;
            System.out.println("Id do cliente: ");
            idCliente = scanner.nextLong();
            cliente.setIdCliente(idCliente);
            scanner.reset();
            clienteDao.delete(idCliente);
            if (clienteDao.find(cliente).size() == 0) {
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Não foi possível excluir este cliente.");
            }
        } else if (opcaoMenu == PESQUISAR_CLIENTE) {
            List<Cliente> listaClientesPesquisados = new ArrayList<Cliente>();
            System.out.println("Pesquisar cliente.\n1-Nome\n2-CPF\n3-Ambos:");
            opcaoMenu = scanner.nextInt();
            scanner.reset();
            listaClientesPesquisados = menuPesquisaCliente.pesquisarCliente(opcaoMenu);
            for (Cliente clientes : listaClientesPesquisados) {
                System.out.println("Id:" + clientes.getIdCliente());
                System.out.println("Nome:" + clientes.getNmCliente());
                System.out.println("Cpf:" + clientes.getNrCpf());
            }
        } else if (opcaoMenu == LISTAR_CLIENTES) {
            List<Cliente> listaClientes = new ArrayList<Cliente>();
            listaClientes = clienteDao.listAll();
            for (Cliente clientes : listaClientes) {
                System.out.println("Id:" + clientes.getIdCliente());
                System.out.println("Nome:" + clientes.getNmCliente());
                System.out.println("Cpf:" + clientes.getNrCpf());
            }
        } else if (opcaoMenu == 5) {
            System.out.println("Nome: ");
            cliente.setNmCliente(scanner.nextLine());
            System.out.println("CPF: ");
            cliente.setNrCpf(scanner.nextLine());

            List<Cliente> clientes = new ArrayList<Cliente>();

            clientes = clienteDao.find(cliente);

            if (clientes.size() > 1){
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
