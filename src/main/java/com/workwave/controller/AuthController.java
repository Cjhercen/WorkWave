package com.workwave.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workwave.dto.CreateAppUserDto;
import com.workwave.dto.MessageDto;
import com.workwave.service.AppUserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AppUserService appUserService;
	
	public AuthController(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	@PostMapping("/create")
	public ResponseEntity<MessageDto> createUser(@RequestBody CreateAppUserDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
	}
	
}
