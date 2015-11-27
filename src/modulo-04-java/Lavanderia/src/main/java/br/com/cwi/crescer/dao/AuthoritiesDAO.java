package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.domain.AuthoritiesId;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.SituacaoUsuario;

@Repository
public class AuthoritiesDAO extends AbstractDAO {

    public AuthoritiesId findByRole(String role) {
        return em.createQuery("FROM AuthoritiesId u WHERE u.authority = :role", AuthoritiesId.class)
                .setParameter("role", role)
                .getSingleResult();
    }

    public List<Users> findBySituacao(SituacaoUsuario situacao) {
        return em.createQuery("FROM Users u WHERE u.enabled = :enabled", Users.class)
                .setParameter("enabled", situacao)
                .getResultList();
    }

    @Transactional
    public Users save(Users usuario) {

        if (usuario.getUsername() == null) {
            usuario.setEnabled(SituacaoUsuario.ATIVO);
            em.persist(usuario);
            return usuario;
        }

        return em.merge(usuario);
    }

    @Transactional
    public Users desativar(Users usuario) {
        usuario.setEnabled(SituacaoUsuario.INATIVO);
        return em.merge(usuario);
    }
}