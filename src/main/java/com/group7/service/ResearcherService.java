
package com.group7.service;

import com.group7.model.Researcher;
import com.group7.repository.ResearcherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearcherService {

    private final ResearcherRepository researcherRepository;

    public ResearcherService(ResearcherRepository researcherRepository) {
        this.researcherRepository = researcherRepository;
    }

    public List<Researcher> getAllResearchers() {
        return researcherRepository.findAll();
    }

    public Optional<Researcher> getResearcherById(Integer staffNo) {
        return researcherRepository.findById(staffNo);
    }

    public Researcher saveResearcher(Researcher researcher) {
        return researcherRepository.save(researcher);
    }

    public void deleteResearcher(Integer staffNo) {
        researcherRepository.deleteById(staffNo);
    }
}
