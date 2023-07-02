package com.example.jogos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.jogos.model.Jogo;
import com.example.jogos.repository.JogoRepository;

@Service
public class JogoService {
    private JogoRepository repository;

    
    public JogoService(JogoRepository repository) {
		this.repository = repository;
	}


    public Jogo insert(Jogo j){
		return repository.save(j);
	}

	public Jogo update(Jogo j){
		return repository.save(j);
	}

	public void delete (Jogo j){
		repository.deleteById(j.getId());
	}

    public Jogo getOne(Long id){
		return repository.findById(id).orElse(null);
	}

	public Jogo saveAndFlush(Jogo j){
		return repository.saveAndFlush(j);
	}

	public Optional<Jogo> findById(Long id){
		return repository.findById(id);
	}

	public List<Jogo> getAll (){
		return repository.findAll();
	}

}
