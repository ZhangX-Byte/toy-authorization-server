package com.insight.into.life.clientgateway.dto;

/**
 * @author Zhang_Xiang
 * @since 2022/5/9 14:20:15
 */
public record OAuthRequest(String clientId, String clientSecret, String responseType, String redirectUri,
                           String state) {
}
