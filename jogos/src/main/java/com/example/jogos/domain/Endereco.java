package com.example.jogos.domain;


import org.modelmapper.ModelMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Endereco  extends AbstractEntity{
    
    String rua;

    // caso 3
    @OneToOne
    @JoinColumn(name="fk_usuario")
    Usuario usuario;

    @Data
    public static class DtoRequest{
        @NotBlank(message = "Usuário com rua em branco")
        String rua;


        public static Endereco convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Endereco.class);
        }
    }

    @Data
    public static class DtoResponse{
        String rua;

        public static DtoResponse convertToDto(Endereco e, ModelMapper mapper){
            return mapper.map(e, DtoResponse.class);
        }

    }

    
}
