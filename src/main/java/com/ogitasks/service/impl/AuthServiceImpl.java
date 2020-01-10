package com.ogitasks.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mifmif.common.regex.Generex;
import com.ogitasks.constants.AppConstants;
import com.ogitasks.document.AuthType;
import com.ogitasks.document.User;
import com.ogitasks.exception.UserRequestException;
import com.ogitasks.repository.UserRepository;
import com.ogitasks.service.AuthService;
import com.ogitasks.utility.AppUtility;
import com.ogitasks.utility.MailUtility;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	MailUtility mailUtility;

	@Override
	public Map<String, Object> auth(Map<String, Object> map) {
		User user = userRepository.findByEmail((String) map.get(AppConstants.EMAIL));
		if (Boolean.parseBoolean((String) map.get(AppConstants.ALLOW_SIGN_UP))) {
			if (AppUtility.isEmpty(user)) {
				user = new User();
				user.setEmail((String) map.get(AppConstants.EMAIL));
				user.setUsername(UUID.randomUUID().toString());
				user.setAuthType(AuthType.OTP.toString());
				user.setRoles(new HashSet<>(Arrays.asList(AppConstants.ROLES[2])));
			}

		} else if (AppUtility.isEmpty(user)) {
			throw new UserRequestException("User not found");
		}
		String pass = removeLastCharRegexOptional(createPassword());
		user.setPassword(encoder.encode(pass));
		user.setOtpDate(System.currentTimeMillis());
		userRepository.save(user);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("auth", AuthType.OTP);
		map2.put("password", pass);
		Map<String, Object> mailParams = new HashMap<>();
		mailParams.put("email", user.getEmail());
		mailParams.put("password", pass);
		mailUtility.send(user.getEmail(), "Welcome to OGITasks", "newUser.vm", mailParams);
		return map2;
	}

	/**
	 * this method creates and random password matching to the regex expression
	 * 
	 * @return {@link String} random password matching to regex expression
	 * 
	 * @see Generex
	 * @see Generex#random()
	 */
	public String createPassword() {
		Generex generex = new Generex("([0-9]{3}-){3}");
		return generex.random();
	}

	public static String removeLastCharRegexOptional(String s) {
		return Optional.ofNullable(s).map(str -> str.replaceAll(".$", "")).orElse(s);
	}
}
