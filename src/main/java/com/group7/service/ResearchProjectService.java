
package com.group7.service;

import com.group7.model.ResearchProject;
import com.group7.repository.ResearchProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchProjectService {

    private final ResearchProjectRepository researchProjectRepository;

    public ResearchProjectService(
            ResearchProjectRepository researchProjectRepository) {
        this.researchProjectRepository = researchProjectRepository;
    }

    public List<ResearchProject> getAllResearchProjects() {
        return researchProjectRepository.findAll();
    }

    public Optional<ResearchProject> getResearchProjectById(Integer id) {
        return researchProjectRepository.findById(id);
    }

    public ResearchProject saveResearchProject(
            ResearchProject researchProject) {
        return researchProjectRepository.save(researchProject);
    }

    public void deleteResearchProject(Integer id) {
        researchProjectRepository.deleteById(id);
    }
}
