package br.com.zonework.candidates.domain.repository;

import br.com.zonework.members.domain.entity.Members;
import br.com.zonework.security.domain.entity.Credential;
import br.com.zonework.security.domain.entity.Role;
import br.com.zonework.security.domain.repository.CredentialsRepository;
import br.com.zonework.security.domain.repository.RoleRepository;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class MembersRepositoryTest {

    @Test
    public void should_have_save_members_success(){

        Members candidate = new Members();
        candidate.setName("lero");
//        MembersRepository candidateRepository = new MembersRepository();
//        candidateRepository.save(candidate);

        Credential credential = new Credential();
        credential.setMember(candidate);
        credential.setUsername("marcus@lero.com.br");
        credential.setPassword("65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5");
        credential.setLocked(false);

        RoleRepository roleRepository = new RoleRepository();
        Role role = roleRepository.findByName("candidate").get();
        HashSet<Role> roles = new HashSet<>();
        roles.add(role);

        credential.setRoles(roles);

        candidate.setCredential(credential);


        CredentialsRepository repository = new CredentialsRepository();
        repository.save(credential);
    }
}