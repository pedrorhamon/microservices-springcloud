package com.starking.msvalidadorcredito.exception;

public class ErroSolicitacaoCartaoException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ErroSolicitacaoCartaoException(String msg) {
		super(msg);
	}
}
