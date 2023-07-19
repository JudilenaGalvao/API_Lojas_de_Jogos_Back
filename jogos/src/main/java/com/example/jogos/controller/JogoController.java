package com.example.jogos.controller;

import org.springframework.web.bind.annotation.RestController;
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
import com.example.jogos.domain.Jogo;
import com.example.jogos.service.JogoService;

@RestController
@RequestMapping("/jogo")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class JogoController {
    
    private JogoService service;
    ModelMapper mapper;

	public JogoController(JogoService service,  ModelMapper mapper) {
		this.service = service;
        this.mapper = mapper;
	}


    @PostMapping
    public Jogo.DtoResponse create(@RequestBody Jogo.DtoRequest j){

        Jogo jogo = this.service.create(Jogo.DtoRequest.convertToEntity(j, mapper));

        Jogo.DtoResponse response = Jogo.DtoResponse.convertToDto(jogo, mapper);

        return response;
    }

   @GetMapping
	public List<Jogo.DtoResponse> list(){

        return this.service.list().stream().map(
                elementoAtual -> {
                    Jogo.DtoResponse response = Jogo.DtoResponse.convertToDto(elementoAtual, mapper);
                    response.generateLinks(elementoAtual.getId());
                    return response;
                }).toList();
    }

    @GetMapping("{id}")
    public Jogo.DtoResponse getById(@PathVariable Long id){

        Jogo jogo = this.service.getById(id);
        Jogo.DtoResponse response = Jogo.DtoResponse.convertToDto(jogo, mapper);
        response.generateLinks(jogo.getId());

        return response;
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
