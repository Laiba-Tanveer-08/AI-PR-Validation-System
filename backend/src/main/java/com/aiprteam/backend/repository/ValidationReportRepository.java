package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationReportRepository extends JpaRepository<ValidationReport, Long> {

    List<ValidationReport> findByProject(Project project);
    List<ValidationReport> findBySprint(Sprint sprint);
    List<ValidationReport> findByRequirement(Requirement rqr);


}
