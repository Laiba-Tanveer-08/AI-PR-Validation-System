package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByName(String name);
    List<Project> findByUserId(Long userId);
    Optional<Project> findByIdAndUserId(Long projectId, Long userId);
}