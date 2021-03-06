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

            PreparedStatement statement = conexao.prepareStatement("insert into cliente (idCliente, nmCliente, nrCpf) values (cliente_seq.nextval,?,?)");
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
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

    public void delete(Long idCliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append(" delete from cliente where idcliente = ? ");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Cliente Load(Long idCliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()){

            StringBuilder query = new StringBuilder();
            query.append(" select idcliente, nmcliente, nrcpf from cliente where idcliente = ? ");

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, idCliente);
            ResultSet resultSet = statement.executeQuery();

            Cliente cliente = new Cliente();

            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }

            return cliente;
        }
    }

    public List<Cliente> find(Cliente cliente) throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();

        try (Connection conexao = new ConnectionFactory().getConnection()) {
            int cont = 0;
            List<String> parametro = new ArrayList<String>();
            Long idParametro = 0L;

            StringBuilder query = new StringBuilder();
            query.append(" select idcliente, nmcliente, nrcpf from cliente where ");
            if (cliente.getIdCliente() != null) {
                query.append(" idCliente = ? ");
                idParametro = cliente.getIdCliente();
                cont++;
            }
            if (cliente.getNmCliente() != null) {
                if (cont == 1) {
                    query.append(" and ");
                }
                query.append(" nmCliente = ? ");
                parametro.add(cliente.getNmCliente());
                cont++;
            }
            if (cliente.getNrCpf() != null) {
                if (cont >= 1) {
                    query.append(" and ");
                }
                query.append(" nrCpf = ? ");
                parametro.add(cliente.getNrCpf());
                cont++;
            }

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            if (cont == 1){
                if (idParametro > 0){
                    statement.setLong(1, idParametro);
                } else {
                    statement.setString(1, parametro.get(0));
                }

            } else if (cont > 0 && cont <= 2) {
                if (idParametro > 0){
                    statement.setLong(1, idParametro);
                    statement.setString(2, parametro.get(0));
                } else {
                    statement.setString(1, parametro.get(0));
                    statement.setString(2, parametro.get(1));
                }
            } else {
                statement.setLong(1, idParametro);
                statement.setString(2, parametro.get(0));
                statement.setString(3, parametro.get(1));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente clienteRetorno = new Cliente();
                clienteRetorno.setIdCliente(resultSet.getLong(1));
                clienteRetorno.setNmCliente(resultSet.getString(2));
                clienteRetorno.setNrCpf(resultSet.getString(3));
                lista.add(clienteRetorno);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder query = new StringBuilder();
            query.append(" update cliente set nmcliente = ?, nrcpf = ? where idcliente = ? ");

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
}
