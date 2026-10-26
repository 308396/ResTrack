
package com.group7.controller;

import com.group7.model.ResearchProjectSingle;
import com.group7.service.ResearchProjectSingleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/research-project")
public class ResearchProjectSingleController {

    private final ResearchProjectSingleService service;

    public ResearchProjectSingleController(
            ResearchProjectSingleService service) {
        this.service = service;
    }

    @GetMapping
    public List<ResearchProjectSingle> getAll() {
        return service.getAll();
    }

    @GetMapping("/{soCode}")
    public ResponseEntity<ResearchProjectSingle> getById(
            @PathVariable String soCode) {
        return service.getById(soCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResearchProjectSingle create(
            @RequestBody ResearchProjectSingle project) {
        return service.save(project);
    }

    @PutMapping("/{soCode}")
    public ResponseEntity<ResearchProjectSingle> update(
            @PathVariable String soCode,
            @RequestBody ResearchProjectSingle updated) {

        return service.getById(soCode)
                .map(existing -> {
                    existing.setResearchTitle(updated.getResearchTitle());
                    existing.setStartDate(updated.getStartDate());
                    existing.setExpectedDate(updated.getExpectedDate());
                    existing.setEndDate(updated.getEndDate());
                    existing.setGrantTypeId(updated.getGrantTypeId());
                    existing.setStaffNo(updated.getStaffNo());
                    existing.setStatusId(updated.getStatusId());

                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{soCode}")
    public ResponseEntity<Void> delete(
            @PathVariable String soCode) {
        if (service.getById(soCode).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.delete(soCode);
        return ResponseEntity.noContent().build();
    }
}
