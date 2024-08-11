package com.workwave.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workwave.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	Optional<Client> findByClientId(String clientId);
	
}
