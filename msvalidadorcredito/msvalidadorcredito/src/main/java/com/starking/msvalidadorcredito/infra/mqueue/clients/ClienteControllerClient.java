package com.starking.msvalidadorcredito.infra.mqueue.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.starking.msvalidadorcredito.domain.DadosCliente;

@FeignClient(value = "msclientes", path = "/clientes")
public interface ClienteControllerClient {

	@GetMapping(params = "cpf")
	ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);
}
