package com.workwave.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workwave.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	// Crear una instancia del logger
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
  
	private final AppUserRepository appUserRepository;

	public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
		super();
		this.appUserRepository = appUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return appUserRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}
	
	
	
}
