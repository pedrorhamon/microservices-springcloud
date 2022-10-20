package com.starking.mscartoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.mscartoes.domain.ClienteCartao;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long>{
	
	List<ClienteCartao> findByCpf(String cpf);	

}
