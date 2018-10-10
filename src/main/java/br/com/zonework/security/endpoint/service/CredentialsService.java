package br.com.zonework.security.endpoint.service;

import br.com.zonework.security.domain.entity.Credential;
import br.com.zonework.security.domain.repository.CredentialsRepository;

import javax.security.auth.login.LoginException;
import java.util.Optional;

public class CredentialsService {

    public Credential getCredentialWith(String username) throws LoginException {
        CredentialsRepository credentialsRepository = new CredentialsRepository();
        Optional<Credential> credential = credentialsRepository.findByName(username);

        return credential.orElseThrow(LoginException::new);
    }
}
