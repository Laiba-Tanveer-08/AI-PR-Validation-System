package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.ValidationReport;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Sprint;
import com.aiprteam.backend.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationReportRepository extends JpaRepository<ValidationReport, Long> {

    List<ValidationReport> findByProject(Project project);
    List<ValidationReport> findBySprint(Sprint sprint);
    List<ValidationReport> findByRqr(Requirement rqr);
}