package com.example.jogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jogos.model.Jogo;


public interface JogoRepository extends JpaRepository<Jogo, Long>{
    
}
