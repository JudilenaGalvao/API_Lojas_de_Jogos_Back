package com.example.jogos.domain;

import java.util.List;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;
import com.example.jogos.controller.UsuarioController;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SQLDelete(sql = "UPDATE usuario SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted_at is null")
@EqualsAndHashCode(callSuper = true)

public class Usuario extends AbstractEntity{
    
    String nome;
    String email;
    String login;
    String senha;

    //Caso 3
    @OneToOne(mappedBy = "usuario")
	Endereco endereco;

    //caso 3
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "usuario")
    List<Compra> compra;


    @Data
    public static class DtoRequest{
        @NotBlank(message = "Usuário com nome em branco")
        String nome;

        @NotBlank(message = "Usuário com email em branco")
        String email;

        @NotBlank(message = "Usuário com login em branco")
        String login;

        @Max(value = 10, message = "Senha no maximo de 10 caracteres")
        String senha;

        public static Usuario convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Usuario.class);
        }
    }

    @Data

    public static class DtoResponse extends RepresentationModel<DtoResponse>{
        Long id;
        String nome;
        String login;

        public static DtoResponse convertToDto(Usuario u, ModelMapper mapper){
            return mapper.map(u, DtoResponse.class);
        }
        public void generateLinks(Long id){
            add(linkTo(UsuarioController.class).slash(id).withSelfRel());
            add(linkTo(UsuarioController.class).withRel("usuario"));
            add(linkTo(UsuarioController.class).slash(id).withRel("delete"));
        }
        
    }
}
