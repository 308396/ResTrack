package com.group7.controller;

import com.group7.model.ResearchStatus;
import com.group7.service.ResearchStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/research-status")
public class ResearchStatusController {

    private final ResearchStatusService service;

    public ResearchStatusController(ResearchStatusService service) {
        this.service = service;
    }

    @GetMapping
    public List<ResearchStatus> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResearchStatus> getById(
            @PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResearchStatus create(@RequestBody ResearchStatus status) {
        return service.save(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResearchStatus> update(
            @PathVariable Integer id,
            @RequestBody ResearchStatus updated) {
        return service.getById(id)
                .map(existing -> {
                    existing.setStatusName(updated.getStatusName());
                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
