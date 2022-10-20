package com.starking.msclientes.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.msclientes.domain.Cliente;
import com.starking.msclientes.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return this.clienteService.salvar(cliente);
	}
}
