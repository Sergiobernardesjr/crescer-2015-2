package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.dto.UserDTO;

public class UsuarioMapper {

    public static UserDTO toDTO(Users usuario) {
        UserDTO dto = new UserDTO();
        dto.setUsername(usuario.getUsername());
        dto.setPassword(usuario.getPassword());
        dto.setSituacao(usuario.getEnabled());

        return dto;
    }

    public static Users merge(UserDTO dto, Users usuario) {
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());

        return usuario;
    }

    public static Users newUsuario(UserDTO dto) {
        Users usuario = new Users();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());

        return usuario;
    }

}
