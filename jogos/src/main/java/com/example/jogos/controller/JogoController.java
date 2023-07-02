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
import com.example.jogos.model.Jogo;
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
	public List<Jogo> listAll(){
		return service.getAll();
	}

    
    @GetMapping(path = {"/{id}"})
	public ResponseEntity<Jogo> getOne(@PathVariable Long id){

		Optional<Jogo> jogoOptional = service.findById(id);

		if (jogoOptional.isEmpty()){
			return ResponseEntity.notFound().build();
		}else {


            Jogo jogo = jogoOptional.get();

			return ResponseEntity.ok().body(jogo);
		}

    }
    @PostMapping
	public Jogo insert(@RequestBody Jogo c){
		return service.insert(c);
	}


    @PutMapping(path = "/{id}")
	public ResponseEntity<Jogo> update(@PathVariable Long id, @RequestBody Jogo c){
		return service
				.findById(id)
				.map( record -> {
					service.saveAndFlush(c);
					return ResponseEntity.ok().body(c);
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
