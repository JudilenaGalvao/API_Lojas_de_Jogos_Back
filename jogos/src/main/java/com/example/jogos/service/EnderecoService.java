package com.example.jogos.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.jogos.domain.Endereco;
import com.example.jogos.repository.EnderecoRepository;


@Service

public class EnderecoService extends GenericService<Endereco, EnderecoRepository> {

    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}

