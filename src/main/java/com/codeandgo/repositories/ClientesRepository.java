package com.codeandgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeandgo.models.Clientes;


public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
