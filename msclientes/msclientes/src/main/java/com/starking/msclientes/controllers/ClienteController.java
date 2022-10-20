package com.starking.msclientes.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.starking.msclientes.application.representation.ClienteSaveRequest;
import com.starking.msclientes.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody ClienteSaveRequest request) {
		var cliente = request.toModel();
		this.clienteService.salvar(cliente);
		URI headerLocation = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.query("cpf={cpf}")
				.buildAndExpand(cliente.getCpf())
				.toUri();
		return ResponseEntity.created(headerLocation).build();
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity<?> dadosCliente(@RequestParam("cpf") String cpf) {
		var cliente = this.clienteService.getByCPF(cpf);
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
}
