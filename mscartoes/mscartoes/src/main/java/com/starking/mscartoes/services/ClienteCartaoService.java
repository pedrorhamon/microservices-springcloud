package com.starking.mscartoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starking.mscartoes.domain.ClienteCartao;
import com.starking.mscartoes.infra.mqueue.clients.ClienteCartaoRepository;

@Service
public class ClienteCartaoService {

	@Autowired
	private ClienteCartaoRepository clienteCartaoRepository;

	public List<ClienteCartao> listaCartoesByCpf(String cpf) {
		return this.clienteCartaoRepository.findByCpf(cpf);
	}
}
