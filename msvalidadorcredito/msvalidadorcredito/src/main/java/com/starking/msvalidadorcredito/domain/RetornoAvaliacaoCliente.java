package com.starking.msvalidadorcredito.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetornoAvaliacaoCliente {

	private List<CartaoAprovado> cartoes;
}
