package com.aiprteam.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pull_request")
public class PullRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "ai_summary", length = 2000)
    private String aiSummary;

    @Column(name = "ai_score")
    private Double aiScore;

    @Column(name = "github_pr_id", nullable = false, unique = true)
    private Long gitHubPrId;

    // Tell pending, merged, rejected
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name= "sprint_id")
    private Sprint sprint;


}
