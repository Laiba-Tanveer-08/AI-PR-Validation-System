package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

    List<Sprint> findByName(String name);
    List<Sprint> findByProject(Project project);
}