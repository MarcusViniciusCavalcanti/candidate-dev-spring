package br.com.zonework.candidates.domain.repository;

import br.com.zonework.members.domain.entity.Members;
import br.com.zonework.structure.JPA.Repository;

public class MembersRepository extends Repository<Members> {
    public MembersRepository() {
        super(Members.class);
    }
}
