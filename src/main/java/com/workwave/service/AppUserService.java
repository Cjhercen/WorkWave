package com.workwave.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workwave.dto.CreateAppUserDto;
import com.workwave.dto.MessageDto;
import com.workwave.entity.AppUser;
import com.workwave.entity.Role;
import com.workwave.enums.RoleName;
import com.workwave.repository.AppUserRepository;
import com.workwave.repository.RoleRepository;

@Service
public class AppUserService {

	// Crear una instancia del logger
    private static final Logger log = LoggerFactory.getLogger(AppUserService.class);
    
	private final AppUserRepository appUserRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	public AppUserService(AppUserRepository appUserRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.appUserRepository = appUserRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public MessageDto createUser(CreateAppUserDto dto) {
		AppUser appUser = new AppUser();
		appUser.setUsername(dto.username());
		appUser.setPassword(passwordEncoder.encode(dto.password()));
		
		Set<Role> roles = new HashSet<>();
		dto.roles().forEach(r -> {
			Role role = roleRepository.findByRole(RoleName.valueOf(r))
					.orElseThrow(() -> new RuntimeException("Role no encontrado"));
			roles.add(role); 
		});
		
		appUser.setRoles(roles);
		appUserRepository.save(appUser);
		return new MessageDto("user " + appUser.getUsername() + " guardado");
	}
	

}
