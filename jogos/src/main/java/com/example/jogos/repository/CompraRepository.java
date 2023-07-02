package com.example.jogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jogos.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
    
}
