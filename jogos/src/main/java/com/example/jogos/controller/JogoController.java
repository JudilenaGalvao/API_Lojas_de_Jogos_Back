package com.example.jogos.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.jogos.domain.Jogo;
import com.example.jogos.service.JogoService;
import java.util.Optional;

@RestController
@RequestMapping("/jogo")
public class JogoController {
    
    private JogoService service;

	public JogoController(JogoService service) {
		this.service = service;
	}


    @GetMapping
    public List<Jogo> list(){
        return this.service.list();
    }

	@PutMapping("{id}")
    public Jogo update(@RequestBody Jogo j, @PathVariable Long id){
        return this.service.update(j, id);
    }

	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }

}
