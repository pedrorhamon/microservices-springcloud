package com.starking.mscartoes.domain;
import lombok.Data;

@Data
public class DadosSolicitacaoEmissaoCartao {
	private Long idCartao;
	private String cpf;
	private String endereco;
	private Double limiteLiberado;
}