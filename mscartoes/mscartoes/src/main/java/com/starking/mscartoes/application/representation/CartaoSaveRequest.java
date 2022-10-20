package com.starking.mscartoes.application.representation;

import java.math.BigDecimal;

import com.starking.mscartoes.domain.Cartao;
import com.starking.mscartoes.domain.enums.BandeiraCartao;

import lombok.Data;

@Data
public class CartaoSaveRequest {

	private String nome;
	private BandeiraCartao bandeira;
	private BigDecimal renda;
	private BigDecimal limite;
	
	public Cartao toModel() {
		return new Cartao(nome, bandeira, renda, limite);
	}
}
