package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "password", length = 32)
    @Basic(optional = false)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "enabled", length = 1)
    @Basic(optional = false)
    private SituacaoUsuario enabled;

    public static enum SituacaoUsuario {
        ATIVO, INATIVO
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public SituacaoUsuario getEnabled() {
        return enabled;
    }

    public void setEnabled(SituacaoUsuario enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}