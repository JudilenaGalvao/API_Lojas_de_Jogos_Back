package com.example.jogos.domain;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import com.example.jogos.controller.JogoController;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
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
        String anoLancamento;
        float precoJogo;

        public static DtoResponse convertToDto(Jogo j, ModelMapper mapper){
            return mapper.map(j, DtoResponse.class);
        }

        public void generateLinks(Long id){
            add(linkTo(JogoController.class).slash(id).withSelfRel());
            add(linkTo(JogoController.class).withRel("jogo"));
            add(linkTo(JogoController.class).slash(id).withRel("delete"));
        }

        private void add(Link withSelfRel) {
        }

    }
}
