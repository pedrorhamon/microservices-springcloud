package com.starking.msvalidadorcredito.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.starking.msvalidadorcredito.domain.Cartao;
import com.starking.msvalidadorcredito.domain.CartaoCliente;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartaoControllerClient {
	
	@GetMapping(params = "cpf")
	ResponseEntity<List<CartaoCliente>> getCartoesByCliente(@RequestParam("cpf") String cpf);
	
	@GetMapping(params = "renda")
	ResponseEntity<List<Cartao>> getCartoeRendaAte(@RequestParam("renda") Long renda);
}
