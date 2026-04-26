package com.aiprteam.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Requirement")
public class Requirement {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", nullable = false, unique = true)
    private String name;

   @Column(name = "description", nullable = false, unique = true)
   private String description;

    @ManyToOne
    @JoinColumn(name= "sprintId")
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name= "projectId")
    private Project project;

    @OneToMany(mappedBy = "rqr")
    private List<PullRequest> pullRequests;
}
