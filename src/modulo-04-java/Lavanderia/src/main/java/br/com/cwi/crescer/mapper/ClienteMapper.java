package br.com.cwi.crescer.mapper;

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
        clienteDto.setSituacao(cliente.getSituacao());

        return clienteDto;
    }

    public static Cliente merge(ClienteDTO dto, Cliente cliente) {
        cliente.setBairro(dto.getBairro());
        cliente.setCep(dto.getCep());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(dto.getEndereco());
        cliente.setIdCliente(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setSituacao(dto.getSituacao());

        return cliente;
    }

    public static Cliente newCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setBairro(dto.getBairro());
        cliente.setCep(dto.getCep());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());

        return cliente;
    }

}
