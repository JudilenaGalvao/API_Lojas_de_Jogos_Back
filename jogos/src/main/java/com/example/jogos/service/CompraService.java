package com.example.jogos.service;

import org.springframework.stereotype.Service;
import com.example.jogos.domain.Compra;
import com.example.jogos.repository.CompraRepository;


@Service
public class CompraService extends GenericService<Compra, CompraRepository> {

    public CompraService(CompraRepository repository) {
        super(repository);
    }
}

