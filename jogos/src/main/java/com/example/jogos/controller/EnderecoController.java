package com.example.jogos.controller;

import org.springframework.web.bind.annotation.*;
import com.example.jogos.domain.Endereco;
import com.example.jogos.service.EnderecoService;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    private EnderecoService service;

	public EnderecoController(EnderecoService service) {
		this.service = service;
	}

	@GetMapping
    public List<Endereco> list(){
        return this.service.list();
    }

	@PutMapping("{id}")
    public Endereco update(@RequestBody Endereco e, @PathVariable Long id){
        return this.service.update(e, id);
    }

	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }

}
