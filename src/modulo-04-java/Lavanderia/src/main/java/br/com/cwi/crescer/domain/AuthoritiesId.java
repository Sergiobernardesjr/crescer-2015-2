package br.com.cwi.crescer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class AuthoritiesId implements Serializable {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "username")
    public String username;

    @Column(name = "authority")
    public String authority;

    public AuthoritiesId() {
    }

    public AuthoritiesId(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object obj) {
        AuthoritiesId pk = (AuthoritiesId) obj;

        return pk.username == this.username &&
                pk.authority == this.authority;
    }

    @Override
    public int hashCode() {
        return (int) (serialVersionUID + (username.hashCode() + authority.hashCode()));
    }
}