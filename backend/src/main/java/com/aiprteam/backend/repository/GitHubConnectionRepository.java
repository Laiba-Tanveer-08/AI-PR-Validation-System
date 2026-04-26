package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.*;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GitHubConnectionRepository extends JpaRepository<GitHubConnection,Long> {

    List<GitHubConnection> findByUser(User user);
    List<GitHubConnection> findByProject(Project project);

}
