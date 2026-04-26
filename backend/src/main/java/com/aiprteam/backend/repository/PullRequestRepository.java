package com.aiprteam.backend.repository;
import com.aiprteam.backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PullRequestRepository extends JpaRepository<PullRequest, Long> {

    List<PullRequest> findbyProject(Project project);
    List<PullRequest> findbySprint(Sprint sprint);
    List<PullRequest> findbyRequirement(Requirement rqr);
}
