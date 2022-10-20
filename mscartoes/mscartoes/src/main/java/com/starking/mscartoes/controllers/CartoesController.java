package com.starking.mscartoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starking.mscartoes.application.representation.CartaoSaveRequest;
import com.starking.mscartoes.domain.Cartao;
import com.starking.mscartoes.services.CartaoService;

@RestController
@RequestMapping("cartoes")
public class CartoesController {
	
	@Autowired
	private CartaoService cartaoService;
	
	@GetMapping
	public String status() {
		return "cartoes";
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody CartaoSaveRequest request) {
		Cartao cartao = request.toModel();
		this.cartaoService.salvar(cartao);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping(params = "renda")
	public ResponseEntity<List<Cartao>> getCartoeRendaAte(@RequestParam("renda") Long renda) {
		List<Cartao> lista = this.cartaoService.getCartoesRendaMenorIgual(renda);
		return ResponseEntity.ok(lista);
	}
}
