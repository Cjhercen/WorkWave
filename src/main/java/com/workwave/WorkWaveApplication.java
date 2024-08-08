package com.workwave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.workwave.entity.Role;
import com.workwave.enums.RoleName;
import com.workwave.repository.RoleRepository;

@SpringBootApplication
public class WorkWaveApplication /*implements CommandLineRunner*/ {

//	@Autowired
//	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WorkWaveApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Role adminRole = new Role();
//		adminRole.setRole(RoleName.ROLE_ADMIN);
//		
//		Role userRole = new Role();
//		userRole.setRole(RoleName.ROLE_USER);
//		
//		roleRepository.save(adminRole);
//		roleRepository.save(userRole);
//	}

}
