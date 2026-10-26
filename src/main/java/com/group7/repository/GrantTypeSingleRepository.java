package com.group7.repository;

import com.group7.model.GrantTypeSingle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantTypeSingleRepository
        extends JpaRepository<GrantTypeSingle, Integer> {
}
