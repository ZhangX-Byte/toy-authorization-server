package com.insight.into.life.auth.center.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Zhang_Xiang
 * @since 2022/5/11 17:42:25
 */
@Component
public record InitialClient(RegisteredClientRepository registeredClientRepository,
                            RegisterClientConfig clientConfig) implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        clientConfig.registers().forEach(cfg -> {
            RegisteredClient registeredClientFromDb = registeredClientRepository.findByClientId(cfg.clientId());
            if (registeredClientFromDb != null) {
                return;
            }

            RegisteredClient.Builder registerBuilder = RegisteredClient.withId(UUID.randomUUID().toString())
                    .clientId(cfg.clientId())
                    .clientSecret(cfg.clientSecret())
                    .clientAuthenticationMethod(new ClientAuthenticationMethod(cfg.authenticationMethod()));
            cfg.grantTypes().forEach(grantType -> {
                registerBuilder.authorizationGrantType(new AuthorizationGrantType(grantType));
            });
            cfg.redirectUris().forEach(registerBuilder::redirectUri);

            cfg.scopes().forEach(registerBuilder::scope);

            registeredClientRepository.save(registerBuilder.build());
        });

    }
}
