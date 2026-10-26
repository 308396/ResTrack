
package com.group7.service;

import com.group7.model.ResearchProjectSingle;
import com.group7.repository.ResearchProjectSingleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchProjectSingleService {

    private final ResearchProjectSingleRepository repository;

    public ResearchProjectSingleService(
            ResearchProjectSingleRepository repository) {
        this.repository = repository;
    }

    public List<ResearchProjectSingle> getAll() {
        return repository.findAll();
    }

    public Optional<ResearchProjectSingle> getById(String soCode) {
        return repository.findById(soCode);
    }

    public ResearchProjectSingle save(
            ResearchProjectSingle researchProject) {
        return repository.save(researchProject);
    }

    public void delete(String soCode) {
        repository.deleteById(soCode);
    }
}
