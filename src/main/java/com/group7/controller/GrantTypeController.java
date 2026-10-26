package com.group7.controller;

import com.group7.model.GrantType;
import com.group7.service.GrantTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grant-types")
public class GrantTypeController {

    private final GrantTypeService grantTypeService;

    public GrantTypeController(GrantTypeService grantTypeService) {
        this.grantTypeService = grantTypeService;
    }

    // GET: Retrieve all grant types
    @GetMapping
    public List<GrantType> getAllGrantTypes() {
        return grantTypeService.getAllGrantTypes();
    }

    // GET: Retrieve one grant type
    @GetMapping("/{id}")
    public ResponseEntity<GrantType> getGrantTypeById(
            @PathVariable Integer id) {

        return grantTypeService.getGrantTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Add a new grant type
    @PostMapping
    public GrantType createGrantType(@RequestBody GrantType grantType) {
        return grantTypeService.saveGrantType(grantType);
    }

    // PUT: Update an existing grant type
    @PutMapping("/{id}")
    public ResponseEntity<GrantType> updateGrantType(
            @PathVariable Integer id,
            @RequestBody GrantType updatedGrantType) {

        return grantTypeService.getGrantTypeById(id)
                .map(existingGrantType -> {
                    existingGrantType.setGrantTypeName(
                            updatedGrantType.getGrantTypeName());

                    GrantType saved = grantTypeService
                            .saveGrantType(existingGrantType);

                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Remove a grant type
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrantType(
            @PathVariable Integer id) {

        if (grantTypeService.getGrantTypeById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        grantTypeService.deleteGrantType(id);
        return ResponseEntity.noContent().build();
    }
}
