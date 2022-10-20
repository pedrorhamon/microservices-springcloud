package com.starking.msvalidadorcredito.exception;

import lombok.Getter;

public class ErroComunicacaoMicroServicesException  extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Getter
	private Integer status;
	
	public ErroComunicacaoMicroServicesException(String msg, Integer status) {
		super(msg);
		this.status = status;
	}

}
