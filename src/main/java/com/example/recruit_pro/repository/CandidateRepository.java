package com.example.recruit_pro.repository;

import com.example.recruit_pro.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    boolean existsByEmail(String email);
}
