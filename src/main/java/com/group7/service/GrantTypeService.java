package com.group7.service;

import com.group7.model.GrantType;
import com.group7.repository.GrantTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrantTypeService {

    private final GrantTypeRepository grantTypeRepository;

    public GrantTypeService(GrantTypeRepository grantTypeRepository) {
        this.grantTypeRepository = grantTypeRepository;
    }

    // Retrieve all grant types
    public List<GrantType> getAllGrantTypes() {
        return grantTypeRepository.findAll();
    }

    // Retrieve a grant type by ID
    public Optional<GrantType> getGrantTypeById(Integer id) {
        return grantTypeRepository.findById(id);
    }

    // Add or update a grant type
    public GrantType saveGrantType(GrantType grantType) {
        return grantTypeRepository.save(grantType);
    }

    // Delete a grant type by ID
    public void deleteGrantType(Integer id) {
        grantTypeRepository.deleteById(id);
    }
}
