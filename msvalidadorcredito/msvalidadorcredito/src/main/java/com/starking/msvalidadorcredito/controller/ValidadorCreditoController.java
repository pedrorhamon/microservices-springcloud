package com.starking.msvalidadorcredito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validacoes-credito")
public class ValidadorCreditoController {

	@GetMapping
	public String status() {
		return "olá vida";
	}
}
