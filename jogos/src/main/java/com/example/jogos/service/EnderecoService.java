package com.example.jogos.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.jogos.model.Endereco;
import com.example.jogos.repository.EnderecoRepository;


@Service
public class EnderecoService {

    private EnderecoRepository repository;

    
    public EnderecoService(EnderecoRepository repository) {
		this.repository = repository;
	}


    public Endereco insert(Endereco e){
		return repository.save(e);
	}

	public Endereco update(Endereco e){
		return repository.save(e);
	}

	public void delete (Endereco e){
		repository.deleteById(e.getId());
	}

    public Endereco getOne(Long id){
		return repository.findById(id).orElse(null);
	}

	public Endereco saveAndFlush(Endereco e){
		return repository.saveAndFlush(e);
	}

	public Optional<Endereco> findById(Long id){
		return repository.findById(id);
	}

	public List<Endereco> getAll (){
		return repository.findAll();
	}

}
