package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Servico;

@Service
public class ServicoService {

    private ServicoDAO servicoDao;

    @Autowired
    public ServicoService(ServicoDAO servicoDao) {
        this.servicoDao = servicoDao;
    }

    public List<Servico> listar() {
        return servicoDao.listAll();
    }

}
