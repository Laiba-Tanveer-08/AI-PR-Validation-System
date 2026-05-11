package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.GitHubConnection;
import com.aiprteam.backend.entity.Project;
import com.aiprteam.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GitHubConnectionRepository extends JpaRepository<GitHubConnection, Long> {
    GitHubConnection findByRepoUrl(String repoUrl);
   // List<GitHubConnection> findByUser(Users user);
    List<GitHubConnection> findByUserId(Long userId);
    List<GitHubConnection> findByProjectId(Long projectId);
  //  List<GitHubConnection> findByProject(Project project);
}