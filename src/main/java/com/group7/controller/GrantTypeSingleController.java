package com.group7.controller;

import com.group7.model.GrantTypeSingle;
import com.group7.service.GrantTypeSingleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grant-type")
public class GrantTypeSingleController {

    private final GrantTypeSingleService service;

    public GrantTypeSingleController(GrantTypeSingleService service) {
        this.service = service;
    }

    @GetMapping
    public List<GrantTypeSingle> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrantTypeSingle> getById(
            @PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GrantTypeSingle create(
            @RequestBody GrantTypeSingle grantType) {
        return service.save(grantType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrantTypeSingle> update(
            @PathVariable Integer id,
            @RequestBody GrantTypeSingle updated) {
        return service.getById(id)
                .map(existing -> {
                    existing.setGrantTypeName(updated.getGrantTypeName());
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
