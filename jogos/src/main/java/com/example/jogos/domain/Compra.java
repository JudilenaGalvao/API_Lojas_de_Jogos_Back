package com.example.jogos.domain;

import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Compra  extends AbstractEntity {
    
    Date data;
    float precoTotal;

    //caso 3
    @ManyToOne
	@JoinColumn(name = "fk_usuario")
	Usuario usuario;

    //caso 1
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "compra_jogo", joinColumns = { @JoinColumn(name ="fk_compra", referencedColumnName = "id") }, inverseJoinColumns = {
    @JoinColumn(name = "fk_jogo") })
    List<Jogo> jogo;


    @Data
    public static class DtoRequest {
        @NotBlank(message = "Data da compra em branco")
        Date data;

        @NotBlank(message = "Preço total não pode ser nulo")
        float precoTotal;

        @NotNull(message = "Usuário não pode ser nulo")
        Usuario usuario;

        @NotEmpty(message = "Lista de jogos não pode ser vazia")
        List<Jogo> jogos;

        public static Compra convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Compra.class);
        }

    }

    @Data
    public static class DtoResponse{

        List<Jogo> jogos;
        Date data;
        float precoTotal;


        public static DtoResponse convertToDto(Compra c, ModelMapper mapper){
            return mapper.map(c, DtoResponse.class);
        }

    }


}
