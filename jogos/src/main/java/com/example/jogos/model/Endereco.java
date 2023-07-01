package com.example.jogos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Endereco {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String rua;
    Integer numCasa;
    String complemento;
    String cep;
    String telefone;

    // caso 3
    @OneToOne
    @JoinColumn(name="fk_usuario")
    Usuario usuario;
}
