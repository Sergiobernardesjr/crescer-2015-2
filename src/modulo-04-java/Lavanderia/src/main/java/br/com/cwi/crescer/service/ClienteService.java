package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {

    public ClienteDAO clienteDao;
    public CidadeDAO cidadeDao;

    @Autowired
    public ClienteService(ClienteDAO clienteDao, CidadeDAO cidadeDao) {
        this.clienteDao = clienteDao;
        this.cidadeDao = cidadeDao;
    }

    public List<ClienteDTO> listarClientesAtivos() {

        List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);

        List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(ClienteMapper.toDTO(cliente));
        }

        return dtos;
    }

    public ClienteDTO buscarClientePorId(Long id) {
        return ClienteMapper.toDTO(clienteDao.findById(id));
    }

    public void atualizar(ClienteDTO dto) {

        Cliente cliente = clienteDao.findById(dto.getId());

        ClienteMapper.merge(dto, cliente);

        clienteDao.save(cliente);

    }

    public void incluir(ClienteDTO dto) {

        Cliente cliente = ClienteMapper.newCliente(dto);

        cliente.setCidade(cidadeDao.findById(dto.getIdCidade()));

        clienteDao.save(cliente);
    }

    public void desativar(ClienteDTO dto) {
        Cliente cliente = new Cliente();

        ClienteMapper.merge(dto, cliente);

        clienteDao.desativar(cliente);
    }
}
