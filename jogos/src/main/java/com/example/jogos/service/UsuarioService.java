package com.example.jogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.jogos.model.Usuario;
import com.example.jogos.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository repository;

    
    public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}


    public Usuario insert(Usuario u){
		return repository.save(u);
	}

	public Usuario update(Usuario u){
		return repository.save(u);
	}

	public void delete (Usuario u){
		repository.deleteById(u.getId());
	}

    public Usuario getOne(Long id){
		return repository.findById(id).orElse(null);
	}

	public Usuario saveAndFlush(Usuario u){
		return repository.saveAndFlush(u);
	}

	public Optional<Usuario> findById(Long id){
		return repository.findById(id);
	}

	public List<Usuario> getAll (){
		return repository.findAll();
	}

}
