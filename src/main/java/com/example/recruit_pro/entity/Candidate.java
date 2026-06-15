package com.example.recruit_pro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Integer age;

    @Column(name = "years_of_experience", nullable = false)
    private Integer yearsOfExperience;

    private String address;

    @Column(length = 200)
    private String bio;
}
