package com.example.jogos.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jogos.model.Usuario;
import com.example.jogos.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    private UsuarioService service;

	public UsuarioController(UsuarioService service) {
		this.service = service;
	}


    @GetMapping
	public List<Usuario> listAll(){
		return service.getAll();
	}

    
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

    @PostMapping
	public Usuario insert(@RequestBody Usuario u){
		return service.insert(u);
	}


    @PutMapping(path = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario u){
		return service
				.findById(id)
				.map( record -> {
					service.saveAndFlush(u);
					return ResponseEntity.ok().body(u);
				}).orElse(ResponseEntity.notFound().build());
	}

    
    @DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return service
				.findById(id)
				.map( record -> {
					service.delete(record);
					return ResponseEntity.status(202).build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
