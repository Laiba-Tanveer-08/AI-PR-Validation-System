package com.aiprteam.backend.repository;
import com.aiprteam.backend.entity.*;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PullRequestRepository extends JpaRepository<PullRequest, Long> {

    Optional<PullRequest> findByGithubPrId(Long githubPrId);

    List<PullRequest> findBySprintId(Long id);
}
