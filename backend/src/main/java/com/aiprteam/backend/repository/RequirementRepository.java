package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Requirement;
import com.aiprteam.backend.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    List<Requirement> findBySprint(Sprint sprint);
    //  List<Requirement> findByProject(Project project);

    // @Override
    // Optional<Requirement> findById(Long aLong);
}