package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Material;


public class MaterialDAOTest extends AbstractEstructureTest {

    @Autowired
    private MaterialDAO materialDao;

    @Test
    public void buscarPorId() throws Exception {
        Material material = materialDao.findById(1L);

        Assert.assertNotNull(material);
    }

}
