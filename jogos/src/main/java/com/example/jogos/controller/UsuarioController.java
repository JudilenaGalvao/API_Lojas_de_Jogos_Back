package com.example.jogos.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jogos.domain.Usuario;
import com.example.jogos.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
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

	@GetMapping
	public List<Usuario.DtoResponse> list(){

        return this.service.list().stream().map(
                elementoAtual -> {
                    Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(elementoAtual, mapper);
                    response.generateLinks(elementoAtual.getId());
                    return response;
                }).toList();
    }

	@GetMapping("{id}")
    public Usuario.DtoResponse getById(@PathVariable Long id){

        Usuario usuario = this.service.getById(id);
        Usuario.DtoResponse response = Usuario.DtoResponse.convertToDto(usuario, mapper);
        response.generateLinks(usuario.getId());

        return response;
    }


	@PutMapping("{id}")
    public Usuario update(@RequestBody Usuario u, @PathVariable Long id){
        return this.service.update(u, id);
    }

	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }

}
