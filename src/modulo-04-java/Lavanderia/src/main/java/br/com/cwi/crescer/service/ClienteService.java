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
    public ClienteService(ClienteDAO clienteDao){
        this.clienteDao = clienteDao;
    }

    public List<ClienteDTO> listarClientesAtivos() {

        List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);

        List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(ClienteMapper.toDTO(cliente));
        }

        return dtos;
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteDao.findById(id);
    }

    public void atualizar(ClienteDTO dto) {

        Cliente cliente = clienteDao.findById(dto.getId());

        ClienteMapper.merge(dto, cliente);

        cliente.setCidade(cidadeDao.findById(dto.getIdCidade()));

        clienteDao.save(cliente);

    }
}
