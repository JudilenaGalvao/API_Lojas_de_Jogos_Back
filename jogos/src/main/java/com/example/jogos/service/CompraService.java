package com.example.jogos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.jogos.model.Compra;
import com.example.jogos.repository.CompraRepository;


@Service
public class CompraService {
    
    private CompraRepository repository;

    
    public CompraService(CompraRepository repository) {
		this.repository = repository;
	}


    public Compra insert(Compra c){
		return repository.save(c);
	}

	public Compra update(Compra c){
		return repository.save(c);
	}

	public void delete (Compra c){
		repository.deleteById(c.getId());
	}

    public Compra getOne(Long id){
		return repository.findById(id).orElse(null);
	}

	public Compra saveAndFlush(Compra c){
		return repository.saveAndFlush(c);
	}

	public Optional<Compra> findById(Long id){
		return repository.findById(id);
	}

	public List<Compra> getAll (){
		return repository.findAll();
	}
}
