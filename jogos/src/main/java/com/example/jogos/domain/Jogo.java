package com.example.jogos.domain;

import org.modelmapper.ModelMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogo  extends AbstractEntity {
    String nome;
    String genero;
    String desenvolvedora;
    String anoLancamento;
    float precoJogo;

    @Data
    public static class DtoRequest{
        String nome;
        String genero;
        String desenvolvedora;
        String anoLancamento;
        float precoJogo;

        public static Jogo convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Jogo.class);
        }
    }

    @Data
    public static class DtoResponse{
       String nome;
       String genero;
       String desenvolvedora;


        public static DtoResponse convertToDto(Jogo j, ModelMapper mapper){
            return mapper.map(j, DtoResponse.class);
        }

    }
}
