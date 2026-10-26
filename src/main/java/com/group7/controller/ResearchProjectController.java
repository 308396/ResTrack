
package com.group7.controller;

import com.group7.model.ResearchProject;
import com.group7.service.ResearchProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/research-projects")
public class ResearchProjectController {

    private final ResearchProjectService researchProjectService;

    public ResearchProjectController(
            ResearchProjectService researchProjectService) {
        this.researchProjectService = researchProjectService;
    }

    @GetMapping
    public List<ResearchProject> getAllResearchProjects() {
        return researchProjectService.getAllResearchProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResearchProject> getResearchProjectById(
            @PathVariable Integer id) {
        return researchProjectService.getResearchProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResearchProject createResearchProject(
            @RequestBody ResearchProject researchProject) {
        return researchProjectService.saveResearchProject(researchProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResearchProject> updateResearchProject(
            @PathVariable Integer id,
            @RequestBody ResearchProject updatedProject) {

        return researchProjectService.getResearchProjectById(id)
                .map(existingProject -> {
                    existingProject.setResearchTitle(
                            updatedProject.getResearchTitle());
                    existingProject.setGrantTypeId(
                            updatedProject.getGrantTypeId());
                    existingProject.setStaffNo(
                            updatedProject.getStaffNo());
                    existingProject.setResearchStatus(
                            updatedProject.getResearchStatus());
                    existingProject.setStartDate(
                            updatedProject.getStartDate());
                    existingProject.setExpectedDate(
                            updatedProject.getExpectedDate());
                    existingProject.setEndDate(
                            updatedProject.getEndDate());

                    ResearchProject saved =
                            researchProjectService.saveResearchProject(
                                    existingProject);

                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResearchProject(
            @PathVariable Integer id) {

        if (researchProjectService
                .getResearchProjectById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        researchProjectService.deleteResearchProject(id);
        return ResponseEntity.noContent().build();
    }
}
