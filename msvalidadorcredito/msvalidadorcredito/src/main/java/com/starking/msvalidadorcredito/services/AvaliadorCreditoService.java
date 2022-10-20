package com.starking.msvalidadorcredito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starking.msvalidadorcredito.domain.CartaoCliente;
import com.starking.msvalidadorcredito.domain.DadosCliente;
import com.starking.msvalidadorcredito.domain.SituacaoCliente;
import com.starking.msvalidadorcredito.exception.DadosClienteNotFoundException;
import com.starking.msvalidadorcredito.exception.ErroComunicacaoMicroServicesException;
import com.starking.msvalidadorcredito.repository.CartaoControllerClient;
import com.starking.msvalidadorcredito.repository.ClienteControllerClient;

import feign.FeignException;

@Service
public class AvaliadorCreditoService {
	
	@Autowired
	private ClienteControllerClient clientesClient;
	
	@Autowired
	private CartaoControllerClient cartaoClient;

	public SituacaoCliente obterSituacaoCliente(String cpf)  throws DadosClienteNotFoundException, ErroComunicacaoMicroServicesException {
		try {			
			ResponseEntity<DadosCliente> responseEntity = this.clientesClient.dadosCliente(cpf);
			ResponseEntity<List<CartaoCliente>> cartaoResponse = this.cartaoClient.getCartoesByCliente(cpf);
			
			return SituacaoCliente.builder()
					.cliente(responseEntity.getBody())
					.cartoes(cartaoResponse.getBody())
					.build();
		} catch(FeignException.FeignClientException e) {
			int status = e.status();
			if(HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosClienteNotFoundException();
			}
			throw new ErroComunicacaoMicroServicesException(e.getMessage(), status);
		}
	}

}
