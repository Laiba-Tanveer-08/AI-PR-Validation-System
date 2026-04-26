package com.aiprteam.backend.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="sprint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;
    @OneToMany(mappedBy = "sprint")
    private List<Requirement> requirements;
    @ManyToOne
    @JoinTable(name="project_id")
    private Project project;
}
