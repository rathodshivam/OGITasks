package com.ogitasks.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogitasks.constants.UriConstants;
import com.ogitasks.service.AuthService;
import com.ogitasks.utility.ResponseMessage;
import com.ogitasks.validator.wrapper.AuthWrapper;

@RestController
@RequestMapping(value = UriConstants.AUTH)
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/")
	public ResponseMessage<Map<String, Object>> auth(@RequestBody @Valid AuthWrapper wrapper) {
		return new ResponseMessage<>(HttpStatus.OK.value(), "User Found", authService.auth(wrapper.getMap()));
	}
}
