package com.aiprteam.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ValidationReport")
public class ValidationReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MissingFeatures")
    private String missingFeatures;

    @Column(name = "MatchedFeatures")
    private String matchedFeatures;

    @Column(name = "Improvements")
    private String improvements;

    // Tell matching score of requirements and pr features
    @Column(name = "score", nullable = false)
    private String score;

    @ManyToOne
    @JoinColumn(name= "pr_id")
    private PullRequest pr;

    @ManyToOne
    @JoinColumn(name= "rqr_id")
    private Requirement rqr;

    @ManyToOne
    @JoinColumn(name= "sprint_id")
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name= "project_id")
    private Project project;
}
