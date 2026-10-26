
package com.group7.repository;

import com.group7.model.ResearchStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchStatusRepository
        extends JpaRepository<ResearchStatus, Integer> {
}
