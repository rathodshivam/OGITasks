package com.ogitasks.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.ogitasks.document.User;
import com.ogitasks.repository.UserRepository;
import com.ogitasks.service.UserService;
import com.ogitasks.utility.AppUtility;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailAndEnabled(username, true);
		if (AppUtility.isEmpty(user)) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getAuthorities());

	}

	@Override
	public Map<String, Object> getAdditionalInformation(OAuth2Authentication authentication) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roles", authentication.getAuthorities());
		return map;
	}

}
