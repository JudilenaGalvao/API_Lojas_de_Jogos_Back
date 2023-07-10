package com.example.jogos.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.jogos.domain.AbstractEntity;


public interface IGenericRepository<E extends AbstractEntity> extends ListCrudRepository<E, Long> {
}


