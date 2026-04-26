package com.aiprteam.backend.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="name", nullable=false)
    private String name;
    @Column(name="email_address")
    private String emailAddress;
    @Column(name="phone_no")
    private String phoneNo;

}
