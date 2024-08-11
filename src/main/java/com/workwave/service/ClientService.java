package com.workwave.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import com.workwave.dto.CreateClientDto;
import com.workwave.dto.MessageDto;
import com.workwave.entity.Client;
import com.workwave.repository.ClientRepository;

@Service
public class ClientService implements RegisteredClientRepository {

	// Crear una instancia del logger
	private static final Logger log = LoggerFactory.getLogger(ClientService.class);

	private final ClientRepository clientRepository;

	private final PasswordEncoder passwordEncoder;

	public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
		this.clientRepository = clientRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void save(RegisteredClient registeredClient) {
	}

	@Override
	public RegisteredClient findById(String id) {
		Client client = clientRepository.findByClientId(id)
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
		return Client.toRegisteredClient(client);
	}

	@Override
	public RegisteredClient findByClientId(String clientId) {
		Client client = clientRepository.findByClientId(clientId)
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
		return Client.toRegisteredClient(client);
	}

	public MessageDto create(CreateClientDto dto) {
		Client client = clientFromDto(dto);
		clientRepository.save(client);
		return new MessageDto("client " + client.getClientId() + " saved");
	}
	
	private Client clientFromDto(CreateClientDto dto) {
		Client client = new Client();
		client.setClientId(dto.getClientId());
		client.setClientSecret(passwordEncoder.encode(dto.getClientSecret()));
		client.setAuthenticationMethods(dto.getAuthenticationMethods());
		client.setAuthorizationGrantTypes(dto.getAuthorizationGrantTypes());
		client.setRedirectUris(dto.getRedirectUris());
		client.setScopes(dto.getScopes());
		client.setRequireProofKey(dto.isRequireProofKey());
		return client;
	}

}
