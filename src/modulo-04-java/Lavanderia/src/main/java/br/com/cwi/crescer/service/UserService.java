package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.UserDAO;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.SituacaoUsuario;
import br.com.cwi.crescer.dto.UsuarioDTO;
import br.com.cwi.crescer.mapper.UsuarioMapper;

@Service
public class UserService {

    public UserDAO UsuarioDAO;
    public CidadeDAO cidadeDao;

    @Autowired
    public UserService(UserDAO UsuarioDAO) {
        this.UsuarioDAO = UsuarioDAO;
    }

    public List<UsuarioDTO> listarClientesAtivos() {

        List<Users> usuarios = UsuarioDAO.findBySituacao(SituacaoUsuario.ATIVO);

        List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();

        for (Users usuario : usuarios) {
            dtos.add(UsuarioMapper.toDTO(usuario));
        }

        return dtos;
    }

    public UsuarioDTO buscarClientePorId(String username) {
        return UsuarioMapper.toDTO(UsuarioDAO.findByUsername(username));
    }

    public void atualizar(UsuarioDTO dto) {

        Users usuario = UsuarioDAO.findByUsername(dto.getUsername());

        UsuarioMapper.merge(dto, usuario);

        UsuarioDAO.save(usuario);

    }

    public void incluir(UsuarioDTO dto) {

        Users usuario = UsuarioMapper.newUsuario(dto);

        UsuarioDAO.save(usuario);
    }

    public void desativar(UsuarioDTO dto) {
        Users usuario = new Users();

        UsuarioMapper.merge(dto, usuario);

        UsuarioDAO.desativar(usuario);
    }
}
