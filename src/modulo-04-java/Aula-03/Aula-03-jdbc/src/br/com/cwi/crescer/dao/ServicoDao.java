package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {

    public void insert(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("insert into cliente (idCliente, dbServico) values (?,?)");
            statement.setLong(1, servico.getIdServico());
            statement.setString(2, servico.getDsServico());
            statement.execute();

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Servico> listAll() throws SQLException {
        List<Servico> lista = new ArrayList<Servico>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append(" select idServico, dsServico from Servico ");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Servico servico = new Servico();
                servico.setIdServico(resultSet.getLong(1));
                servico.setDsServico(resultSet.getString(2));
                lista.add(servico);
            }
        } catch (SQLException e) {
            throw e;
        }

        return lista;
    }

}
