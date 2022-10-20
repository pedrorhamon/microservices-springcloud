package com.starking.msclientes.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starking.msclientes.domain.Cliente;
import com.starking.msclientes.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Optional<Cliente> getByCPF(String cpf) {
		return this.clienteRepository.findByCpf(cpf);
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
}
