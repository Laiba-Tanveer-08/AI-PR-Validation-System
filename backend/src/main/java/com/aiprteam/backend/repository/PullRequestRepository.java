package com.aiprteam.backend.repository;
import com.aiprteam.backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PullRequestRepository extends JpaRepository<PullRequest, Long> {

   // List<PullRequest> findByProject(Project project);
    List<PullRequest> findBySprint(Sprint sprint);
    List<PullRequest> findByRqr(Requirement rqr);
}
