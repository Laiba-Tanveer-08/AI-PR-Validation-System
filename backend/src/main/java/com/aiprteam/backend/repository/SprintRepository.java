package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

    Optional<Sprint> findById(Long id);
    Optional<Sprint> findByIdAndProjectId(Long id, Long projectId);
    List<Sprint> findByProjectId(Long projectId);
}