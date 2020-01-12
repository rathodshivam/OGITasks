package com.ogitasks.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface UserService extends UserDetailsService {

	Map<String, Object> getAdditionalInformation(OAuth2Authentication authentication);

}
