package com.aiprteam.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gitHub_connection")
public class GitHubConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "repo_url", nullable = false, unique = true)
    private String repoUrl;

    @Column(name = "webhook_url", nullable = false, unique = true)
    private String webHookUrl;

    @Column(name = "webhook_secret", nullable = false, unique = true)
    private String webhookSecret;

    @Column(name = "repo_name", nullable = false)
    private String repoName;

    @Column(name = "repo_owner", nullable = false)
    private String repoOwner;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "connected_at", nullable = false)
    private LocalDateTime connectedAt;

    @Column(name = "last_synced_at", nullable = false)
    private LocalDateTime lastSyncedAt;

    // Tell active, ended? basically connection status
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name= "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private Users user;
}
