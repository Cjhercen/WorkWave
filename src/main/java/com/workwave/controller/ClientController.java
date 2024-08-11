package com.workwave.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workwave.dto.CreateClientDto;
import com.workwave.dto.MessageDto;
import com.workwave.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	// Crear una instancia del logger
	private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	private final ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping("/create")
	public ResponseEntity<MessageDto> create(@RequestBody CreateClientDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(dto));
	}
}
