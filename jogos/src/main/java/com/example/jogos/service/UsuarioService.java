package com.example.jogos.service;

import org.springframework.stereotype.Service;
import com.example.jogos.domain.Usuario;
import com.example.jogos.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository>{

    public UsuarioService(UsuarioRepository repository) {
		super(repository);
	}

}
