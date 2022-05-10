package com.insight.into.life.clientgateway.controller;

import com.insight.into.life.clientgateway.api.OAuthApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhang_Xiang
 * @since 2022/5/9 11:26:07
 */
@RestController
@RequestMapping("/oauth2")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final static String REDIRECT_URI = "http://localhost:9100/oauth2/authorized";
    private final OAuthApi oauthApi;
    @Value("${user-service.base-uri}")
    private String userServiceBaseUri;


    @GetMapping(value = "/callback")
    public String callback(String code) {
        if (!StringUtils.hasText(code)) {
            return "code is empty";
        }
//        oauthApi.getAccessToken("authorization_code", code, "mobile-gateway-client", "123456", REDIRECT_URI);
        log.info("callback" + code);
        return "callback";
    }

    @GetMapping("/authorized")
    public String authorized() {
        log.info("authorized");
        return "authorized";
    }
}
