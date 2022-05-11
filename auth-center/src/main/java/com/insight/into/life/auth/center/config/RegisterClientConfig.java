package com.insight.into.life.auth.center.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

/**
 * @author Zhang_Xiang
 * @since 2022/5/11 17:35:04
 */
@ConfigurationProperties(prefix = "client")
@ConstructorBinding
public record RegisterClientConfig(List<Register> registers) {
    
    public record Register(String clientId, String clientSecret, String authenticationMethod, List<String> grantTypes,
                           List<String> scopes, List<String> redirectUris) {
    }
}


