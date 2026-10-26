
package com.group7.repository;

import com.group7.model.ResearchProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchProjectRepository
        extends JpaRepository<ResearchProject, Integer> {
}
