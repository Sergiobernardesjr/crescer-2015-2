package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {

        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        cliente.setNmCliente("Maria");
        cliente.setIdCliente(1L);
        cliente.setNrCpf("123456");

        clienteDao.update(cliente);

        cliente.setNmCliente("Maria");
        List<Cliente> listaSelect = clienteDao.find(cliente);
        for (Cliente clienteSelect : listaSelect) {
            System.out.println(clienteSelect.getNmCliente());
            System.out.println(clienteSelect.getNrCpf());
            System.out.println(clienteSelect.getIdCliente());
        }
    }
}