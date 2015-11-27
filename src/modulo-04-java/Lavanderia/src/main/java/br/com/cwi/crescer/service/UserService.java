package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.UserDAO;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.SituacaoUsuario;
import br.com.cwi.crescer.dto.UserDTO;
import br.com.cwi.crescer.mapper.UsuarioMapper;

@Service
public class UserService {

    public UserDAO UsuarioDAO;
    public CidadeDAO cidadeDao;

    @Autowired
    public UserService(UserDAO UsuarioDAO) {
        this.UsuarioDAO = UsuarioDAO;
    }

    public List<UserDTO> listarUsersAtivos() {

        List<Users> usuarios = UsuarioDAO.findBySituacao(SituacaoUsuario.ATIVO);

        List<UserDTO> dtos = new ArrayList<UserDTO>();

        for (Users usuario : usuarios) {
            dtos.add(UsuarioMapper.toDTO(usuario));
        }

        return dtos;
    }

    public UserDTO buscarClientePorId(String username) {
        return UsuarioMapper.toDTO(UsuarioDAO.findByUsername(username));
    }

    public void atualizar(UserDTO dto) {

        Users usuario = UsuarioDAO.findByUsername(dto.getUsername());

        UsuarioMapper.merge(dto, usuario);

        UsuarioDAO.save(usuario);

    }

    public void incluir(UserDTO dto) {

        Users usuario = UsuarioMapper.newUsuario(dto);

        UsuarioDAO.save(usuario);
    }

    public void desativar(UserDTO dto) {
        Users usuario = new Users();

        UsuarioMapper.merge(dto, usuario);

        UsuarioDAO.desativar(usuario);
    }
}
