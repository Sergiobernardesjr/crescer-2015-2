package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.ClienteDTO;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDto = new ClienteDTO();
        clienteDto.setBairro(cliente.getBairro());
        clienteDto.setCep(cliente.getCep());
        clienteDto.setCpf(cliente.getCpf());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setEndereco(cliente.getEndereco());
        clienteDto.setId(cliente.getIdCliente());
        clienteDto.setIdCidade(cliente.getCidade().getIdCidade());
        clienteDto.setNome(cliente.getNome());

        return clienteDto;
    }

    public static Cliente merge(ClienteDTO dto, Cliente cliente) {
        Cidade cidade = new Cidade();
        CidadeDAO cidadeDao = new CidadeDAO();
        cidade = cidadeDao.findById(dto.getIdCidade());

        cliente.setBairro(dto.getBairro());
        cliente.setCep(dto.getCep());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(dto.getEndereco());
        cliente.setIdCliente(dto.getId());
        cliente.setCidade(cidade);
        cliente.setNome(dto.getNome());

        return cliente;
    }

}
