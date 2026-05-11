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

  //  @Column(name = "data", nullable = false, unique = true)
    //private String data;

    @Column(name = "github_pr_id", nullable = false, unique = true)
    private String gitHubPrId;

    // Tell pending, merged, rejected
    @Column(name = "status", nullable = false)
    private String status;

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
