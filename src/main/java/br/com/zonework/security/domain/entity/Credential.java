package br.com.zonework.security.domain.entity;

import br.com.zonework.members.domain.entity.Members;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "credentials")
public class Credential implements Serializable {

    @Id
    @Column private String username;
    @Column private String password;
    @Column private Boolean isLocked;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Members member;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "credentials_roles",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "name")
    )
    private Set<Role> roles;

    public Credential() { }

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

    public Boolean isLocked() {
        return isLocked == null ? Boolean.FALSE : isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members members) {
        this.member = members;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
