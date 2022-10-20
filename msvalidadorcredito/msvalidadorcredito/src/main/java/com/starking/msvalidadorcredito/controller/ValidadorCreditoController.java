package com.starking.msvalidadorcredito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starking.msvalidadorcredito.ValidadorClienteService;
import com.starking.msvalidadorcredito.domain.SituacaoCliente;

@RestController
@RequestMapping("validacoes-credito")
public class ValidadorCreditoController {
	
	@Autowired
	private ValidadorClienteService validadorClienteService;

	@GetMapping
	public String status() {
		return "olá vida";
	}
	
	@GetMapping(value = "situacao-cliente", params = "cpf")
	public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@RequestParam("cpf") String cpf) {
		SituacaoCliente situacaoCliente = this.validadorClienteService.obterSituacaoCliente(cpf);
	}
}
