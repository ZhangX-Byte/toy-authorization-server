package com.insight.into.life.clientgateway.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zhang_Xiang
 * @since 2022/5/9 14:07:11
 */
@FeignClient(name = "oauth-center", url = "http://127.0.0.1:9000", path = "/oauth2")
public interface OAuthApi {

    @PostMapping("/token")
    Object getAccessToken(@RequestParam("grant_type") String grantType, @RequestParam("code") String code, @RequestParam("client_id") String clientId, @RequestParam("client_secret") String clientSecret, @RequestParam("redirect_uri") String redirectUri);
}
