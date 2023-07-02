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
import com.example.jogos.model.Compra;
import com.example.jogos.service.CompraService;


@RestController
@RequestMapping("/compra")
public class CompraController {

    private CompraService service;

	public CompraController(CompraService service) {
		this.service = service;
	}


    @GetMapping
	public List<Compra> listAll(){
		return service.getAll();
	}

    
    @GetMapping(path = {"/{id}"})
	public ResponseEntity<Compra> getOne(@PathVariable Long id){

		Optional<Compra> compraOptional = service.findById(id);

		if (compraOptional.isEmpty()){
			return ResponseEntity.notFound().build();
		}else {


            Compra compra = compraOptional.get();

			return ResponseEntity.ok().body(compra);
		}

    }

    @PostMapping
	public Compra insert(@RequestBody Compra c){
		return service.insert(c);
	}


    @PutMapping(path = "/{id}")
	public ResponseEntity<Compra> update(@PathVariable Long id, @RequestBody Compra c){
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
