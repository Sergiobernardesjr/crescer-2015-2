package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.domain.Material;

@Service
public class MaterialService {

    private MaterialDAO materialDao;

    @Autowired
    public MaterialService(MaterialDAO materialDao) {
        this.materialDao = materialDao;
    }

    public List<Material> listar() {
        return materialDao.listAll();
    }

}
