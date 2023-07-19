package com.example.jogos.service;

import org.springframework.stereotype.Service;
import com.example.jogos.domain.Jogo;
import com.example.jogos.repository.JogoRepository;

@Service
public class JogoService extends GenericService<Jogo, JogoRepository> {

    public JogoService(JogoRepository repository) {
        super(repository);
    }
}
