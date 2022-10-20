package com.starking.msclientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.msclientes.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findByCpf(String cpf);

}
