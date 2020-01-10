package com.ogitasks.validator.wrapper;

import java.util.Map;

import com.ogitasks.constants.AppConstants;
import com.ogitasks.validator.ContainsKeys;
import com.ogitasks.validator.NotEmptyValue;

public class AuthWrapper extends GenricWrapper {
	@ContainsKeys({ AppConstants.EMAIL, AppConstants.ALLOW_SIGN_UP })
	@NotEmptyValue({ AppConstants.EMAIL, AppConstants.ALLOW_SIGN_UP })
	@Override
	public Map<String, Object> getMap() {
		return super.getMap();
	}
}
