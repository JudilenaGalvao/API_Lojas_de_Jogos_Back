package com.example.jogos.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.jogos.domain.Usuario;
import com.example.jogos.service.UsuarioService;

import jakarta.validation.Valid;

import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    private UsuarioService service;
	ModelMapper mapper;

	public UsuarioController(UsuarioService service, ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}



	@PostMapping
    public Usuario.DtoResponse create(@RequestBody Usuario.DtoRequest u){

        Usuario usuario = this.service.create(Usuario.DtoRequest.convertToEntity(u, mapper));

        Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(usuario, mapper);

        return response;
    }


/*
    @GetMapping(path = {"/{id}"})
	public ResponseEntity<Usuario> getOne(@PathVariable Long id){

		Optional<Usuario> usuarioOptional = service.findById(id);

		if (usuarioOptional.isEmpty()){
			return ResponseEntity.notFound().build();
		}else {


            Usuario usuario = usuarioOptional.get();

			return ResponseEntity.ok().body(usuario);
		}

    }
	
/*
    @PostMapping
	public Usuario insert(@RequestBody Usuario u){
		return service.insert(u);
	}
*/

	@GetMapping
    public List<Usuario> list(){
        return this.service.list();
    }

	@PutMapping("{id}")
    public Usuario update(@RequestBody Usuario u, @PathVariable Long id){
        return this.service.update(u, id);
    }

	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }

	/*
    @PutMapping(path = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario u){
		return service
				.findById(id)
				.map( record -> {
					service.saveAndFlush(u);
					return ResponseEntity.ok().body(u);
				}).orElse(ResponseEntity.notFound().build());
	}

    /*
    @DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return service
				.findById(id)
				.map( record -> {
					service.delete(record);
					return ResponseEntity.status(202).build();
				}).orElse(ResponseEntity.notFound().build());
	}
	*/
}
