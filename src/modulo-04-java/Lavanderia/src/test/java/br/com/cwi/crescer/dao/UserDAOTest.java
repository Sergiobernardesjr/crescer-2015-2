package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractEstructureTest;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.SituacaoUsuario;

public class UserDAOTest extends AbstractEstructureTest {

    @Autowired
    private UserDAO usuarioDao;

    @Test
    public void buscarPorUsername() throws Exception {
        Users usuario = usuarioDao.findByUsername("admin");
        Assert.assertNotNull(usuario);
    }

    @Test
    public void buscarPorSituacao() throws Exception {
        List<Users> usuario = usuarioDao.findBySituacao(SituacaoUsuario.ATIVO);
        Assert.assertNotNull(usuario);
    }
}
