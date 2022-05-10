package com.insight.into.life.clientgateway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

/**
 * @author Zhang_Xiang
 * @since 2022/5/9 11:26:07
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final WebClient webClient;
    @Value("${user-service.base-uri}")
    private String userServiceBaseUri;

    @GetMapping("/menus")
    public String menus(@RegisteredOAuth2AuthorizedClient("client-gateway-authorization-code") OAuth2AuthorizedClient authorizedClient) {
        return this.webClient
                .get()
                .uri(userServiceBaseUri)
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
