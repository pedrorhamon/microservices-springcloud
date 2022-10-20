package com.starking.mscartoes.services;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starking.mscartoes.domain.Cartao;
import com.starking.mscartoes.repository.CartaoRespository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRespository cartaoRespository;
	
	@Transactional
	public Cartao salvar(Cartao cartao) {
		return this.cartaoRespository.save(cartao);
	}
	
	public List<Cartao> getCartoesRendaMenorIgual(Long renda) {
		var rendaBigDecimal = BigDecimal.valueOf(renda);
		return this.cartaoRespository.findByRendaLessThanEqual(rendaBigDecimal);
	}

}
