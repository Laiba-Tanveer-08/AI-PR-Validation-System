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
@Table(name = "GitHubConnection")
public class GitHubConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "repoUrl", nullable = false, unique = true)
    private String repoUrl;

    @Column(name = "webhookUrl", nullable = false, unique = true)
    private String webHookUrl;

    @Column(name = "webhookSecret", nullable = false, unique = true)
    private String webhookSecret;

    @Column(name = "repoName", nullable = false)
    private String data;

    @Column(name = "repoOwner", nullable = false)
    private String repoOwner;

    @Column(name = "accessToken", nullable = false)
    private String accessToken;

    @Column(name = "connectedAt", nullable = false)
    private LocalDateTime connectedAt;

    @Column(name = "lastSyncedAt", nullable = false)
    private LocalDateTime lastSyncedAt;

    // Tell active, ended? basically connection status
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name= "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;
}
