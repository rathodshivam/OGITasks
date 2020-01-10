package com.ogitasks.document;

import java.io.Serializable;

import javax.persistence.EntityListeners;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

import com.ogitasks.audit.DateAudit;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "role")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Role extends DateAudit implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 1L;
	public static final String NAME_FIELD = "name";

	@Id
	@Field(NAME_FIELD)
	private String name;

	@Override
	public String getAuthority() {
		return this.name;
	}
}
