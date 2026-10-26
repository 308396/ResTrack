package com.group7.controller;

import com.group7.model.Staff;
import com.group7.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping
    public List<Staff> getAll() {
        return service.getAll();
    }

    @GetMapping("/{staffNo}")
    public ResponseEntity<Staff> getById(
            @PathVariable Integer staffNo) {
        return service.getById(staffNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return service.save(staff);
    }

    @PutMapping("/{staffNo}")
    public ResponseEntity<Staff> update(
            @PathVariable Integer staffNo,
            @RequestBody Staff updated) {
        return service.getById(staffNo)
                .map(existing -> {
                    existing.setStaffName(updated.getStaffName());
                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{staffNo}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer staffNo) {
        if (service.getById(staffNo).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.delete(staffNo);
        return ResponseEntity.noContent().build();
    }
}
