package com.example.jogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jogos.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
