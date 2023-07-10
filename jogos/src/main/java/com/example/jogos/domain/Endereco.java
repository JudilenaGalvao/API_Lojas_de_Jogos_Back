package com.example.jogos.domain;


import org.modelmapper.ModelMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Endereco  extends AbstractEntity{
    
    String rua;
    Integer numCasa;
    String complemento;
    String cep;

    // caso 3
    @OneToOne
    @JoinColumn(name="fk_usuario")
    Usuario usuario;

    @Data
    public static class DtoRequest{
        @NotBlank(message = "Usuário com rua em branco")
        String rua;

        @NotBlank(message = "Usuário com numero da casa em branco")
        Integer numCasa;

        @NotBlank(message = "Usuário com cep em branco")
        Integer cep;

        @NotNull(message = "Usuário não pode ser nulo")
        Usuario usuario;

        public static Endereco convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Endereco.class);
        }
    }

    @Data
    public static class DtoResponse{
        String rua;
        Integer numCasa;
        Integer cep;

        public static DtoResponse convertToDto(Endereco e, ModelMapper mapper){
            return mapper.map(e, DtoResponse.class);
        }

    }

    
}
