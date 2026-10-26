
package com.group7.repository;

import com.group7.model.ResearchProjectSingle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchProjectSingleRepository
        extends JpaRepository<ResearchProjectSingle, String> {
}
