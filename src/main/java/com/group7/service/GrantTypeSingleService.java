package com.group7.service;

import com.group7.model.GrantTypeSingle;
import com.group7.repository.GrantTypeSingleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrantTypeSingleService {

    private final GrantTypeSingleRepository repository;

    public GrantTypeSingleService(GrantTypeSingleRepository repository) {
        this.repository = repository;
    }

    public List<GrantTypeSingle> getAll() {
        return repository.findAll();
    }

    public Optional<GrantTypeSingle> getById(Integer id) {
        return repository.findById(id);
    }

    public GrantTypeSingle save(GrantTypeSingle grantType) {
        return repository.save(grantType);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
