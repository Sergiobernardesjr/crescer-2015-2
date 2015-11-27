package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.dto.UsuarioDTO;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Users usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsername(usuario.getUsername());
        dto.setPassword(usuario.getPassword());
        dto.setSituacao(usuario.getEnabled());

        return dto;
    }

    public static Users merge(UsuarioDTO dto, Users usuario) {
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());

        return usuario;
    }

    public static Users newUsuario(UsuarioDTO dto) {
        Users usuario = new Users();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());

        return usuario;
    }

}
