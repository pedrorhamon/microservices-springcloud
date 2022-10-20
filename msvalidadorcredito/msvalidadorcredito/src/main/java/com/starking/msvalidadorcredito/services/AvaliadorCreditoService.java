package com.starking.msvalidadorcredito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starking.msvalidadorcredito.domain.DadosCliente;
import com.starking.msvalidadorcredito.domain.SituacaoCliente;
import com.starking.msvalidadorcredito.repository.ClienteControllerClient;

@Service
public class AvaliadorCreditoService {
	
	@Autowired
	private ClienteControllerClient clientesClient;

	public SituacaoCliente obterSituacaoCliente(String cpf) {
		
		ResponseEntity<DadosCliente> responseEntity = this.clientesClient.dadosCliente(cpf);
		
		return SituacaoCliente.builder()
				.cliente(responseEntity.getBody())
				.build();
	}

}
