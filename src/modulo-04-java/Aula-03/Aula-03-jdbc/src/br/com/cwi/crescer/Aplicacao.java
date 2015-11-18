package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.List;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {
        /*
         * try {
         * Connection connection = new ConnectionFactory().getConnection();
         * } catch (SQLException e) {
         * e.printStackTrace();
         * System.out.println("Erro sql!!!");
         * }
         */

        ClienteDao clienteDao = new ClienteDao();
        // List<Cliente> lista = clienteDao.listAll();
        // for (Cliente cliente : lista) {
        // System.out.println(cliente.getNmCliente());
        // }



        // Insert
        Cliente cliente = new Cliente();
        // cliente.setIdCliente(1L);
        cliente.setNmCliente("Joao");
        List<Cliente> listaSelect = clienteDao.select(cliente);
        for (Cliente clienteSelect : listaSelect) {
            System.out.println(clienteSelect.getNmCliente());
            System.out.println(clienteSelect.getNrCpf());
            System.out.println(clienteSelect.getIdCliente());
        }

        //        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Utilizar\n1-Lista simples\n2-Lista dupla:"));
        //        if (opcao == 1){
        //            LinkedList linkedList = new LinkedList();
        //            int opcaoNaLista = Integer.parseInt(JOptionPane.showInputDialog("1-Inserir\n2-Remover:"));
        //            if(opcaoNaLista == 1){
        //                int opcaoNode = Integer.parseInt(JOptionPane.showInputDialog("1-Inserir na primeira posição\n2-Inserir na posição desejada\n3-Inserir na última posição:"));
        //                if (opcaoNode == 1){
        //                    String value = JOptionPane.showInputDialog("Valor:");
        //                    linkedList.addFirst(value);
        //                } else if (opcaoNode == 2){
        //                    String value = JOptionPane.showInputDialog("Valor:");
        //                    int index = Integer.parseInt(JOptionPane.showInputDialog("Posição:"));
        //                    linkedList.addMiddle(index, value);
        //                } else if (opcaoNode == 3) {
        //                    String value = JOptionPane.showInputDialog("Valor:");
        //                    linkedList.addLast(value);
        //                }
        //            } else if (opcaoNaLista == 2) {
        //                int opcaoNode = Integer.parseInt(JOptionPane.showInputDialog("1-Remover o primeiro node\n2-Remover o ultimo node:"));
        //                if (opcaoNode == 1) {
        //                    linkedList.removeFirst();
        //                } else if (opcaoNode == 2) {
        //                    linkedList.removeFirst();
        //                }
        //            }
        //
        //            JOptionPane.showMessageDialog(null, linkedList.list());
        //        }
        //
        //    }
    }
}