package br.com.zonework.members.domain.entity;

import br.com.zonework.security.domain.entity.Credential;
import br.com.zonework.structure.JPA.EntityApplication;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Members extends EntityApplication {

    @Column private String name;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Credential credential;

    public Members() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
