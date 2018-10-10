package br.com.zonework.security.domain.repository;

import br.com.zonework.security.domain.entity.Credential;
import br.com.zonework.security.domain.entity.Role;
import br.com.zonework.structure.JPA.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class RoleRepository {
    private EntityManager entityManager;
    public RoleRepository() {
        this.entityManager = JPAUtils.entityManager();
    }

    public List<Role> findByCredentials(Credential credential) {

        TypedQuery<Role> list = entityManager.createQuery("SELECT Role FROM Credential c JOIN c.roles Role", Role.class);

        return Collections.unmodifiableList(list.getResultList());
    }
}
