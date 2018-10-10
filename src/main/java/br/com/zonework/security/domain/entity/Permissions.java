package br.com.zonework.security.domain.entity;

import br.com.zonework.structure.JPA.EntityApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permissions extends EntityApplication {
    @Column private String name;

    public Permissions() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
