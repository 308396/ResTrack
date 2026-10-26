
package com.group7.service;

import com.group7.model.ResearchStatus;
import com.group7.repository.ResearchStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchStatusService {

    private final ResearchStatusRepository repository;

    public ResearchStatusService(ResearchStatusRepository repository) {
        this.repository = repository;
    }

    public List<ResearchStatus> getAll() {
        return repository.findAll();
    }

    public Optional<ResearchStatus> getById(Integer id) {
        return repository.findById(id);
    }

    public ResearchStatus save(ResearchStatus status) {
        return repository.save(status);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
