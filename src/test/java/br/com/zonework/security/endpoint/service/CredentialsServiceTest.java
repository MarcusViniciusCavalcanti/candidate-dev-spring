package br.com.zonework.security.endpoint.service;

import br.com.zonework.security.domain.entity.Credential;
import br.com.zonework.security.domain.entity.Role;
import br.com.zonework.security.domain.repository.CredentialsRepository;
import br.com.zonework.security.domain.repository.RoleRepository;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.security.auth.login.LoginException;

import java.util.List;

import static org.junit.Assert.*;

public class CredentialsServiceTest {
    private static CredentialsService credentialsService;


    @BeforeClass
    public static void setuUp() {
        credentialsService = new CredentialsService();
    }


    @Test
    public void should_have_get_credentials_with_username() {
        try {
            Credential credential = credentialsService.getCredentialWith("vinicius");

            CredentialsRepository repository = new CredentialsRepository();
            RoleRepository roleRepository = new RoleRepository();

            List<Role> byCredentials = roleRepository.findByCredentials(credential);

            List<Credential> all = repository.findAll();

            all.size();
            assertThat(credential, CoreMatchers.is(credential));
        } catch (LoginException e) {
            e.printStackTrace();
        }


    }

}