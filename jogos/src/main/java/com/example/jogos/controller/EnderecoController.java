package com.example.jogos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jogos.model.Endereco;
import com.example.jogos.service.EnderecoService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    private EnderecoService service;

	public EnderecoController(EnderecoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Endereco> listAll(){
		return service.getAll();
	}

	@GetMapping (path = "/{id}")
	public ResponseEntity<Endereco> getOne(@PathVariable Long id){

		Optional<Endereco> optionalEndereco = service.findById(id);

		if (optionalEndereco.isEmpty()){
			return ResponseEntity.notFound().build();
		}


		Endereco endereco = optionalEndereco.get();

		return ResponseEntity.ok().body(endereco);
	}

    @PostMapping
	public Endereco insert(@RequestBody Endereco e){
		return service.insert(e);
	}

    @PutMapping(path = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco e){
		return service
				.findById(id)
				.map( record -> {
					service.saveAndFlush(e);
					return ResponseEntity.ok().body(e);
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
