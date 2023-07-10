package com.example.jogos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.jogos.domain.Usuario;
import com.example.jogos.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository>{

    public UsuarioService(UsuarioRepository repository) {
		super(repository);
	}

}
