package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    List<Requirement> findBySprintIdAndSprintProjectUserId(Long sprintId, Long userId);
    Optional<Requirement> findByIdAndSprintProjectUserId(Long id, Long projectUserId);

    List<Requirement> findBySprintId(Long sprintId);
    //  List<Requirement> findByProject(Project project);
    // @Override
    // Optional<Requirement> findById(Long aLong);
}