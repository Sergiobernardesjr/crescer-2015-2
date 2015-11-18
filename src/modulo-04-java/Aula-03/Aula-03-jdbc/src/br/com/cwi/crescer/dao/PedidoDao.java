package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {

    public void insert(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = conexao.prepareStatement("insert into pedido (idCliente, idPedido, dsPedido) values (?,pedidos_seq.nextval,?)");
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Pedido Load(Long idPedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()){

            StringBuilder query = new StringBuilder();
            query.append(" select idcliente, idpedido, dspedido from pedido where idpedido = ? ");

            PreparedStatement statement = conexao.prepareStatement(query.toString());
            statement.setLong(1, idPedido);
            ResultSet resultSet = statement.executeQuery();

            Pedido pedido = new Pedido();

            if (resultSet.next()) {
                pedido.setIdCliente(resultSet.getLong(1));
                pedido.setIdPedido(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }

            return pedido;
        }
    }
}
