package com.group7.service;

import com.group7.model.Staff;
import com.group7.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository repository;

    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }

    public List<Staff> getAll() {
        return repository.findAll();
    }

    public Optional<Staff> getById(Integer staffNo) {
        return repository.findById(staffNo);
    }

    public Staff save(Staff staff) {
        return repository.save(staff);
    }

    public void delete(Integer staffNo) {
        repository.deleteById(staffNo);
    }
}
