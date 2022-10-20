package com.starking.mscartoes.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.mscartoes.domain.Cartao;

public interface CartaoRespository extends JpaRepository<Cartao, Long>{

	List<Cartao> findByRendaLessThanEqual(BigDecimal renda);

}
