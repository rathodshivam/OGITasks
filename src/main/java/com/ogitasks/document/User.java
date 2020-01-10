package com.ogitasks.document;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ogitasks.audit.DateAudit;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "user")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class User extends DateAudit implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6654208740321206499L;

	public static final String USERNAME_FIELD = "username";
	public static final String EMAIL_FIELD = "email";
	public static final String CITY_FIELD = "city";
	public static final String LOCATION_FIELD = "location";
	public static final String PASSWORD_FIELD = "password";
	public static final String ACCOUNT_NON_EXPIRED = "account_non_expired";
	public static final String ACCOUNT_NON_LOCKED = "account_non_locked";
	public static final String CREDENTIALS_NON_EXPIRED = "credentials_non_expired";
	public static final String ENABLED_FIELD = "enabled";
	public static final String ROLES_FIELD = "roles";
	public static final String NAME_FIELD = "name";
	public static final String PHONE_FIELD = "phone";
	public static final String OTP_DATE = "otp_date";
	public static final String AUTH_TYPE = "auth_type";

	@Id
	private String id;

	@Field(USERNAME_FIELD)
	private String username;

	@Field(EMAIL_FIELD)
	private String email;

	@Field(PASSWORD_FIELD)
	private String password;

	@Field(OTP_DATE)
	private Long otpDate;

	@Field(NAME_FIELD)
	private String name;

	@Field(AUTH_TYPE)
	private String authType;

	@Field(ENABLED_FIELD)
	private Boolean enabled = true;

	@Field(ACCOUNT_NON_EXPIRED)
	private boolean accountNonExpired = false;

	@Field(ACCOUNT_NON_LOCKED)
	private boolean accountNonLocked = false;

	@Field(CREDENTIALS_NON_EXPIRED)
	private boolean credentialsNonExpired = false;

	@Field(ROLES_FIELD)
	private Set<String> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> rolesList = new HashSet<>();
		if (roles != null) {
			for (String role : roles) {
				Role r = new Role();
				r.setName(role);
				rolesList.add(r);
			}
		}
		return rolesList;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
