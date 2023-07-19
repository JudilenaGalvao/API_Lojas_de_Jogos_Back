package com.example.jogos.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jogos.domain.Compra;
import com.example.jogos.domain.Jogo;
import com.example.jogos.service.CompraService;


@RestController
@RequestMapping("/compra")
public class CompraController {

    private CompraService service;
    ModelMapper mapper;

	public CompraController(CompraService service,  ModelMapper mapper) {
		this.service = service;
        this.mapper = mapper;
	}


    @PostMapping
    public Compra.DtoResponse create(@RequestBody Compra.DtoRequest c){

        Compra compra = this.service.create(Compra.DtoRequest.convertToEntity(c, mapper));

        Compra.DtoResponse response = Compra.DtoResponse.convertToDto(compra, mapper);

        return response;
    }

    @GetMapping
    public List<Compra> list(){
        return this.service.list();
    }

	@PutMapping("{id}")
    public Compra update(@RequestBody Compra c, @PathVariable Long id){
        return this.service.update(c, id);
    }

	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }
    
}
