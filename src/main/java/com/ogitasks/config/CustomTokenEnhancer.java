package com.ogitasks.config;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class CustomTokenEnhancer implements TokenEnhancer {

//	@Autowired
//	UserService userService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//		((DefaultOAuth2AccessToken) accessToken)
//				.setAdditionalInformation(
//						userService.getAdditionalInformation(authentication));
		return accessToken;
	}

}