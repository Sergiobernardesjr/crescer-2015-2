package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {

    public void insert(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("insert into cliente (idCliente, nmCliente, nrCpf) values (?,?,?)");
            statement.setLong(1, cliente.getIdCliente());
            statement.setString(2, cliente.getNmCliente());
            statement.setString(3, cliente.getNrCpf());
            statement.execute();

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Cliente> listAll() throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append(" select idCliente, nmCliente, nrCpf from Cliente ");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            throw e;
        }

        return lista;
    }
}
