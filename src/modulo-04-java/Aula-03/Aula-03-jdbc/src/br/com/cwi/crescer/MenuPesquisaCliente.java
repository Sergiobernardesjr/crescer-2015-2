package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class MenuPesquisaCliente {

    private static final int PESQUISAR_POR_NOME = 1;
    private static final int PESQUISAR_POR_CPF = 2;
    private static final int PESQUISAR_POR_AMBOS = 1;
    ClienteDao clienteDao = new ClienteDao();
    private Scanner scanner = new Scanner(System.in);

    public List<Cliente> pesquisarCliente(int opcao) throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();

        if (opcao == PESQUISAR_POR_NOME) {
            String nome;
            System.out.println("Nome: ");
            nome = scanner.nextLine();
            cliente.setNmCliente(nome);
            lista = clienteDao.find(cliente);
        } else if (opcao == PESQUISAR_POR_CPF) {
            String cpf;
            System.out.println("CPF: ");
            cpf = scanner.nextLine();
            cliente.setNrCpf(cpf);
            lista = clienteDao.find(cliente);
        } else if (opcao == PESQUISAR_POR_AMBOS) {
            String cpf;
            String nome;
            System.out.println("Nome: ");
            nome = scanner.nextLine();
            System.out.println("CPF: ");
            cpf = scanner.nextLine();
            cliente.setNmCliente(nome);
            cliente.setNrCpf(cpf);
            lista = clienteDao.find(cliente);
        }
        return lista;
    }
}
