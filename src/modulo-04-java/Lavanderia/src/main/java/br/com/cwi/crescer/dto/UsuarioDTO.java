package br.com.cwi.crescer.dto;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.domain.Users.SituacaoUsuario;

public class UsuarioDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private SituacaoUsuario situacao;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SituacaoUsuario getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoUsuario situacao) {
        this.situacao = situacao;
    }

}
