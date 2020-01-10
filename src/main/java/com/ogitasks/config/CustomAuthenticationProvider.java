//package com.divergentsl.vardan.config;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.divergentsl.vardan.document.User;
//import com.divergentsl.vardan.repository.UserRepository;
//
//@Component
//public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	SecurityConfig securityConfig;
//	
//	@Override
//	public Authentication authenticate(Authentication authentication) {
//		Authentication authentication2 = super.authenticate(authentication);
//		List<User> users = userRepository.findByPhone(authentication.getName());
//		if (users.isEmpty()) {
//			throw new UsernameNotFoundException("Phone number is not registered in our system");
//		}
//		User user = users.get(0);
//		user.setPassword(null);
//		userRepository.save(user);
//		return authentication2;
//		// String phone = authentication.getName();
////		String password = authentication.getCredentials().toString();
////		List<User> users = userRepository.findByPhone(phone);
////		if (AppUtility.isEmpty(users)) {
////			throw new UsernameNotFoundException("Phone number is not registered to our system");
////		}
////		User user = users.get(0);
////		if (!securityConfig.encoder().matches(password, user.getPassword())) {
////			throw new BadCredentialsException("Bad Credentials");
////		} else {
////			user.setPassword(null);
////			userRepository.save(user);
////			return new UsernamePasswordAuthenticationToken(phone, password);
////		}
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//	}
//
//}
