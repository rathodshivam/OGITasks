package com.ogitasks.config;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorAware")
public class AuditingConfiguration implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.of(username);
	}

//	@Bean
//	public AuditorAware<String> auditorAware() {
//		return new AuditingConfiguration();
//	}
}
