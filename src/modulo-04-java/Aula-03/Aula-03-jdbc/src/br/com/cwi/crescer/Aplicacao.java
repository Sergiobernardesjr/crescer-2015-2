package br.com.cwi.crescer;

import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacao {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();

        int opcaoMenu = 0;
        System.out.println("1-Inserir cliente\n2-Deletar cliente\n3-Pesquisar cliente\n4-Listar todos clientes\n5-Inserir pedido");
        opcaoMenu = scanner.nextInt();
        menu.menu(opcaoMenu);

    }
}