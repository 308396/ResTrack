package com.group7.repository;

import com.group7.model.GrantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantTypeRepository
        extends JpaRepository<GrantType, Integer> {
}
