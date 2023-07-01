package com.example.jogos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Jogo {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String nome;
    String genero;
    String desenvolvedora;
    String anoLancamento;
    float precoJogo;
}
