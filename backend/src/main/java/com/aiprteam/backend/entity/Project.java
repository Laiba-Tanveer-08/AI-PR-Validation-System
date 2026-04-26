package com.aiprteam.backend.entity;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import java.util.List;

@Entity
@Table(name="project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
    @OneToMany(mappedBy = "project")
    private List<GitHubConnection> gitHubConnections;
    @OneToMany(mappedBy="project")
    private List<Requirement> requirements;
    @OneToMany(mappedBy="project")
    private List<PullRequest> pullRequests;
    @OneToMany(mappedBy="project")
    private List<Sprint> sprints;
}
