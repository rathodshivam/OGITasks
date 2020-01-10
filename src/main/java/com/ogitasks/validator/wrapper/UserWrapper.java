package com.ogitasks.validator.wrapper;

import java.util.Map;

import com.ogitasks.constants.AppConstants;
import com.ogitasks.validator.ContainsKeys;
import com.ogitasks.validator.NotEmptyValue;

public class UserWrapper extends GenricWrapper {

	@ContainsKeys({ AppConstants.NAME, AppConstants.PHONE })
	@NotEmptyValue({ AppConstants.NAME, AppConstants.PHONE })
	@Override
	public Map<String, Object> getMap() {
		return super.getMap();
	}
}
