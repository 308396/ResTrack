package com.group7.controller;

import com.group7.model.Researcher;
import com.group7.service.ResearcherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/researchers")
public class ResearcherController {

    private final ResearcherService researcherService;

    public ResearcherController(ResearcherService researcherService) {
        this.researcherService = researcherService;
    }

    @GetMapping
    public List<Researcher> getAllResearchers() {
        return researcherService.getAllResearchers();
    }

    @GetMapping("/{staffNo}")
    public ResponseEntity<Researcher> getResearcherById(
            @PathVariable Integer staffNo) {
        return researcherService.getResearcherById(staffNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Researcher createResearcher(
            @RequestBody Researcher researcher) {
        return researcherService.saveResearcher(researcher);
    }

    @PutMapping("/{staffNo}")
    public ResponseEntity<Researcher> updateResearcher(
            @PathVariable Integer staffNo,
            @RequestBody Researcher updatedResearcher) {

        return researcherService.getResearcherById(staffNo)
                .map(existingResearcher -> {
                    existingResearcher.setResearcherName(
                            updatedResearcher.getResearcherName());

                    Researcher saved = researcherService
                            .saveResearcher(existingResearcher);

                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{staffNo}")
    public ResponseEntity<Void> deleteResearcher(
            @PathVariable Integer staffNo) {

        if (researcherService.getResearcherById(staffNo).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        researcherService.deleteResearcher(staffNo);
        return ResponseEntity.noContent().build();
    }
}
